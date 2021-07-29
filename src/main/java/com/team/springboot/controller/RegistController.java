package com.team.springboot.controller;


import com.team.springboot.pojo.BaseResponse;
import com.team.springboot.pojo.Cipher;
import com.team.springboot.pojo.User;
import com.team.springboot.pojo.UserHead;
import com.team.springboot.service.AddressService;
import com.team.springboot.service.UserHeadService;
import com.team.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
public class RegistController {

    @Autowired
    UserService userService;

    @RequestMapping("/registration")
        public String init() {
            return "html/registration";
    }


    //注册一个新用户
    @PostMapping("/registration/add")
    public String registerAdd(@RequestParam("u_Sex") String sex,
                              @RequestParam("u_Name") String name,
                              @RequestParam("u_Account") String account,
                              @RequestParam("u_Phone") String phone,
                              @RequestParam("u_Email") String email,
                              @RequestParam("u_Password") String password,
                              @RequestParam("u_RePassword") String rePassword,
                              HttpSession session
                              ){
        if(userService.selectUserById(account) != null){
            session.setAttribute("isValidRegisteredAccount", false);
            return "redirect:/registration";
        }
        else if(userService.selectUserByEmail(email) != null) {
            session.setAttribute("isValidRegisteredEmail", false);
            return "redirect:/registration";
        }
        else if(!password.equals(rePassword)) {
            session.setAttribute("isValidRegisteredPassword", false);
            return "redirect:/registration";
        }
        else {
            userService.insertOne(new User(account, name, password, email, sex, phone));
            session.setAttribute("isSuccessfulRegistration", true);
            session.removeAttribute("isValidRegisteredAccount");
            session.removeAttribute("isValidRegisteredEmail");
            session.removeAttribute("isValidRegisteredPassword");
            return "redirect:/login";
        }

    }
}
