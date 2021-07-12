package com.team.springboot.controller.exhibition;

import com.team.springboot.pojo.BaseResponse;
import com.team.springboot.pojo.ShoppingCarProduct;
import com.team.springboot.pojo.UserHead;
import com.team.springboot.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.team.springboot.service.UserHeadService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ShoppingController {

    @Autowired
    ShoppingCarService shoppingCarService;

    @Autowired
    UserHeadService userHeadService;

    @RequestMapping("/shoppingCarInit")
    public String shoppingCarInit(Model m, HttpSession session){
        String account = (String) session.getAttribute("u_Account");
        UserHead userHead = userHeadService.selectHead(account);
        m.addAttribute("userHead", userHead);
        return "admin/shoppingcar";
    }

    @RequestMapping("/shoppingCarAll")
    @ResponseBody
    public BaseResponse shoppingCarAll(HttpServletRequest req ,int page, int limit){
        BaseResponse<List<ShoppingCarProduct>> baseResponse = new BaseResponse<>();
        String account = (String)req.getSession().getAttribute("u_Account");
        int count = shoppingCarService.getCountByAccount(account);
        List<ShoppingCarProduct> list = shoppingCarService.selectShoppingCarProductById(account);
        baseResponse.setCount(count);
        baseResponse.setCode(200);
        baseResponse.setData(list);
        return baseResponse;
    }
    @RequestMapping("/shoppingCardelete")
    @ResponseBody
    public  BaseResponse shoppingCardelete(@RequestParam("s_Id") int s_Id){
        BaseResponse<Integer> baseResponse = new BaseResponse<>();
        shoppingCarService.deleteById(s_Id);
        baseResponse.setCode(200);
        baseResponse.setMsg("删除成功");
        return baseResponse;
    }
}
