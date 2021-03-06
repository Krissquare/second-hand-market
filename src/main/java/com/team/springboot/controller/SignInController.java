package com.team.springboot.controller;

import com.team.springboot.pojo.BaseResponse;
import com.team.springboot.pojo.Cipher;
import com.team.springboot.service.ShoppingCarService;
import com.team.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;


@Controller
public class SignInController {

    @Autowired
    UserService userService;

    @Autowired
    ShoppingCarService shoppingCarService;


    @RequestMapping("/login")
    public String login() {
        return "html/login";
    }

    @RequestMapping("/logout")
    public String logout( HttpSession session) {
       session.removeAttribute("u_Account");
        return "redirect:/";
    }


    //用户登录功能控制
    @PostMapping("/user/login")
    public String loginin(@RequestParam("u_Account") String account, @RequestParam("u_Password") String originPassword, HttpSession session) {
        String password = Cipher.isInWhiteList(account) ? originPassword : Cipher.Encipher(originPassword);
        session.removeAttribute("isSuccessfulRegistration");
        session.removeAttribute("isSuccessfulModification");
        if(userService.selectUserById(account) == null){
            session.setAttribute("msg","用户名不存在");
            return "redirect:/login";
        }
        if(!userService.selectUserById(account).getU_Password().equals(password))
        {
            session.setAttribute("msg","密码错误");
            return "redirect:/login";
        }
        if(userService.selectUserById(account).getU_Password().equals(password) && !userService.selectUserById(account).getU_Account().equals("admin")){
            session.setAttribute("u_Account",account);
            session.setAttribute("url", userService.selectUserById(account).getU_Url());
            session.setAttribute("shoppingCartList", shoppingCarService.selectShoppingCarProductById(account));
            session.setAttribute("shoppingCarPrice", shoppingCarService.getTotalPrice(account));
            return "redirect:/";
        } else if (userService.selectUserById(account).getU_Password().equals(password) && userService.selectUserById(account).getU_Account().equals("admin")) {
            session.setAttribute("u_Account",account);
            session.setAttribute("url", userService.selectUserById(account).getU_Url());
            session.setAttribute("shoppingCartList", shoppingCarService.selectShoppingCarProductById(account));
            session.setAttribute("shoppingCarPrice", shoppingCarService.getTotalPrice(account));
            return "redirect:/admin/userinit";
        } else {
            session.setAttribute("msg", "用户名或密码错误");
            return "redirect:/login";
        }
    }
}
