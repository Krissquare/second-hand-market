package com.team.springboot.controller.exhibition;

import com.team.springboot.pojo.*;
import com.team.springboot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GoodsDetailController   {
   @Autowired ProductCategoryService productCategoryService;

   @Autowired ProductService productService;

   @Autowired ShoppingCarService shoppingCarService;

   @Autowired GoodsService goodsService;

   @Autowired OrderService orderService;

   //商品信息页面初始化
   @RequestMapping("/goodsDetail")
    public  String goodsDetail(@RequestParam("pid") String pid, Model model){
       Product p  = productService.selectById(Integer.valueOf(pid));
       model.addAttribute("product",p);
       return "html/single-product";
   }

   //添加商品到购物车
   @RequestMapping("/shoppingCar")
   @ResponseBody
   public BaseResponse shoppingCar(@RequestBody Product p, HttpSession session){
       BaseResponse<Integer> baseResponse = new BaseResponse<>();
       String account = (String) session.getAttribute("u_Account");
       System.out.println(account);
       if(account == null || account.equals("")){
           baseResponse.setCode(500);
           baseResponse.setMsg("请登录账号");
           System.out.println("cesi");
           return baseResponse;
       }
       shoppingCarService.insertOne(account,p.getP_Id());//添加商品p到购物车
       System.out.println(p.getP_Id());
       baseResponse.setCode(200);
       baseResponse.setMsg("添加成功");
       return  baseResponse;
   }


   //购买商品layer初始化
   @RequestMapping("/buyGoodsInit")
   public String buyGoodsInit(@RequestParam("p_Id") String p_Id, HttpServletRequest req, Model m){
       System.out.println(p_Id);
        String account = (String)req.getSession().getAttribute("u_Account");
        Product p = goodsService.selectProduct(Integer.valueOf(p_Id));
        Address a  = orderService.selectAddressValue(account);
        List<String> list = new ArrayList<>();

        m.addAttribute("p",p);
        list.add(a.getA_Address1());
        list.add(a.getA_Address2());
        list.add(a.getA_Address3());
        list.add(a.getA_Address4());
        m.addAttribute("list",list);
        return "admin/BuyGoods";

   }


   //购买商品
   @RequestMapping("/buyGoods")
   @ResponseBody
   public BaseResponse buyGoods(@RequestBody BuyOrderInfo b, HttpServletRequest req){
       BaseResponse<Integer> baseResponse = new BaseResponse<>();
       String account = (String)req.getSession().getAttribute("u_Account");
       //String test=(String)req.getSession().getAttribute("")
       Order o = new Order(); // 要插入到订单表里的实体
       int count = orderService.selectOrderCount();

       if(account == null || account.equals("")){
           baseResponse.setCode(500);
           baseResponse.setMsg("请登录账号");
           return baseResponse;
       }

       o.setO_Id("o" + (count+1));
       o.setO_ItemId(b.getP_Id());
       o.setO_Buyer(account);
       o.setO_Seller(b.getO_Seller());
       //2021.7.7
       if(b.getO_Baddress().equals("无"))
       {
           baseResponse.setCode(500);
           baseResponse.setMsg("收货地址不能为空");
           return baseResponse;
       }
       //
       o.setO_Baddress(b.getO_Baddress());
       o.setO_Status("0");//这个status不知道是什么，但这里默认设置为0
       orderService.insertOne(o);
       if(String.valueOf(b.getS_Id()) != null){
           shoppingCarService.deleteById(b.getS_Id());
       }
       baseResponse.setCode(200);
       baseResponse.setMsg("购买成功");
       return baseResponse;
   }
}
