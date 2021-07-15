package com.team.springboot.controller.exhibition;

import com.team.springboot.pojo.*;
import com.team.springboot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class GoodsDetailController   {
   @Autowired ProductCategoryService productCategoryService;

   @Autowired ProductService productService;

   @Autowired ShoppingCarService shoppingCarService;

   @Autowired GoodsService goodsService;

   @Autowired OrderService orderService;

    @Autowired
    private UserService userService;

   //商品信息页面初始化
   @RequestMapping("/goodsDetail")
    public  String goodsDetail(@RequestParam("pid") String pid, Model model){
       Product p  = productService.selectById(Integer.valueOf(pid));
       model.addAttribute("product",p);
       return "html/single-product";
   }

   //添加商品到购物车
   @PostMapping("/addIntoShoppingCar")
   public String shoppingCar(@RequestParam("p_Id") int p_Id,@RequestParam("quant[1]")int num, HttpSession session){
       String account = (String) session.getAttribute("u_Account");

       if(account == null)
           return "redirect:/login";
       ShoppingCar sc=shoppingCarService.selectByAccountId(account,p_Id);
       if(sc==null) {
           shoppingCarService.insertOne(account, p_Id);//添加商品p到购物车
           session.setAttribute("shoppingCartList", shoppingCarService.selectShoppingCarProductById(account));
           session.setAttribute("shoppingCarPrice", shoppingCarService.getTotalPrice(account));
       }
       else
           shoppingCarService.updateByAccountId(account,p_Id,num);

       return "redirect:/goodsDetail?pid=" + p_Id;
   }

   //打开购物车
   @RequestMapping("/showShoppingCar")
   public String showShoppingCar(){

       return "html/cart";
   }

   //购买商品layer初始化
   @RequestMapping("/buyGoodsInit")
   public String buyGoodsInit(@RequestParam("p_Id") String p_Id, HttpServletRequest req, Model m){
       System.out.println(p_Id);
        String account = (String)req.getSession().getAttribute("u_Account");
        Product p = goodsService.selectProduct(Integer.valueOf(p_Id));
        Address a  = orderService.selectAddressValue(account);
        List<String> list = new ArrayList<>();

        m.addAttribute("product",p);
        list.add(a.getA_Address1());
        list.add(a.getA_Address2());
        list.add(a.getA_Address3());
        list.add(a.getA_Address4());
        m.addAttribute("list",list);
        return "html/checkout";

   }


   //购买商品
   @RequestMapping("/buyGoods")
   @ResponseBody
   public BaseResponse buyGoods(@RequestBody BuyOrderInfo b, HttpServletRequest req){
       BaseResponse<Integer> baseResponse = new BaseResponse<>();
       String account = (String)req.getSession().getAttribute("u_Account");
       Order o = new Order(); // 要插入到订单表里的实体
       int count = orderService.selectOrderCount();


       Product product = productService.selectProductById(b.getP_Id());
           product.setP_num(product.getP_num()-1);
           productService.updateProduct(product);

       Address address1 = userService.selectAddressAll(product.getP_Account());


       if(account == null || account.equals("")){
           baseResponse.setCode(500);
           baseResponse.setMsg("请登录账号");
           return baseResponse;
       }
       o.setO_Id("o" + (count+1));
       o.setO_ItemId(b.getP_Id());
       o.setO_Buyer(account);
       o.setO_Seller(b.getO_Seller());
       o.setO_Date(String.format("%tF",new Date()));//java的Date和sql的date用哪个
       o.setO_Saddress(address1.getA_Address1());
       o.setO_Baddress(b.getO_Baddress());
       o.setO_Status("0");
       orderService.insertOne(o);
       if(b.getO_Baddress().equals("无"))
       {
           baseResponse.setCode(500);
           baseResponse.setMsg("收货地址不能为空");
           return baseResponse;
       }
       if(String.valueOf(b.getS_Id()) != null){
           shoppingCarService.deleteById(b.getS_Id());
       }
       baseResponse.setCode(200);
       baseResponse.setMsg("购买成功");
       return baseResponse;
   }
}
