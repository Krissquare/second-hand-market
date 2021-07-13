package com.team.springboot.controller;

import com.team.springboot.pojo.Product;
import com.team.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class checkOutController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/checkOutWithSingleProduct")
    public String checkOutWithSingleProductProcessor(@RequestParam("pid") String pid, Model model){
//        System.out.println(pid);//debug
        Product p  = productService.selectById(Integer.valueOf(pid));
        model.addAttribute("product",p);
        return "html/checkout";
    }

    @RequestMapping("/buyOneProduct")
    public String buyOneProduct(){

        return "html/index";
    }
}
