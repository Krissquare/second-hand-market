package com.team.springboot.controller;


import com.team.springboot.pojo.ShoppingCarProduct;
import com.team.springboot.service.ShoppingCarService;
import com.team.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class SignInController {
    @Autowired
    UserService userService;

    @Autowired
    ShoppingCarService shoppingCarService;

    private List<ShoppingCarProduct> shoppingCartList;

    private boolean signInFlag = false;

    private double  shoppingCarPrice = 0;

    private void setLoginState(String account) {
        if (account != null) {
            signInFlag = true;
            shoppingCartList  = shoppingCarService.selectShoppingCarProductById(account);
            for (ShoppingCarProduct ele : shoppingCartList)
                shoppingCarPrice += ele.getP_Price();
        } else
            signInFlag = false;

    }

    @RequestMapping("/login")
    public String login() {
        return "html/login";
    }

    @PostMapping("/user/login")
    public String loginin(@RequestParam("u_Account") String account,
                          @RequestParam("u_Password") String password,
                          HttpSession session) {


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
        } else {
            session.setAttribute("msg", "用户名或密码错误");
            return "redirect:/login";
        }
    }
}
