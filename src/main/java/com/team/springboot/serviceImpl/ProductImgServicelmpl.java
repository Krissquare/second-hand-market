package com.team.springboot.serviceImpl;

import com.team.springboot.mapper.ProductImgMapper;
import com.team.springboot.pojo.ProductImg;
import com.team.springboot.service.ProductImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImgServicelmpl implements ProductImgService {
    @Autowired
    ProductImgMapper productImgMapper;

    @Override
    public void insert(int p_Id,String p_href)
    {
        productImgMapper.insert(p_Id,p_href);
    }

    @Override
    public List<ProductImg> selectById(int p_Id)
    {
        return productImgMapper.selectById(p_Id);
    }
}
