package com.team.springboot.serviceImpl;

import com.team.springboot.mapper.ProductCategoryMapper;
import com.team.springboot.mapper.ProductMapper;
import com.team.springboot.pojo.ProductCategory;
import com.team.springboot.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    ProductCategoryMapper productCategoryMapper;
    @Override
    public String selectCidBycName(String c_Name) {
        return productCategoryMapper.selectCidBycName(c_Name);
    }

    @Override
    public void insertProductCategory(ProductCategory productCategory) {
        productCategoryMapper.insertProductCategory(productCategory);
    }

    @Override
    public List<ProductCategory> selectProductCategorys(int page, int limit) {
        return productCategoryMapper.selectProductCategorys((page-1)*limit,limit);
    }

    @Override
    public List<ProductCategory> selectProductCategorysByaccount(String p_Account, int page, int limit) {
        return productCategoryMapper.selectProductCategorysByaccount(p_Account,(page-1)*limit,limit);
    }

    @Override
    public List<ProductCategory> selectProductAll() {
        return productCategoryMapper.selectProductAll();
    }

    @Override
    public List<ProductCategory> selectProductCategorysByp_name(int page, int limit, String p_Name) {
        return productCategoryMapper.selectProductCategorysByp_name((page-1)*limit,limit,p_Name);
    }

    @Override
    public List<ProductCategory> selectProductCategorysByp_nameAndaccount(int page, int limit, String p_Name, String p_Account) {
        return productCategoryMapper.selectProductCategorysByp_nameAndaccount((page-1)*limit,limit, p_Name, p_Account);
    }
    @Override
    public List<ProductCategory> selectAllcName() {
        return productCategoryMapper.selectAllcName();
    }

    @Override
    public int selectMaxP_Id() {
        return productCategoryMapper.selectMaxP_Id();
    }

    @Override
    public List<ProductCategory> selectProductCategorysByp_name1(String p_Name) {
        return productCategoryMapper.selectProductCategorysByp_name1(p_Name);
    }

    @Override
    public List<ProductCategory> selectProductCategorysByRange(int min,int max)
    {
        return productCategoryMapper.selectProductCategorysByRange(min,max);
    }
}
