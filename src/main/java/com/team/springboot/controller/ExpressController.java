package com.team.springboot.controller;

import com.team.springboot.pojo.*;
import com.team.springboot.service.OrderService;
import com.team.springboot.service.ProductService;
import com.team.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class ExpressController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    //加入物流信息
    @RequestMapping("/AddExpressID")
    public String addExpressID(@RequestParam("o_Id") String orderID,
                               @RequestParam("exp_Id") String expressID,
                               HttpSession session
    ){
        //写入物流信息
        orderService.updateExpressIdById(orderID,expressID);
        //修改订单状态
        Order order = new Order();
        order.setO_Id(orderID);
        order.setO_Status("已发货");
        orderService.StatusUpdate(order);

        return "redirect:/showMyTransactionOrders";
    }

    //确认收货
    @RequestMapping("/HasReceived")
    public String hasReceived(@RequestParam("o_Id")String orderID, HttpSession session){
        Order order = orderService.selectByOrderID(orderID);
        //修改订单状态
        order.setO_Status("已收货");
        orderService.StatusUpdate(order);

        Product product = productService.selectProductById(order.getO_ItemId());
        User userSeller = userService.selectUserById(order.getO_Seller());

        //钱打到卖家账号上
        userSeller.setWallet(userSeller.getWallet() + product.getP_Price());
        userService.updateWallet(userSeller);

        return "redirect:/showMyTransactionOrders";
    }

}
