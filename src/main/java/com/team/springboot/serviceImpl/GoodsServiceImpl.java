package com.team.springboot.serviceImpl;

import com.team.springboot.mapper.GoodsMapper;
import com.team.springboot.pojo.Product;
import com.team.springboot.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public Product selectProduct(int p_Id) {
        return goodsMapper.selectProduct(p_Id);
    }
}
