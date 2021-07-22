package com.team.springboot.controller;

import com.team.springboot.pojo.BaseResponse;
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

    @RequestMapping("/AddRequestID")
    public BaseResponse addExpressID(@RequestParam("") String orderID,
                                       @RequestParam("") String expressID,
                                       HttpSession session
                                       ){
        BaseResponse baseResponse = new BaseResponse();
        orderService.updateExpressIdById(orderID,expressID);

        baseResponse.setCode(200);
        baseResponse.setMsg("成功");
        return baseResponse;
    }

    @RequestMapping("/GetExpressID")
    public BaseResponse getExpressID(@RequestParam("")String orderID, HttpSession session){
        BaseResponse baseResponse = new BaseResponse();
        String expressID = orderService.selectExpressIdById(orderID);

        baseResponse.setMsg(expressID);
        baseResponse.setCode(200);
        return baseResponse;
    }

}
