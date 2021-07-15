package com.team.springboot.controller;

import com.team.springboot.pojo.Address;
import com.team.springboot.pojo.BaseResponse;
import com.team.springboot.pojo.Order;
import com.team.springboot.pojo.UserHead;
import com.team.springboot.service.OrderService;
import com.team.springboot.service.UserHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    UserHeadService userHeadService;

    //订单状态修改转跳
    @RequestMapping("/OrderStatusInit")
    public String OrderStatusInit(){

        return "admin/OrderStatusUpdate";
    }

    //订单收货地址修改页面转跳
    @RequestMapping("/OrderAddressUpdate")
    public String OrderAddressUpdate(){
        return "admin/OrderAddressUpdate";
    }

    //买入-订单转跳
    @RequestMapping("/BuyOrderInit")
    public String BuyOrderInit(HttpSession session,Model m){
        String account = (String) session.getAttribute("u_Account");
        UserHead userHead = userHeadService.selectHead(account);
        m.addAttribute("userHead", userHead);
        return "admin/BuyOrder";
    }
    //买入-订单表格初始化
    @RequestMapping("/BuyOrderInfo")
    @ResponseBody
    public BaseResponse BuyOrderInfo(HttpServletRequest req, Model m, int page, int limit){
        BaseResponse<List<Order>> baseResponse = new BaseResponse<>();
        String account = (String)req.getSession().getAttribute("u_Account");
        int count = orderService.orderBuyerCount(account);
        String SearchName = req.getParameter("SearchName");
        String Search = "%" + SearchName + "%";
        System.out.println(SearchName);

        if(SearchName == null){
            System.out.println("test");
            List<Order> list = orderService.selectOrderAndProductBuy(account);
            req.getSession().setAttribute("StatusCode1","Buy");
            req.getSession().setAttribute("StatusCode2","Buy");
            baseResponse.setCode(0);
            baseResponse.setData(list);
            baseResponse.setCount(count);
            return baseResponse;
        }

        List<Order> list1 = orderService.selectOrderAndProductBuyBySearchName(account, Search, (page - 1) * limit, limit);
        baseResponse.setCode(0);
        baseResponse.setData(list1);
        baseResponse.setCount(count);
        return baseResponse;

    }

    //出售-订单转跳
    @RequestMapping("/SellOrderInit")
    public String SellOrderInit(HttpSession session,Model m){
        String account = (String) session.getAttribute("u_Account");
        UserHead userHead = userHeadService.selectHead(account);
        m.addAttribute("userHead", userHead);
        return "admin/SellOrder";
    }
    //出售-订单表格初始化
    @RequestMapping("/SellOrderInfo")
    @ResponseBody
    public BaseResponse SellOrderInfo(HttpServletRequest req, int page, int limit){
        BaseResponse<List<Order>> baseResponse = new BaseResponse<>();
        String account = (String)req.getSession().getAttribute("u_Account");
        int count = orderService.orderSellerCount(account);
        List<Order> list = orderService.selectOrderAndProductSell(account);
        String SearchName = req.getParameter("SearchName");
        String Search = "%" + SearchName + "%";

        if(SearchName == null){
            req.getSession().setAttribute("StatusCode2","Sell");
            req.getSession().setAttribute("StatusCode1","Sell");
            baseResponse.setCode(0);
            baseResponse.setData(list);
            baseResponse.setCount(count);
            return baseResponse;
        }

        List<Order> list1 = orderService.selectOrderAndProductSellBySearchName(account, Search, (page - 1) * limit, limit);
        baseResponse.setCode(0);
        baseResponse.setData(list1);
        baseResponse.setCount(count);
        return baseResponse;
    }

    //收货地址下拉框动态赋值
    @RequestMapping("/selectValue")
    @ResponseBody
    public BaseResponse selectAddressValue(HttpSession session){
        BaseResponse<List<String>> baseResponse = new BaseResponse<>();
        String account = (String)session.getAttribute("u_Account");
        Address a =  orderService.selectAddressValue(account);
        List<String> list = new ArrayList<>();
        list.add(a.getA_Address1());
        list.add(a.getA_Address2());
        list.add(a.getA_Address3());
        list.add(a.getA_Address4());

        baseResponse.setCode(200);
        baseResponse.setData(list);
        return baseResponse;

    }

    //收货地址更改
    @RequestMapping(value = "/orderChange", method = {RequestMethod.POST})
    @ResponseBody
    public BaseResponse orderChange(@RequestBody Order o){
        BaseResponse<Integer> baseResponse = new BaseResponse<>();

        if(o.getO_Baddress().equals("请选择")){
            baseResponse.setCode(500);
            baseResponse.setMsg("收货地址不能为空");
            return baseResponse;
        }

        orderService.addressUpdate(o.getO_Baddress(),o.getO_Id());
        baseResponse.setCode(200);
        baseResponse.setMsg("保存成功");

        return baseResponse;
    }

    //删除订单
    @RequestMapping("/deleteOrder")
    @ResponseBody BaseResponse deleteOrder(@RequestBody Order o){
        BaseResponse<Integer> baseResponse = new BaseResponse<>();

        if(o == null){
            baseResponse.setCode(500);
            baseResponse.setMsg("订单不存在，删除失败！");
            return baseResponse;
        }

        if(o.getO_Status().equals("0")){// 卖家未发货，不能删除
            baseResponse.setCode(500);
            baseResponse.setMsg("删除失败！尚未发货");
            return baseResponse;
        }else if(o.getO_Status().equals("1")){
            baseResponse.setCode(500);
            baseResponse.setMsg("删除失败！尚未收货");
            return baseResponse;
        }



        orderService.deleteOrderById(o);
        baseResponse.setCode(200);
        baseResponse.setMsg("删除成功!");
        return baseResponse;
    }
    //订单状态更改
    @RequestMapping("/orderStatusUpdate")
    @ResponseBody
    public BaseResponse orderStatusUpdate(@RequestBody Order o){
        BaseResponse<Integer> baseResponse = new BaseResponse<>();

        if(o.getO_Buyer() != null && o.getO_Seller() == null && !o.getO_Buyer().equals("")){ // 是买家操作订单状态
            if(o.getO_Status().equals("未发货")){
                baseResponse.setCode(500);
                baseResponse.setMsg("卖家尚未发货！收货失败");
                return baseResponse;
            }else if(o.getO_Status().equals("已发货")){
                baseResponse.setCode(200);
                baseResponse.setMsg("收货成功");
                o.setO_Status("3"); // 修改为收货状态码 3
                orderService.StatusUpdate(o);
                return baseResponse;
            }else if(o.getO_Status().equals("已收货")){
                baseResponse.setCode(500);
                baseResponse.setMsg("订单已完成交易,不需重复收货！");
                return baseResponse;
            }
        }


        if(o.getO_Seller() != null && o.getO_Buyer() == null && !o.getO_Seller().equals("")){  // 是卖家操作订单
            if(o.getO_Status().equals("已发货")){
                baseResponse.setCode(500);
                baseResponse.setMsg("操作失败！请不要重复发货");
                return baseResponse;
            }else if(o.getO_Status().equals("未发货")){
                baseResponse.setCode(200);
                baseResponse.setMsg("发货成功");
                o.setO_Status("1");
                orderService.StatusUpdate(o);
                return baseResponse;
            }else if(o.getO_Status().equals("已收货")){
                baseResponse.setCode(500);
                baseResponse.setMsg("操作失败！订单已完成交易");
                return baseResponse;
            }
        }

        baseResponse.setCode(500);
        baseResponse.setMsg("请求失败");
        return baseResponse;
    }
}
