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

    //上传图片操作
    @RequestMapping("/imgUpload")
    @ResponseBody
    public BaseResponse imgUpload(@RequestParam("file") MultipartFile file, HttpServletRequest req, @RequestParam("p_Id") String p_Id){
        String path = req.getServletContext().getRealPath("/images/product");
        File realPath = new File(path);
        BaseResponse baseResponse = null;
        String currentName = System.currentTimeMillis() + file.getOriginalFilename();
        String fileName = realPath + "/" + currentName;
        String href = "/images/product/" + currentName;
        Product p = productService.selectProductsById(Integer.valueOf(p_Id));
        if(p!=null){
            productService.setHref(href,Integer.valueOf(p_Id));
            baseResponse = uploadFunction(realPath, file, fileName);
            return baseResponse;
        }
        else
        {
            System.out.println("shit");
        }
        baseResponse = new BaseResponse<>();
        baseResponse.setCode(500);
        baseResponse.setMsg("添加图片失败！请删除原有图片");
        baseResponse.setSrc("");
        return  baseResponse;
    }

    //显示商品的所有图片
    @RequestMapping("/imgAll")
    @ResponseBody
    public BaseResponse imgAll(@RequestParam("p_Id") String p_Id){
        BaseResponse<List<Product>> baseResponse = new BaseResponse<>();
        Product p = productService.imgHref(Integer.valueOf(p_Id));
        Product p1 = new Product();
        List<Product> list = new ArrayList<>();
        p1.setP_Id(Integer.valueOf(p_Id));
        p1.setP_href(p.getP_href());
        list.add(p1);
        baseResponse.setCode(0);
        baseResponse.setData(list);
        return baseResponse;
    }

    //删除一张图片
    @RequestMapping("/imgDelete")
    @ResponseBody
    public BaseResponse imgDelete(@RequestBody Product p, HttpServletRequest req){
        BaseResponse<Integer> baseResponse = new BaseResponse<>();
        System.out.println(p.getP_href());
        Product compareP = productService.imgHref(p.getP_Id());
        String realPath = req.getServletContext().getRealPath("/");
        System.out.println(realPath);
        System.out.println(realPath + p.getP_href());
        if(compareP.getP_href().equals(p.getP_href())) {
            productService.setHref("0", p.getP_Id());
            baseResponse.setCode(200);
            baseResponse.setMsg("删除成功");
            File file = new File(realPath + p.getP_href());
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
        System.out.println(fileName);
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
