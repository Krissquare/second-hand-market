package com.team.springboot.service;

import com.team.springboot.pojo.ShoppingCar;
import com.team.springboot.pojo.ShoppingCarProduct;

import java.util.List;

public interface ShoppingCarService  {
    void insertOne (String u_Account, int p_Id);

    ShoppingCar selectById(String s_Id);

    List<ShoppingCarProduct> selectShoppingCarProductById(String u_Account);

    int getCountByAccount(String u_Account);

    double getTotalPrice(String u_Account);

    void deleteById(int s_Id);
}
