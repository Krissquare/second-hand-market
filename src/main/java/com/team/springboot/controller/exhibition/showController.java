package com.team.springboot.controller.exhibition;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.springboot.mapper.OrderMapper;
import com.team.springboot.pojo.*;
import com.team.springboot.service.OrderService;
import com.team.springboot.service.ProductCategoryService;
import com.team.springboot.service.ProductService;
import com.team.springboot.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class showController {

    @Autowired
    ProductCategoryService productCategoryService;

    @Autowired
    ShoppingCarService shoppingCarService;

    @Autowired
    private OrderService orderService;

    @Autowired
    ProductService productService;


    private List<List<ProductCategory>> row1ToRow2(List<ProductCategory> singleList) {
        List<List<ProductCategory>> doubleList = new ArrayList<>();
        for (int i = 0; i < singleList.size(); i++) {
            if (i % 2 == 0) {
                List<ProductCategory> temp = new ArrayList<>();
                temp.add(singleList.get(i));
                if (i + 1 < singleList.size())
                    temp.add(singleList.get(i + 1));
                doubleList.add(temp);
            }
        }

        return doubleList;
    }


    private void setLoginState(Model m, HttpServletRequest req) {
        String account = (String) req.getSession().getAttribute("u_Account");
        List<ShoppingCarProduct> shoppingCartList = shoppingCarService.selectShoppingCarProductById(account);
        int shoppingCarPrice = 0;
        boolean signInFlag;
        if (account != null) {
            signInFlag = true;
            for (ShoppingCarProduct ele : shoppingCartList)
                shoppingCarPrice += ele.getP_Price();
        } else
            signInFlag = false;

        m.addAttribute("shoppingCartList", shoppingCartList);
        m.addAttribute("account", account);
        m.addAttribute("signInFlag", signInFlag);
        m.addAttribute("shoppingCarPrice", shoppingCarPrice);

    }
    //前台展示初始化


    //前台展示初始化
    @RequestMapping({"showAll","/"})
    public String showAll(Model m, HttpServletRequest req) {
        setLoginState(m, req);

        List<ProductCategory> digitalEquipmentList = productCategoryService.selectProductCategorysByp_name1("电子产品");
        List<ProductCategory> dailySupplyList = productCategoryService.selectProductCategorysByp_name1("衣帽鞋伞");
        List<ProductCategory> bookList = productCategoryService.selectProductCategorysByp_name1("书籍教材");


        m.addAttribute("digitalEquipmentList", row1ToRow2(digitalEquipmentList));
        m.addAttribute("dailySupplyList", row1ToRow2(dailySupplyList));
        m.addAttribute("bookList", row1ToRow2(bookList));


        return "html/index";
    }

    //前台搜索功能
    @RequestMapping("/search")
    public String search(Model m, @RequestParam(defaultValue = "1", required = true, value = "pageNo") Integer pageNo,
                         @RequestParam("search") String search, HttpServletRequest req) {
        setLoginState(m, req);

        int pageSize = 15;
        search = "%" + search + "%";
        PageHelper.startPage(pageNo, pageSize);
        List<ProductCategory> list = productCategoryService.selectProductCategorysByp_name1(search);
        PageInfo<ProductCategory> pageInfo = new PageInfo<ProductCategory>(list, pageSize);
        req.getSession().setAttribute("search",search);


        m.addAttribute("productList", pageInfo);

        return "html/shop-left-sidebar";
    }

    @RequestMapping("/searchAll")
    public String searchAll(Model m, HttpServletRequest req)
    {
        setLoginState(m, req);

        Integer pageSize = 15;
        List<ProductCategory> list = productCategoryService.selectProductAll();
        PageInfo<ProductCategory> pageInfo = new PageInfo<ProductCategory>(list,pageSize);
        req.getSession().setAttribute("search",null);
        m.addAttribute("productList",pageInfo);
        return "html/shop-left-sidebar";
    }

    @RequestMapping("/ByNum")
    public String byNum(Model model, HttpSession session, @RequestParam(defaultValue = "1", required = true, value = "pageNo") Integer pageNo)
    {
        if(session.getAttribute("search")!=null)
        {
            String search=(String)session.getAttribute("search");
            Integer pageSize = 15;
            search = "%" + search + "%";
            PageHelper.startPage(pageNo, pageSize);
            List<Product> list = productService.selectProductByp_name(search);
            Collections.sort(list);
            PageInfo<Product> pageInfo = new PageInfo<Product>(list, pageSize);
            model.addAttribute("productList", pageInfo);
        }
        else
        {
            Integer pageSize = 15;
            List<Product> list = productService.selectProductAll();
            Collections.sort(list);
            PageInfo<Product> pageInfo = new PageInfo<Product>(list,pageSize);
            model.addAttribute("productList", pageInfo);
        }
        return "html/shop-left-sidebar";
    }

    @RequestMapping("/ByLowPrice")
            public String byLow(Model m,
                                HttpServletRequest req,
                                @RequestParam(defaultValue = "1", required = true, value = "pageNo") Integer pageNo) {
        setLoginState(m, req);

        if (req.getSession().getAttribute("search") != null) {
            String search = (String) req.getSession().getAttribute("search");
            Integer pageSize = 15;
            search = "%" + search + "%";
            PageHelper.startPage(pageNo, pageSize);
            List<ProductCategory> list = productCategoryService.selectProductCategorysByp_name1(search);
            Collections.sort(list);
            PageInfo<ProductCategory> pageInfo = new PageInfo<ProductCategory>(list, pageSize);
            m.addAttribute("productList", pageInfo);
        } else {
            Integer pageSize = 15;
            List<ProductCategory> list = productCategoryService.selectProductAll();
            Collections.sort(list);
            PageInfo<ProductCategory> pageInfo = new PageInfo<ProductCategory>(list, pageSize);
            m.addAttribute("productList", pageInfo);
        }
        return "html/shop-left-sidebar";

    }

    @RequestMapping("/range")
    public String range(@RequestParam(value = "minRange",name = "minRange",required = false)String minRange,
                        @RequestParam(value="maxRange",name="maxRange",required = false)String maxRange,
                        Model m,  HttpServletRequest req)
    {
        setLoginState(m, req);

        int min,max;
        if(minRange!=null)
            min=Integer.parseInt(minRange);
        else
            min=0;
        if(maxRange!=null)
            max=Integer.parseInt(maxRange);
        else
            max=100000;

        int pageSize = 15;
        List<ProductCategory> list = productCategoryService.selectProductCategorysByRange(min,max);
        PageInfo<ProductCategory> pageInfo = new PageInfo<ProductCategory>(list,pageSize);
        m.addAttribute("productList", pageInfo);
        return "html/shop-left-sidebar";
    }

    //交易记录页面的Mapping
    @RequestMapping("/showMyTransactionOrders")
    public String showMyTransactionOrders(HttpServletRequest req, Model m){
        ArrayList<Order> buyOrderList;
        ArrayList<Order> sellOrderList;
        String account = (String) req.getSession().getAttribute("u_Account");

        buyOrderList = (ArrayList<Order>) orderService.selectOrderAndProductBuy(account,1,100);
        sellOrderList = (ArrayList<Order>) orderService.selectOrderAndProductSell(account,1,100);
        m.addAttribute("myAllOrdersBuy",buyOrderList);
        m.addAttribute("myAllOrderSell",sellOrderList);

        System.out.println(buyOrderList.size());//debug
        return "html/transactionRecord";
    }

}
