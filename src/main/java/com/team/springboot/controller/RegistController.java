package com.team.springboot.controller;


import com.team.springboot.pojo.BaseResponse;
import com.team.springboot.pojo.Cipher;
import com.team.springboot.pojo.User;
import com.team.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RegistController {
    @Autowired
    UserService userService;

    @RequestMapping("/registration")
        public String init() {
            return "html/registration";
    }


    @RequestMapping(value = "/add", method = {RequestMethod.POST} )
    @ResponseBody
    public BaseResponse registerAdd(@RequestBody User u){
        BaseResponse<Integer> baseResponse = new BaseResponse<Integer>();
        if(userService.selectUserById(u.getU_Account()) != null){
            baseResponse.setCode(400);
            baseResponse.setMsg("用户名已存在");
            return baseResponse;
        }
        //encipher
        u.setU_Password(Cipher.Encipher(u.getU_Password()));

        userService.insertOne(u);
        if(userService.selectUserById(u.getU_Account()) != null){
            baseResponse.setCode(200);
            baseResponse.setMsg("注册成功");
        }
        else{
            baseResponse.setCode(500);
            baseResponse.setMsg("插入失败");
        }
        return baseResponse;
    }
}
