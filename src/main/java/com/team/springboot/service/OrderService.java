package com.team.springboot.service;

import com.team.springboot.pojo.Address;
import com.team.springboot.pojo.Order;

import java.util.List;

public interface OrderService {

    List<Order> selectOrderAndProductBuy(String Buy_Account, int page, int limit);
    List<Order> selectOrderAndProductSell(String account, int page, int limit);
    Address selectAddressValue(String a_Account);
    void addressUpdate(String o_Baddress, String o_Id);
    void deleteOrderById(Order o);
    int orderBuyerCount(String o_Buyer);
    int orderSellerCount(String o_Seller);
    void StatusUpdate(Order o);
    List<Order> selectOrderAndProductBuyBySearchName(String Buy_Account,String SearchName, int page, int limit);
    List<Order> selectOrderAndProductSellBySearchName(String account,String SearchName, int page, int limit);
    int selectOrderCount();
    void insertOne(Order o);
}
