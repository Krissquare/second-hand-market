package com.team.springboot.controller;



import com.team.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class ForgotController {

    @Autowired
    UserService userService;


    @RequestMapping("/forgot")
    public String forget() {
        return "html/forgot";
    }

    @PostMapping("/forget/isEmailRegistered")
    public String isEmailRegistered(@RequestParam("u_Email") String email) {
        if(userService.selectUserByEmail(email) == null){
            return "redirect:/forgot";
        }
        else {
            return "redirect:/forgot/verify";
        }
    }

    @RequestMapping("/forgot/verify")
    public String verify() {
        return "html/verify";
    }

}
