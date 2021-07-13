package com.team.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class checkOutController {
    @RequestMapping("/checkOutWithSingleProduct")
    public String checkOutWithSingleProductProcessor(@RequestParam("pid") String pid, Model model){
        System.out.println(pid);//debug
        return "html/checkout";
    }
}
