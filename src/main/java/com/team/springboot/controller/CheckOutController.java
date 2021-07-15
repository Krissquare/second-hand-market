package com.team.springboot.controller;

import com.team.springboot.pojo.Address;
import com.team.springboot.pojo.Order;
import com.team.springboot.pojo.Product;
import com.team.springboot.service.OrderService;
import com.team.springboot.service.ProductService;
import com.team.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class CheckOutController {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;


    @PostMapping("/checkOutWithSingleProduct")
    public String checkOutWithSingleProductProcessor(@RequestParam("pid") String pid,
                                                     Model model,
                                                     HttpSession session
    ){
        String account = (String) session.getAttribute("u_Account");
        if(account == null)
            return "redirect:/login";
//        System.out.println(pid);//debug
        Product p  = productService.selectById(Integer.valueOf(pid));
        model.addAttribute("product",p);
        return "html/checkout";
    }

    @RequestMapping("/buyOneProduct")
    public String buyOneProduct(@RequestParam("u_Address") String address,
                                @RequestParam("pid") String pid,
                                HttpSession session){
        String account = (String) session.getAttribute("u_Account");
        String orderId = "o" + String.valueOf( orderService.selectOrderCount() + 1);//新订单编号-递增规则
        int p_id = Integer.valueOf(pid);

        Product product = productService.selectProductById(p_id);
        Order newOrder = new Order();
        Address address1 = userService.selectAddressAll(product.getP_Account());

        newOrder.setO_Buyer(account);
        newOrder.setO_Seller(product.getP_Account());
        newOrder.setO_Id(orderId);
        newOrder.setO_Baddress(address);
        newOrder.setO_ItemId(Integer.valueOf(pid));
        newOrder.setO_Status("1");//o_Status什么意思
        newOrder.setO_Date(String.format("%tF",new Date()));//java的Date和sql的date用哪个
        newOrder.setO_Saddress(address1.getA_Address1());

        orderService.insertOne(newOrder);

        if (product.getP_num() > 1){
            product.setP_num(product.getP_num()-1);
            productService.updateProduct(product);
        }else{
            productService.deleteProductById(product.getP_Id());
        }

        System.out.println("新订单--");//debug
        System.out.println("订单号:"+orderId);
        System.out.println("商品号:"+pid);
        System.out.println("卖家账号:"+product.getP_Account());
        System.out.println("买家账号:"+account);
        System.out.println("地址:"+address);
        System.out.println("商品剩余:"+product.getP_num());
        System.out.println("--新订单");
        return "html/buySuccessfully";
    }
}
