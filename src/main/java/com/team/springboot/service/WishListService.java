package com.team.springboot.service;

import com.team.springboot.pojo.WishProduct;
import com.team.springboot.pojo.Wishlist;

import java.util.List;

public interface WishListService {
    void insertOne (String u_Account, int p_Id);
    Wishlist selectByAccountId(String u_Account, int p_Id);
    List<WishProduct> selectByAccount(String u_Account);
    void deleteByAccountId(String u_Account,int p_Id);
}
