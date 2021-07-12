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
    public List<Order> selectOrderAndProductBuy(String Buy_Account, int page, int limit) {
        return orderMapper.selectOrderAndProductBuy(Buy_Account, page, limit);
    }

    @Override
    public List<Order> selectOrderAndProductSell(String account, int page, int limit) {
        return orderMapper.selectOrderAndProductSell(account, page, limit);
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
}
