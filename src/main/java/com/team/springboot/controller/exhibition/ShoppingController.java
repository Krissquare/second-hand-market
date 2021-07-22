package com.team.springboot.controller.exhibition;

import com.team.springboot.pojo.*;
import com.team.springboot.service.ProductService;
import com.team.springboot.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.team.springboot.service.UserHeadService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ShoppingController {

    @Autowired
    ShoppingCarService shoppingCarService;

    @Autowired
    UserHeadService userHeadService;

    @Autowired
    ProductService productService;

    @RequestMapping("/shoppingCarInit")
    public String shoppingCarInit(Model m, HttpSession session){
        String account = (String) session.getAttribute("u_Account");
        UserHead userHead = userHeadService.selectHead(account);
        m.addAttribute("userHead", userHead);
        return "html/cart";
    }

    @RequestMapping("/shopProduct")
    public String shopProduct(HttpServletRequest req,Model m)
    {
        String account = (String)req.getSession().getAttribute("u_Account");
        List<ShoppingCarProduct> list = shoppingCarService.selectShoppingCarProductById(account);
        m.addAttribute("sproduct",list);
        return "html/cart";
    }

    @RequestMapping("/minus")
    public String minus(@RequestParam("ID") String pid,HttpServletRequest req,Model m)
    {
        int Id=Integer.parseInt(pid);
        System.out.println(Id);
        String account = (String)req.getSession().getAttribute("u_Account");
        shoppingCarService.updateByAccountId(account,Id,-1);
        ShoppingCar sp=shoppingCarService.selectByAccountId(account,Id);
        Product p=productService.selectProductById(sp.getP_Id());
        if(sp.getP_Num()==0)
        {
            shoppingCarService.deleteById(sp.getS_Id());
        }
        if(p.getP_num()<sp.getP_Num())
            shoppingCarService.updateNum(account,Id,p.getP_num());
        return "redirect:/shopProduct";
    }

    @RequestMapping("/plus")
    public String plus(@RequestParam("ID") String pid,HttpServletRequest req,Model m)
    {
        int Id=Integer.parseInt(pid);
        System.out.println(pid);
        String account = (String)req.getSession().getAttribute("u_Account");
        ShoppingCar sp=shoppingCarService.selectByAccountId(account,Id);
        Product p=productService.selectProductById(sp.getP_Id());
        shoppingCarService.updateByAccountId(account,Id,1);
        ShoppingCar spn=shoppingCarService.selectByAccountId(account,Id);
        if(p.getP_num()<spn.getP_Num())
            shoppingCarService.updateNum(account,Id,p.getP_num());
        return "redirect:/shopProduct";
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
