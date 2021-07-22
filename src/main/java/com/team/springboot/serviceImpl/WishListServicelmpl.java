package com.team.springboot.serviceImpl;

import com.team.springboot.mapper.WishListMapper;
import com.team.springboot.pojo.WishProduct;
import com.team.springboot.pojo.Wishlist;
import com.team.springboot.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListServicelmpl implements WishListService {

    @Autowired
    WishListMapper wishListMapper;
    @Override
    public void insertOne(String u_Account, int p_Id)
    {
        wishListMapper.insertOne(u_Account,p_Id);
    }

    @Override
    public Wishlist selectByAccountId(String u_Account, int p_Id)
    {
        return wishListMapper.selectByAccountId(u_Account,p_Id);
    }

    @Override
    public List<WishProduct> selectByAccount(String u_Account)
    {
        return wishListMapper.selectByAccount(u_Account);
    }

    @Override
    public void deleteByAccountId(String u_Account,int p_Id)
    {
        wishListMapper.deleteByAccountId(u_Account,p_Id);
    }

}
