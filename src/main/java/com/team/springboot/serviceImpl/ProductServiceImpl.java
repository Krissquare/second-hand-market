package com.team.springboot.serviceImpl;

import com.team.springboot.mapper.ProductMapper;
import com.team.springboot.mapper.userMapper;
import com.team.springboot.pojo.Product;
import com.team.springboot.pojo.ProductCategory;
import com.team.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;


    @Override
    public int selectCount() {
        return productMapper.selectCount();
    }

    @Override
    public Product selectProductById(int p_ID) {
        return productMapper.selectProductById(p_ID);
    }

    @Override
    public Product selectProductsById(int p_ID) {
        return productMapper.selectProductsById(p_ID);
    }

    @Override
    public void deleteProductById(int p_ID) {
        productMapper.deleteProductById(p_ID);
    }

    @Override
    public Product selectProductallById(int p_ID) {
        return productMapper.selectProductallById(p_ID);
    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }

    @Override
    public int selectCountByaccount(String p_Account) {
        return productMapper.selectCountByaccount(p_Account);
    }

    @Override
    public Product imgHref(int p_Id) {
        return productMapper.imgHref(p_Id);
    }

    @Override
    public void setHref(String p_href, int p_Id){
        productMapper.setHref(p_href, p_Id);
    }

    @Override
    public void setHref1(String p_href, int p_Id) {
        productMapper.setHref1(p_href,p_Id);
    }

    @Override
    public Product selectById(int p_Id) {
        return productMapper.selectById(p_Id);
    }

    @Override
    public int selectCountByp_Name(String p_Name) {
        return productMapper.selectCountByp_Name(p_Name);
    }

    @Override
    public int selectCountByp_nameAndaccount(String p_Account, String p_Name) {
        return productMapper.selectCountByp_nameAndaccount(p_Account, p_Name);
    }

    @Override
    public List<Product> selectProductByp_name(String p_Name)
    {
        return productMapper.selectProductByp_name(p_Name);
    }

    @Override
    public List<Product> selectProductAll()
    {
        return productMapper.selectProductAll();
    }


    @Override
    public void setStatusById(String p_Status,int p_ID)
    {
        productMapper.setStatusById(p_Status,p_ID);
    }

}
