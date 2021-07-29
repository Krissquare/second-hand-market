package com.team.springboot.controller;

import com.team.springboot.mapper.WishListMapper;
import com.team.springboot.pojo.BaseResponse;
import com.team.springboot.pojo.ShoppingCar;
import com.team.springboot.pojo.WishProduct;
import com.team.springboot.pojo.Wishlist;
import com.team.springboot.service.UserService;
import com.team.springboot.service.WishListService;
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
import java.util.*;

@Controller
public class WishListController {
    @Autowired
    WishListService wishListService;

    //加入愿望清单
    @PostMapping("/addIntoWishList")
    public String shoppingCar(@RequestParam("wPID") int p_Id, HttpSession session){
        String account = (String) session.getAttribute("u_Account");
        if(account == null)
            return "redirect:/login";
        Wishlist w=wishListService.selectByAccountId(account,p_Id);
        if(w==null) {
            wishListService.insertOne(account, p_Id);//添加商品p到购物车
        }
        return "redirect:/goodsDetail?pid=" + p_Id;
    }

    //显示愿望单界面
    @RequestMapping("/showWishList")
    public String ShowWishList(HttpSession session,Model model)
    {
        String account = (String) session.getAttribute("u_Account");
        if(account == null)
            return "redirect:/login";

        List<WishProduct> wlist=wishListService.selectByAccount(account);
        model.addAttribute("wlist",wlist);
        return "html/wishlist";
    }

    //删除愿望单项
    @RequestMapping("/deleteWish")
    public String deleteWish(@RequestParam("ID") String pid,HttpServletRequest req)
    {
        int Id=Integer.parseInt(pid);
        String account = (String)req.getSession().getAttribute("u_Account");
        if(account == null)
            return "redirect:/login";

        wishListService.deleteByAccountId(account,Id);
        return "redirect:/showWishList";
    }
}
