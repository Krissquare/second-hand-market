package com.team.springboot.service;

import com.team.springboot.pojo.ShoppingCar;
import com.team.springboot.pojo.ShoppingCarProduct;

import java.util.List;
import java.util.Optional;

public interface ShoppingCarService  {
    void insertOne (String u_Account, int p_Id);

    ShoppingCar selectById(String s_Id);

    List<ShoppingCarProduct> selectShoppingCarProductById(String u_Account);

    int getCountByAccount(String u_Account);

    Double getTotalPrice(String u_Account);

    void deleteById(int s_Id);

    void updateByAccountId(String u_Account,int p_Id,int num);

    ShoppingCar selectByAccountId(String u_Account,int p_Id);

    void updateNum(String u_Account,int p_Id,int num);

    void deleteByAccountId(String u_Account,int p_Id);
}
