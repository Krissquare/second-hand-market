package com.team.springboot.controller;


import com.team.springboot.pojo.BaseResponse;
import com.team.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class SignInController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "html/login";
    }

    @PostMapping("/user/login")
    public String loginin(@RequestParam("u_Account") String account,
                          @RequestParam("u_Password") String password,
                          //@RequestParam("checkCode") String checkCode,
                          HttpSession session) {
        //   if(!session.getAttribute("imageCode").equals(checkCode)){
        //       session.setAttribute("msg","验证码不正确");
        //        return "redirect:/login";
        //    }

        if(userService.selectUserById(account) == null){
            session.setAttribute("msg","用户名或密码错误");
            return "redirect:/login";
        }

        if(userService.selectUserById(account).getU_Password().equals(password) && !userService.selectUserById(account).getU_Account().equals("admin")){
            session.setAttribute("u_Account",account);
            session.setAttribute("url", userService.selectUserById(account).getU_Url());
            return "redirect:/";
        } else if (userService.selectUserById(account).getU_Password().equals(password) && userService.selectUserById(account).getU_Account().equals("admin")) {
            session.setAttribute("u_Account",account);
            session.setAttribute("url", userService.selectUserById(account).getU_Url());
            return "redirect:/admin/userinit";
        } else {//
            session.setAttribute("msg", "用户名或密码错误");
            return "redirect:/login";
        }
    }
}
