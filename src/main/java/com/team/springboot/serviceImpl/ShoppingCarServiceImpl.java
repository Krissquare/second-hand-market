package com.team.springboot.serviceImpl;

import com.team.springboot.mapper.ShoppingCarMapper;
import com.team.springboot.pojo.ShoppingCar;
import com.team.springboot.pojo.ShoppingCarProduct;
import com.team.springboot.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Double getTotalPrice(String u_Account) {
        if (shoppingCarMapper.getTotalPrice(u_Account) == null) {
            return 0.0;
        }
        else return shoppingCarMapper.getTotalPrice(u_Account);
    }

    @Override
    public void deleteById(int s_Id){
        shoppingCarMapper.deleteById(s_Id);
    }

    @Override
    public void updateByAccountId(String u_Account,int p_Id,int num){
        shoppingCarMapper.updateByAccountId(u_Account,p_Id,num);
    }

    @Override
    public ShoppingCar selectByAccountId(String u_Account,int p_Id)
    {
        return shoppingCarMapper.selectByAccountId(u_Account,p_Id);
    }

    @Override
    public void updateNum(String u_Account,int p_Id,int num)
    {
        shoppingCarMapper.updateNum(u_Account,p_Id,num);
    }
}
