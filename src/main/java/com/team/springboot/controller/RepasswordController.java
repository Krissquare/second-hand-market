package com.team.springboot.controller;

import com.team.springboot.pojo.BaseResponse;
import com.team.springboot.pojo.User;
import com.team.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/repwd")
public class RepasswordController {

    @Autowired
    UserService userService;

    @RequestMapping("/init")
    public String init() {
        return "admin/re_check_password";
    }

    @RequestMapping(value = "/check", method = {RequestMethod.POST} )
    @ResponseBody
    public BaseResponse checkEmail(@RequestBody User u,
                                   HttpSession session){
        BaseResponse<Integer> baseResponse = new BaseResponse<Integer>();
        if(userService.selectUserById(u.getU_Account()) == null){
            baseResponse.setCode(500);
            baseResponse.setMsg("验证失败");
            return baseResponse;
        }

        if(userService.selectUserById(u.getU_Account()).getU_Email().equals(u.getU_Email())){
            session.setAttribute("ID",u.getU_Account());
            baseResponse.setCode(200);
            baseResponse.setMsg("验证通过");
            return baseResponse;
        }
        else{
            baseResponse.setCode(500);
            baseResponse.setMsg("验证失败");
        }
        return baseResponse;
    }

    @RequestMapping("/success")
    public String checkSuccess() {
        return "admin/resetpwd";
    }
    @RequestMapping(value = "/set_pwd", method = {RequestMethod.POST} )
    @ResponseBody
    public BaseResponse setPwd(@RequestBody User u,
                               HttpSession session){
        BaseResponse<Integer> baseResponse = new BaseResponse<Integer>();
        u.setU_Account(String.valueOf(session.getAttribute("ID")));
        userService.updatePwd(u);
        if(userService.selectUserById(u.getU_Account()).getU_Password().equals(u.getU_Password())){
            baseResponse.setCode(200);
            baseResponse.setMsg("修改通过");
            return baseResponse;
        }
        else{
            baseResponse.setCode(500);
            baseResponse.setMsg("修改失败");
        }
        return baseResponse;

    }
}
