package com.team.springboot.serviceImpl;

import com.team.springboot.mapper.ShoppingCarMapper;
import com.team.springboot.pojo.ShoppingCar;
import com.team.springboot.pojo.ShoppingCarProduct;
import com.team.springboot.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {

    @Autowired
    ShoppingCarMapper shoppingCarMapper;

    public void insertOne (String u_Account, int p_Id){
        shoppingCarMapper.insertOne(u_Account,p_Id);
    }

    public  ShoppingCar selectById(String s_Id){
        return  shoppingCarMapper.selectById(s_Id);
    }


    public List<ShoppingCarProduct> selectShoppingCarProductById(String u_Account) {
        return shoppingCarMapper.selectShoppingCarProductById(u_Account);
    }

    @Override
    public int getCountByAccount(String u_Account) {
        return shoppingCarMapper.getCountByAccount(u_Account);
    }

    @Override
    public void deleteById(int s_Id){
        shoppingCarMapper.deleteById(s_Id);
    }
}
