package com.team.springboot.serviceImpl;

import com.team.springboot.mapper.OrderMapper;
import com.team.springboot.pojo.Address;
import com.team.springboot.pojo.Order;
import com.team.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Order> selectOrderAndProductBuy(String Buy_Account) {
        return orderMapper.selectOrderAndProductBuy(Buy_Account);
    }

    @Override
    public List<Order> selectOrderAndProductSell(String account) {
        return orderMapper.selectOrderAndProductSell(account);
    }

    @Override
    public Address selectAddressValue(String a_Account) {
        return orderMapper.selectAddressValue(a_Account);
    }

    @Override
    public void addressUpdate(String o_Baddress, String o_Id) {
        orderMapper.addressUpdate(o_Baddress, o_Id);
    }

    @Override
    public void deleteOrderById(Order o) {
        orderMapper.deleteOrderById(o);
    }

    @Override
    public int orderBuyerCount(String o_Buyer) {
        return orderMapper.orderBuyerCount(o_Buyer);
    }

    @Override
    public int orderSellerCount(String o_Seller){
        return orderMapper.orderSellerCount(o_Seller);
    }

    @Override
    public void StatusUpdate(Order o) {
        orderMapper.StatusUpdate(o);
    }

    @Override
    public List<Order> selectOrderAndProductBuyBySearchName(String Buy_Account, String SearchName, int page, int limit) {
        return orderMapper.selectOrderAndProductBuyBySearchName(Buy_Account, SearchName, page, limit);
    }

    @Override
    public List<Order> selectOrderAndProductSellBySearchName(String account, String SearchName, int page, int limit) {
        return orderMapper.selectOrderAndProductSellBySearchName(account, SearchName, page, limit);
    }

    @Override
    public int selectOrderCount() {
        return orderMapper.selectOrderCount();
    }

    @Override
    public void insertOne(Order o) {
        orderMapper.insertOne(o);
    }

    @Override
    public List<Order> selectBypName(String p_Name){
        return orderMapper.selectBypName(p_Name);
    }

    @Override
    public  List<Order> selectBySeller(String Seller)
    {
        return orderMapper.selectBySeller(Seller);
    }

    @Override
    public int countBySeller(String Seller)
    {
        return orderMapper.countBySeller(Seller);
    }


    @Override
    public List<Order> selectByBuyer(String Buyer)
    {
        return orderMapper.selectByBuyer(Buyer);
    }

    @Override
    public List<Order> selectByBuyerAndSeller(String Seller,String Buyer)
    {
        return orderMapper.selectByBuyerAndSeller(Seller, Buyer);
    }


    @Override
    public int countBypName(String p_Name)
    {
        return orderMapper.countBypName(p_Name);
    }

    @Override
    public List<Order> selectAll()
    {
        return orderMapper.selectAll();
    }

    @Override
    public int countAll()
    {
        return orderMapper.countAll();
    }

    @Override
    public String selectExpressIdById(String o_Id){
        return  orderMapper.selectExpressIdById(o_Id);
    }

    @Override
    public void updateExpressIdById(String o_Id, String expressId){
        orderMapper.updateExpressIdById(o_Id,expressId);
    }

    @Override
    public List<Order> selectOrderAndProductBuyByStatus(String Buy_Account,String Status)
    {
        return orderMapper.selectOrderAndProductBuyByStatus(Buy_Account,Status);
    }
    @Override
    public  List<Order> selectOrderAndProductSellByStatus(String account,String Status)
    {
        return orderMapper.selectOrderAndProductSellByStatus(account,Status);
    }
}
