package com.team.springboot.controller.exhibition;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.springboot.pojo.*;
import com.team.springboot.service.OrderService;
import com.team.springboot.service.ProductCategoryService;
import com.team.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
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

    //前台展示初始化
    @RequestMapping({"/"})
    public String showAll(Model model) {
        List<ProductCategory> digitalEquipmentList = productCategoryService.selectProductCategorysByp_name2("电子产品");
        List<ProductCategory> dailySupplyList = productCategoryService.selectProductCategorysByp_name2("衣帽鞋伞");
        List<ProductCategory> bookList = productCategoryService.selectProductCategorysByp_name2("书籍教材");

        model.addAttribute("digitalEquipmentList", row1ToRow2(digitalEquipmentList));
        model.addAttribute("dailySupplyList", row1ToRow2(dailySupplyList));
        model.addAttribute("bookList", row1ToRow2(bookList));

        return "html/index";
    }

    //前台搜索功能
    @RequestMapping("/search")
    public String search(Model m, @RequestParam(defaultValue = "1", required = true, value = "pageNo") Integer pageNo,
                         @RequestParam("search") String search, HttpServletRequest req) {


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

    @PostMapping("/range")
    public String range(@RequestParam("minRange")int minRange,
                        @RequestParam("maxRange") int maxRange, Model model)
    {
        Integer pageSize = 15;
        int min,max;
        if(minRange>maxRange)
        {
            min=maxRange;
            max=minRange;
        }
        else
        {
            min=minRange;
            max=maxRange;
        }
        List<ProductCategory> list = productCategoryService.selectProductCategorysByRange(min,max);
        PageInfo<ProductCategory> pageInfo = new PageInfo<ProductCategory>(list,pageSize);
        model.addAttribute("productList", pageInfo);
        return "html/shop-left-sidebar";
    }

    //交易记录页面的Mapping
    @RequestMapping("/showMyTransactionOrders")
    public String showMyTransactionOrders(HttpServletRequest req, Model m){
        ArrayList<Order> buyOrderList;
        ArrayList<Order> sellOrderList;
        String account = (String) req.getSession().getAttribute("u_Account");

        buyOrderList = (ArrayList<Order>) orderService.selectOrderAndProductBuy(account);
        sellOrderList = (ArrayList<Order>) orderService.selectOrderAndProductSell(account);
        m.addAttribute("myAllOrdersBuy",buyOrderList);
        m.addAttribute("myAllOrderSell",sellOrderList);

        System.out.println(buyOrderList.size());//debug
        return "html/transactionRecord";
    }
    @PostMapping("/selectCategory")
    public String selectCategory(@RequestParam("category") String category,@RequestParam("txt") String txt,Model m,HttpServletRequest req)
    {
        //System.out.println(category);
        Integer pageSize = 15;
        txt = "%" + txt+ "%";
        if(category.equals("selected"))
        {
            List<ProductCategory> list = productCategoryService.selectProductCategorysByp_name1(txt);
            PageInfo<ProductCategory> pageInfo = new PageInfo<ProductCategory>(list,pageSize);
            req.getSession().setAttribute("search",txt);
            m.addAttribute("productList",pageInfo);
        }
        else
        {
            List<ProductCategory> list=productCategoryService.selectCategory(category,txt);
            PageInfo<ProductCategory> pageInfo = new PageInfo<ProductCategory>(list,pageSize);
            req.getSession().setAttribute("search",txt);
            m.addAttribute("productList",pageInfo);
        }
        return "html/shop-left-sidebar";
    }

}
