package com.team.springboot.service;

import com.team.springboot.pojo.Address;
import com.team.springboot.pojo.Order;

import java.util.List;

public interface OrderService {

    List<Order> selectOrderAndProductBuy(String Buy_Account);
    List<Order> selectOrderAndProductSell(String account);
    List<Order> selectBypName(String p_Name);
    List<Order> selectBySeller(String Seller);
    List<Order> selectByBuyer(String Buyer);
    List<Order> selectByBuyerAndSeller(String Seller,String Buyer);
    List<Order> selectAll();
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
    int countBypName(String p_Name);
    int countBySeller(String Seller);
    int countAll();

    String selectExpressIdById(String o_Id);
    void updateExpressIdById(String o_Id, String expressId);
}
