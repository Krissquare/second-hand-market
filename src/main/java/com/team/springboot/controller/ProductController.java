package com.team.springboot.controller;

import com.mysql.cj.util.StringUtils;
import com.team.springboot.pojo.*;
import com.team.springboot.service.ProductCategoryService;
import com.team.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.team.springboot.service.UserHeadService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    ProductCategoryService productCategoryService;

    @Autowired
    UserHeadService userHeadService;

    @RequestMapping("/init")
    public String showproductInfo(HttpSession session, Model m) {
        String account = (String) session.getAttribute("u_Account");
        UserHead userHead = userHeadService.selectHead(account);
        m.addAttribute("userHead", userHead);
        return "admin/productInfo";
    }
    @RequestMapping("/user_init")
    public String user_showproductInfo(HttpSession session, Model m) {
        String account = (String) session.getAttribute("u_Account");
        UserHead userHead = userHeadService.selectHead(account);
        m.addAttribute("userHead", userHead);
        return "admin/user_productInfo";
    }

    @RequestMapping("/status")
    public String showproductInfoByStatus(HttpSession session, Model m) {
        String account = (String) session.getAttribute("u_Account");
        UserHead userHead = userHeadService.selectHead(account);
        m.addAttribute("userHead", userHead);
        return "admin/productinfostatus";
    }

    @RequestMapping("/productInfoByStatus")
    @ResponseBody
    public BaseResponse productinfoByStatus (@RequestParam String page,
                                     @RequestParam String limit,
                                     HttpServletRequest request){
        String p_Name=request.getParameter("p_Name");
        String status=request.getParameter("p_Status");
        BaseResponse<List<ProductCategory>> baseResponse = new BaseResponse<>();
        List<ProductCategory> product;
        HttpSession session =request.getSession();
        if(p_Name!=null){
            p_Name="%"+p_Name+"%";
            if (session.getAttribute("u_Account").equals("admin")) {
                product = productCategoryService.selectProductCategorysByStatus(StringUtils.isNullOrEmpty(page) ? 1 : Integer.valueOf(page),
                        StringUtils.isNullOrEmpty(limit) ? 10 : Integer.valueOf(limit),
                        status);
                baseResponse.setCount(10);
                baseResponse.setData(product);
                baseResponse.setCode(200);
                baseResponse.setMsg("????????????");
                return baseResponse;
            }
            else{
                String p_Account=(String) session.getAttribute("u_Account");
                product= productCategoryService.selectProductCategorysByp_nameAndaccount(StringUtils.isNullOrEmpty(page) ? 1 : Integer.valueOf(page),
                        StringUtils.isNullOrEmpty(limit) ? 10 : Integer.valueOf(limit),
                        p_Name,
                        p_Account);
                baseResponse.setCount(productService.selectCountByp_nameAndaccount(p_Account,p_Name));
                baseResponse.setData(product);
                baseResponse.setCode(200);
                baseResponse.setMsg("????????????");
                return baseResponse;
            }
        }
        //??????????????????10???
        if (session.getAttribute("u_Account").equals("admin")) {
            product = productCategoryService.selectProductCategorysByStatus(StringUtils.isNullOrEmpty(page) ? 1 : Integer.valueOf(page),
                    StringUtils.isNullOrEmpty(limit) ? 10 : Integer.valueOf(limit),status);
            baseResponse.setCount(10);
        } else {
            product = productCategoryService.selectProductCategorysByaccount((String) session.getAttribute("u_Account"),
                    StringUtils.isNullOrEmpty(page) ? 1 : Integer.valueOf(page),
                    StringUtils.isNullOrEmpty(limit) ? 10 : Integer.valueOf(limit));
            baseResponse.setCount(productService.selectCountByaccount((String) session.getAttribute("u_Account")));
        }
        //??????product????????????
        if(product!=null) {
            baseResponse.setData(product);
            baseResponse.setCode(200);
            baseResponse.setMsg("????????????");
        }
        else{
            baseResponse.setCode(500);
            baseResponse.setMsg("????????????");
        }
        return baseResponse;
    }

    @RequestMapping("/productInfo")
    @ResponseBody
    public BaseResponse productinfo (@RequestParam String page,
                                     @RequestParam String limit,
                                     HttpServletRequest request){
        String p_Name=request.getParameter("p_Name");
        BaseResponse<List<ProductCategory>> baseResponse = new BaseResponse<>();
        List<ProductCategory> product;
        HttpSession session =request.getSession();
        if(p_Name!=null){
            p_Name="%"+p_Name+"%";
            if (session.getAttribute("u_Account").equals("admin")) {
                product = productCategoryService.selectProductCategorysByp_name(StringUtils.isNullOrEmpty(page) ? 1 : Integer.valueOf(page),
                        StringUtils.isNullOrEmpty(limit) ? 10 : Integer.valueOf(limit),
                        p_Name);
                baseResponse.setCount(productService.selectCountByp_Name(p_Name));
                baseResponse.setData(product);
                baseResponse.setCode(200);
                baseResponse.setMsg("????????????");
                return baseResponse;
            }
            else{
                String p_Account=(String) session.getAttribute("u_Account");
                product= productCategoryService.selectProductCategorysByp_nameAndaccount(StringUtils.isNullOrEmpty(page) ? 1 : Integer.valueOf(page),
                        StringUtils.isNullOrEmpty(limit) ? 10 : Integer.valueOf(limit),
                        p_Name,
                        p_Account);
                baseResponse.setCount(productService.selectCountByp_nameAndaccount(p_Account,p_Name));
                baseResponse.setData(product);
                baseResponse.setCode(200);
                baseResponse.setMsg("????????????");
                return baseResponse;
            }
        }
        //??????????????????10???
        if (session.getAttribute("u_Account").equals("admin")) {
            product = productCategoryService.selectProductCategorys(StringUtils.isNullOrEmpty(page) ? 1 : Integer.valueOf(page),
                    StringUtils.isNullOrEmpty(limit) ? 10 : Integer.valueOf(limit));
            baseResponse.setCount(productService.selectCount());
        } else {
            product = productCategoryService.selectProductCategorysByaccount((String) session.getAttribute("u_Account"),
                    StringUtils.isNullOrEmpty(page) ? 1 : Integer.valueOf(page),
                    StringUtils.isNullOrEmpty(limit) ? 10 : Integer.valueOf(limit));
            baseResponse.setCount(productService.selectCountByaccount((String) session.getAttribute("u_Account")));
        }
        //??????product????????????
        if(product!=null) {
            baseResponse.setData(product);
            baseResponse.setCode(200);
            baseResponse.setMsg("????????????");
        }
        else{
            baseResponse.setCode(500);
            baseResponse.setMsg("????????????");
        }
        return baseResponse;
    }


    @RequestMapping("/detail")
    public String detailinit(){
        return "admin/detail";
    }

    @RequestMapping("/detail/info")
    @ResponseBody
    public BaseResponse detail (@RequestParam String p_Id,
                                HttpSession session){
        Product product=productService.selectProductsById(Integer.valueOf(p_Id));
        BaseResponse baseResponse = new BaseResponse();
        if(product!=null) {
            session.setAttribute("product",product);
            baseResponse.setCode(200);
            baseResponse.setMsg("????????????");
            baseResponse.setData(product);
        }
        else{
            baseResponse.setCode(500);
            baseResponse.setMsg("????????????");
        }
        return baseResponse;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public BaseResponse delete(@RequestParam String p_Id){
        BaseResponse baseResponse = new BaseResponse();
        Product product=productService.selectProductById(Integer.valueOf(p_Id));
        if(product!=null){
            productService.deleteProductById(Integer.valueOf(p_Id));
        }
        product=productService.selectProductById(Integer.valueOf(p_Id));
        if(product==null){
            baseResponse.setCode(200);
            baseResponse.setMsg("????????????");
        }
        else{
            baseResponse.setCode(500);
            baseResponse.setMsg("????????????");
        }
        return baseResponse;
    }
    @RequestMapping("/pass")
    @ResponseBody
    public BaseResponse pass(@RequestParam String p_Id,HttpServletRequest request){
        BaseResponse baseResponse = new BaseResponse();
        Product product=productService.selectProductById(Integer.valueOf(p_Id));
        if(product==null || product.getP_Status().equals("?????????"))
        {
            baseResponse.setCode(500);
            baseResponse.setMsg("?????????????????????????????????");
            return baseResponse;
        }
        if(product!=null && product.getP_Status().equals("?????????") && !request.getSession().getAttribute("u_Account").equals("admin"))
        {
            baseResponse.setCode(500);
            baseResponse.setMsg("?????????????????????????????????");
            return baseResponse;
        }
        if(product!=null){
            productService.setStatusById("?????????", Integer.parseInt(p_Id));
        }
        product=productService.selectProductById(Integer.valueOf(p_Id));
        baseResponse.setCode(200);
        baseResponse.setMsg("????????????");
        return baseResponse;
    }
    @RequestMapping("/soldout")
    @ResponseBody
    public BaseResponse soldout(@RequestParam String p_Id){
        BaseResponse baseResponse = new BaseResponse();
        Product product=productService.selectProductById(Integer.valueOf(p_Id));
        if(product==null || product.getP_Status().equals("?????????")|| product.getP_Status().equals("?????????"))
        {
            baseResponse.setCode(500);
            baseResponse.setMsg("?????????????????????????????????????????????");
            return baseResponse;
        }
        if(product!=null){
            productService.setStatusById("?????????", Integer.parseInt(p_Id));
        }
        product=productService.selectProductById(Integer.valueOf(p_Id));
        baseResponse.setCode(200);
        baseResponse.setMsg("????????????");
        return baseResponse;
    }
    @RequestMapping("/edit")
    public String editinit(){
        return "admin/edit";
    }

    @RequestMapping("/edit/info")
    @ResponseBody
    public BaseResponse edit (@RequestParam("p_Id") String p_Id,
                              HttpSession session){
        Product product=productService.selectProductallById(Integer.valueOf(p_Id));
        BaseResponse baseResponse = new BaseResponse();
        if(product!=null) {
            session.setAttribute("product",product);
            baseResponse.setCode(200);
            baseResponse.setMsg("????????????");
            baseResponse.setData(product);
        }
        else{
            baseResponse.setCode(500);
            baseResponse.setMsg("????????????");
        }
        return baseResponse;
    }
    @RequestMapping("/edit/update")
    public String realEdit (@RequestParam("p_Id") String p_Id,
                            @RequestParam("p_Account") String p_Account,
                            @RequestParam("p_Name") String p_Name,
                            @RequestParam("p_Title") String p_Title,
                            @RequestParam("p_Date") Date p_Date,
                            @RequestParam("p_Price") Double p_Price,
                            @RequestParam("p_Des") String p_Des,
                            HttpSession session
    ){
        Product product=new Product();
        product.setP_Id(Integer.valueOf(p_Id));
        product.setP_Account(p_Account);
        product.setP_Date(p_Date);
        product.setP_Des(p_Des);
        product.setP_Name(p_Name);
//        product.setP_originalPrice(p_originalPrice);
        product.setP_Title(p_Title);
        product.setP_Price(p_Price);

        if(product!=null) {
            productService.updateProduct(product);
            session.setAttribute("product",product);
            return "admin/edit";
        }
        else{
            return "admin/edit";
        }
    }
    @RequestMapping("/addinit")
    public String productaddInit(HttpSession session){
        return "admin/productadd";
    }

    @RequestMapping("/add")
    public String add (@RequestParam("p_Name") String p_Name,
                       @RequestParam("p_Title") String p_Title,
                       @RequestParam("p_Date") Date p_Date,
                       @RequestParam("p_Price") Double p_Price,
                       @RequestParam("p_originalPrice") String p_originalPrice,
                       @RequestParam("p_Des") String p_Des,
                       @RequestParam("p_num") int p_num,HttpSession session
    ){

        ProductCategory productCategory = new ProductCategory();
        productCategory.setP_Id(productCategoryService.selectMaxP_Id()+1);
        productCategory.setP_Account((String) session.getAttribute("u_Account"));
        productCategory.setP_Date(p_Date);
        productCategory.setP_Des(p_Des);
        productCategory.setP_Title(p_Title);
        productCategory.setP_originalPrice(p_originalPrice);
        productCategory.setP_Name(p_Name);
        productCategory.setP_Price(p_Price);
        productCategory.setP_num(p_num);
        productCategory.setP_href((String) session.getAttribute("img"));
        switch (p_Name)
        {
            case "????????????":productCategory.setC_Id("c09");break;
            case "????????????":productCategory.setC_Id("c01");break;
            case "????????????":productCategory.setC_Id("c02");break;
            case "????????????":productCategory.setC_Id("c03");break;
            case "????????????":productCategory.setC_Id("c04");break;
            case "????????????":productCategory.setC_Id("c05");break;
            case "????????????":productCategory.setC_Id("c06");break;
            case "????????????":productCategory.setC_Id("c07");break;
            case "????????????":productCategory.setC_Id("c08");break;
            case "????????????":productCategory.setC_Id("c10");break;
        }
        productCategory.setP_Status("?????????");
        productCategoryService.insertProductCategory(productCategory);
        if(productService.selectProductById(Integer.valueOf(productCategory.getP_Id()))!=null){
            return "admin/productadd";
        }
        else
            return "admin/productadd";
    }

    @RequestMapping("/typeValue")
    @ResponseBody
    public BaseResponse selectproductTypeValue(){
        BaseResponse<List<String>> baseResponse = new BaseResponse<>();
        List<ProductCategory>list=productCategoryService.selectAllcName();
        List<String> list1 = new ArrayList<>();
        for(ProductCategory p :list)
            list1.add(p.getC_Name());
        baseResponse.setCode(200);
        baseResponse.setData(list1);
        return baseResponse;
    }
}
