package com.team.springboot.service;

import com.team.springboot.pojo.ProductImg;

import java.util.List;

public interface ProductImgService {
    void insert(int p_Id,String p_href);
    List<ProductImg> selectById(int p_Id);
}
