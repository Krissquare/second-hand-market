package com.team.springboot.controller;


import com.team.springboot.pojo.Cipher;
import com.team.springboot.pojo.User;
import com.team.springboot.service.UserService;
import com.team.springboot.utils.SendVerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;


@Controller
public class ForgotController {

    @Autowired
    UserService userService;

    //忘记密码界面
    @RequestMapping("/forgot")
    public String forget() {
        return "html/forgot";
    }

    //忘记密码后邮箱验证
    @RequestMapping("/verify")
    public String verify(HttpSession session) {
        if(session.getAttribute("isEmailRegistered").equals(true)) {
            if(session.getAttribute("VerificationCode") == null) {
                SendVerificationCode service = new SendVerificationCode();
                session.setAttribute("VerificationCode", service.sendMessage((String) session.getAttribute("emailNeedToChangePassword")));
            }
            return "/html/verify";
        }
        else
            return "redirect:/forgot";
    }

    //验证后修改密码
    @RequestMapping("/changePassword")
    public String changePassword(HttpSession session) {
        if(session.getAttribute("isValidCode").equals(true))
            return "/html/changePassword";
        else
            return "redirect:/verify";
    }

    //判断用户输入的邮箱是否是注册过的邮箱
    @PostMapping("/forget/isEmailRegistered")
    public String isEmailRegistered(@RequestParam("u_Email") String email, HttpSession session) {
        session.setAttribute("emailNeedToChangePassword", email);
        if(userService.selectUserByEmail(email) == null) {
            session.setAttribute("isEmailRegistered", false);
            return "redirect:/forgot";
        }
        else {
            session.setAttribute("isEmailRegistered", true);
            return "redirect:/verify";
        }
    }

    //确认验证码是否正确
    @PostMapping("/verify/isValidCode")
    public String isValidCode(@RequestParam("u_Code") String code, HttpSession session) {
        session.setAttribute("UserVerificationCode", code);
        if(!code.equals(session.getAttribute("VerificationCode"))) {
            session.setAttribute("isValidCode", false);
            return "redirect:/verify";
        }
        else {
            session.setAttribute("isValidCode", true);
            return "redirect:/changePassword";
        }
    }

    //修改密码后的跳转
    @PostMapping("/changePassword/isValidPassword")
    public String changePassword(@RequestParam("u_Password") String passWord,
                                 @RequestParam("u_RePassword") String rePassWord,
                                 HttpSession session) {
        if(!passWord.equals(rePassWord)) {
            session.setAttribute("isSuccessfulModification", false);
            return "redirect:/changePassword";
        }
        else {
            User user = userService.selectUserByEmail((String) session.getAttribute("emailNeedToChangePassword"));
            String psw = passWord;
            if ( !Cipher.isInWhiteList((String) session.getAttribute("u_Account")) )
                psw = Cipher.Encipher(passWord);
            user.setU_Password(psw);
            userService.updatePwd(user);

            session.setAttribute("isSuccessfulModification", true);
            session.removeAttribute("emailNeedToChangePassword");
            session.removeAttribute("UserVerificationCode");
            session.removeAttribute("isEmailRegistered");
            session.removeAttribute("isValidCode");
            session.removeAttribute("isValidPassword");
            return "redirect:/login";
        }
    }

}
