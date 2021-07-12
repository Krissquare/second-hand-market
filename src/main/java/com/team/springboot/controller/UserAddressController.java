package com.team.springboot.controller;

import com.team.springboot.pojo.*;
import com.team.springboot.service.AddressService;
import com.team.springboot.service.UserAddressService;
import com.team.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class UserAddressController {
    @Autowired
    UserService userService;
    @Autowired
    UserAddressService userAddressService;
    @Autowired
    AddressService addressService;

    @RequestMapping("/detailuser")
    public String detailinit(){
        return "admin/detailUser";
    }

    @RequestMapping("/detail/user")
    @ResponseBody
    public BaseResponse detail (@RequestParam("u_Account") String u_Account,
                                HttpSession session){
        UserAddress userAddressList=userAddressService.selectuserAddressById(u_Account);
        BaseResponse baseResponse = new BaseResponse();
        if(userAddressList!=null) {
            session.setAttribute("userAddressList",userAddressList);
            baseResponse.setCode(200);
            baseResponse.setMsg("请求成功");
            baseResponse.setData(userAddressList);
        }
        else{
            baseResponse.setCode(500);
            baseResponse.setMsg("请求失败");
        }
        return baseResponse;
    }

    @RequestMapping("/userdelete")
    @ResponseBody
    public BaseResponse delete(@RequestParam("u_Account")String u_Account){
        BaseResponse baseResponse = new BaseResponse();
        User user=userService.selectUserById(u_Account);
        Address address=addressService.selectAddressAll(u_Account);
        if(user!=null&&address!=null){
            userService.deleteUser(u_Account);
            addressService.deleteAddressAll(u_Account);
        }
        user=userService.selectUserById(u_Account);
        if(user==null){
            baseResponse.setCode(200);
            baseResponse.setMsg("删除成功");
        }
        else{
            baseResponse.setCode(500);
            baseResponse.setMsg("删除失败");
        }
        return baseResponse;
    }

    @RequestMapping("/useredit")
    public String editinit(){
        return "admin/useredit";
    }

    //请求打开用户表格编辑功能
    @RequestMapping("/user/edit")
    @ResponseBody
    public BaseResponse edituser(@RequestParam("u_Account")String u_Account,
                                 HttpSession session){
        BaseResponse baseResponse = new BaseResponse();
        UserAddress userAddress=userAddressService.selectuserAddressById(u_Account);
        if(userAddress!=null){
            baseResponse.setCode(200);
            baseResponse.setMsg("请求成功");
            session.setAttribute("userAddress",userAddress);
        }
        else{
            baseResponse.setCode(500);
            baseResponse.setMsg("请求失败");
        }
        return baseResponse;
    }
    //用户表格进行编辑操作
    @RequestMapping("/edit/userupdate")
    public String test (@RequestParam("u_Account") String u_Account,
                        @RequestParam("u_Name") String u_Name,
                        @RequestParam("u_Sex") String u_Sex,
                        @RequestParam("u_Email") String u_Email,
                        @RequestParam("u_Phone") String u_Phone,
                        @RequestParam("a_Address1") String a_Address1,
                        @RequestParam("a_Address2") String a_Address2,
                        @RequestParam("a_Address3") String a_Address3,
                        @RequestParam("a_Address4") String a_Address4,
                        HttpSession session
    ){
        User user=new User();
        user.setU_Account(u_Account);
        user.setU_Name(u_Name);
        user.setU_Sex(u_Sex);
        user.setU_Email(u_Email);
        user.setU_Phone(u_Phone);
        Address address=new Address();
        address.setA_Account(u_Account);
        address.setA_Address1(a_Address1);
        address.setA_Address2(a_Address2);
        address.setA_Address3(a_Address3);
        address.setA_Address4(a_Address4);
        UserAddress userAddress=new UserAddress();
        userAddress.setU_Account(u_Account);
        userAddress.setU_Name(u_Name);
        userAddress.setU_Sex(u_Sex);
        userAddress.setU_Email(u_Email);
        userAddress.setU_Phone(u_Phone);
        userAddress.setA_Address1(a_Address1);
        userAddress.setA_Address2(a_Address2);
        userAddress.setA_Address3(a_Address3);
        userAddress.setA_Address4(a_Address4);


        if(user!=null&&address!=null) {
            userService.updateUser(user);
            addressService.updateAddressByAccount(address);
            session.setAttribute("userAddress",userAddress);
            return "admin/useredit";
        }
        else{
            return "admin/useredit";
        }
    }
    @RequestMapping("/useraddinit")
    public String useraddInit(){
        return "admin/useradd";
    }

    @RequestMapping("/adduser")
    public String add (@RequestParam("u_Account") String u_Account,
                       @RequestParam("u_Name") String u_Name,
                       @RequestParam("u_Password") String u_Password,
                       @RequestParam("u_Sex") String u_Sex,
                       @RequestParam("u_Email") String u_Email,
                       @RequestParam("u_Phone") String u_Phone,
                       @RequestParam("a_Address1") String a_Address1,
                       @RequestParam("a_Address2") String a_Address2,
                       @RequestParam("a_Address3") String a_Address3,
                       @RequestParam("a_Address4") String a_Address4){
        User user=new User();
        user.setU_Account(u_Account);
        user.setU_Name(u_Name);
        user.setU_Password(u_Password);
        user.setU_Sex(u_Sex);
        user.setU_Email(u_Email);
        user.setU_Phone(u_Phone);
        userService.insertOne(user);
        Address address=new Address();
        address.setA_Account(u_Account);
        address.setA_Address1(a_Address1);
        address.setA_Address2(a_Address2);
        address.setA_Address3(a_Address3);
        address.setA_Address4(a_Address4);
        addressService.insertAddressOne(u_Account,a_Address1,a_Address2,a_Address3,a_Address4);
            return "admin/useradd";
    }
}
