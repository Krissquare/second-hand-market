package com.team.springboot.controller;

import com.team.springboot.pojo.BaseResponse;
import com.team.springboot.pojo.Order;
import com.team.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class ExpressController {

    @Autowired
    private OrderService orderService;

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

//        System.out.println(orderID);
        return "redirect:/showMyTransactionOrders";
    }

    @RequestMapping("/HasReceived")
    public String hasReceived(@RequestParam("o_Id")String orderID, HttpSession session){
//        System.out.println(orderID);
        Order order = new Order();
        order.setO_Id(orderID);
        order.setO_Status("已收货");
        orderService.StatusUpdate(order);

        return "redirect:/showMyTransactionOrders";
    }

}
