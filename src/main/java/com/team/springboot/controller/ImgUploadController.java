package com.team.springboot.controller;

import com.team.springboot.pojo.BaseResponse;
import com.team.springboot.pojo.Product;
import com.team.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ImgUploadController {

    @Autowired
    ProductService productService;

    @RequestMapping("/imgUploadInit")
    public String imgUploadInit(HttpServletRequest req){
        return "admin/imgUpload";
    }

    @RequestMapping("/imgUpdateInit")
    public String imgUpload(){
        return "admin/imgUpdate";
    }

    @RequestMapping("/imgUpload")
    @ResponseBody
    public BaseResponse imgUpload(@RequestParam("file") MultipartFile file, HttpServletRequest req, @RequestParam("p_Id") String p_Id){
//        System.out.println(p_Id); // p_Id的传值与绑定参考imgUpload.html的隐藏表单<input id="p_Id" name ="p_Id">和layui上传接口中的data参数
                                // 与productInfo.html中的layEvent监听imgUpload
        String path = req.getServletContext().getRealPath("/images/product");
        File realPath = new File(path);
        BaseResponse<Integer> baseResponse = null;
        String currentName = System.currentTimeMillis() + file.getOriginalFilename(); //为图片拼接时间戳，防止重命名
        String fileName = realPath + "/" + currentName; // 传递到文件上传函数中真实的服务器文件夹地址
        String href = "/images/product/" + currentName; // 添加到数据库中的图片href
        Product p = productService.imgHref(Integer.valueOf(p_Id));//根据所编辑的物品Id，查询所有图片地址

        if(p.getP_href().equals("0") && p.getP_href1().equals("0")){ // p_href p_href1皆为0 默认插入p_href
            productService.setHref(href,Integer.valueOf(p_Id));
            baseResponse = uploadFunction(realPath, file, fileName);
            return baseResponse;
        }

        if(p.getP_href().equals("0") && !p.getP_href1().equals("0")){ // p_href为0，p_href1不为0，插入p_href
            productService.setHref(href,Integer.valueOf(p_Id));
            baseResponse = uploadFunction(realPath, file, fileName);
            return baseResponse;
        }

        if(!p.getP_href().equals("0") && p.getP_href1().equals("0")){ // p_href不为0，p_href1为0，插入p_href1
            productService.setHref1(href,Integer.valueOf(p_Id));
            baseResponse = uploadFunction(realPath, file, fileName);
            return baseResponse;
        }

        //两张图片已插满，不能插入
        baseResponse = new BaseResponse<Integer>();
        baseResponse.setCode(500);
        baseResponse.setMsg("添加图片失败！请删除原有图片");
        baseResponse.setSrc("");
        return  baseResponse;

    }

    //layer弹出层展示图片的数据接口
    @RequestMapping("/imgAll")
    @ResponseBody
    public BaseResponse imgAll(@RequestParam("p_Id") String p_Id){
        BaseResponse<List<Product>> baseResponse = new BaseResponse<>();
        Product p = productService.imgHref(Integer.valueOf(p_Id));
        Product p1 = new Product();
        Product p2 = new Product();

        System.out.println(p.getP_href());
        System.out.println(p.getP_href1());
        List<Product> list = new ArrayList<>();
        p1.setP_Id(Integer.valueOf(p_Id));
        p1.setP_href(p.getP_href());

        p2.setP_Id(Integer.valueOf(p_Id));
        p2.setP_href(p.getP_href1());

        list.add(p1);list.add(p2);

        baseResponse.setCode(0);
        baseResponse.setData(list);

        return baseResponse;
    }


    @RequestMapping("/imgDelete")
    @ResponseBody
    public BaseResponse imgDelete(@RequestBody Product p, HttpServletRequest req){
        BaseResponse<Integer> baseResponse = new BaseResponse<>();
        System.out.println(p.getP_href());
        Product compareP = productService.imgHref(p.getP_Id());
        String realPath = req.getServletContext().getRealPath("/");
        System.out.println(realPath);
        System.out.println(realPath + p.getP_href());
        if(compareP.getP_href().equals(p.getP_href())){
            productService.setHref("0", p.getP_Id());
            baseResponse.setCode(200);
            baseResponse.setMsg("删除成功");
            File file = new File(realPath + p.getP_href());
            file.delete();
            return baseResponse;
        }else if(compareP.getP_href1().equals(p.getP_href())){
            productService.setHref1("0", p.getP_Id());
            baseResponse.setCode(200);
            baseResponse.setMsg("删除成功");
            File file = new File( realPath + p.getP_href());
            file.delete();
            return baseResponse;
        }

        baseResponse.setCode(500);
        baseResponse.setMsg("删除失败");
        return baseResponse;
    }

    //上传图片封装方法
    public static BaseResponse uploadFunction(File realPath,MultipartFile file, String fileName){
        if(!realPath.exists()){ // 存放图片的文件夹不存在，则创建
            realPath.mkdir();
        }

        BaseResponse<Integer> baseResponse = new BaseResponse<>();
        try{
            file.transferTo(new File(fileName));
            baseResponse.setCode(0);
            baseResponse.setMsg("上传成功");
            baseResponse.setSrc("");
            return baseResponse;
        }catch (IOException e){
            e.printStackTrace();
            baseResponse.setCode(500);
            baseResponse.setMsg("上传失败");
            baseResponse.setSrc("");
            return baseResponse;
        }
    }
}
