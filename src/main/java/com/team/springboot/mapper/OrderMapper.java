package com.team.springboot.mapper;

import com.team.springboot.pojo.Address;
import com.team.springboot.pojo.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("select o.o_Id, p.p_href, p.p_Price, p.p_Title,p.p_originalPrice, o.o_Buyer, o.o_Seller, o.o_Baddress, o.o_ItemId, o.o_Status, o.o_ExpressId, o.o_Date ,o.p_Num from order2 o, product p where o_ItemId = p.p_Id and o.o_Buyer = #{0}")
    List<Order> selectOrderAndProductBuy(String Buy_Account);

    @Select("select o.o_Id, p.p_href, p.p_Price, p.p_Title, o.o_Buyer, o.o_Seller, o.o_Baddress, o.o_ItemId, o.o_Status, o.o_ExpressId, o.o_Date,o.p_Num from order2 o, product p where o_ItemId = p.p_Id and o.o_Buyer = #{0} and o.o_Status=#{1}")
    List<Order> selectOrderAndProductBuyByStatus(String Buy_Account,String Status);

    @Select("select o.o_Id, p.p_href, p.p_Price, p.p_Title,p.p_originalPrice, o.o_Buyer, o.o_Seller, o.o_Baddress, o.o_ItemId, o.o_Status, o.o_ExpressId, o.o_Date,o.p_Num from order2 o, product p where o_ItemId = p.p_Id and o.o_Seller = #{0}")
    List<Order> selectOrderAndProductSell(String account);

    @Select("select o.o_Id, p.p_href, p.p_Price, p.p_Title, o.o_Buyer, o.o_Seller, o.o_Baddress,o.o_Saddress,o.o_Date, o.o_ItemId, o.o_Status, o.o_ExpressId, o.p_Num from order2 o, product p where o_ItemId = p.p_Id and o.o_Seller = #{0} and o.o_Status=#{1}")
    List<Order> selectOrderAndProductSellByStatus(String account,String Status);

    @Select("select o.o_Id, p.p_href, p.p_Price, p.p_Title, o.o_Buyer, o.o_Seller, o.o_Baddress,o.o_Saddress,o.o_Date, o.o_ItemId, o.o_Status, o.o_ExpressId, o.p_Num from order2 o, product p where o_ItemId = p.p_Id and p.p_Name like #{0}")
    List<Order> selectBypName(String p_Name);

    @Select("select o.o_Id, p.p_href, p.p_Price, p.p_Title, o.o_Buyer, o.o_Seller, o.o_Baddress,o.o_Saddress,o.o_Date, o.o_ItemId, o.o_Status, o.o_ExpressId, o.p_Num from order2 o, product p where o_ItemId = p.p_Id and o.o_Seller like #{0}")
    List<Order> selectBySeller(String Seller);

    @Select("select o.o_Id, p.p_href, p.p_Price, p.p_Title, o.o_Buyer, o.o_Seller, o.o_Baddress,o.o_Saddress,o.o_Date, o.o_ItemId, o.o_Status, o.o_ExpressId, o.p_Num from order2 o, product p where o_ItemId = p.p_Id and o.o_Buyer like #{0}")
    List<Order> selectByBuyer(String Buyer);

    @Select("select o_Id,o_ItemId,p_Num,o_Seller,o_Buyer,o_Baddress,o_Saddress,o_Date,o_Status,o_ExpressId from order2 where o_Id = #{0}")
    Order selectByOrderID(String o_Id);


    @Select("select o.o_Id, p.p_href, p.p_Price, p.p_Title, o.o_Buyer, o.o_Seller, o.o_Baddress,o.o_Saddress,o.o_Date, o.o_ItemId, o.o_Status, o.o_ExpressId, o.p_Num from order2 o, product p where o_ItemId = p.p_Id and o.o_Seller like #{0} and o.o_Buyer like #{1}")
    List<Order> selectByBuyerAndSeller(String Seller,String Buyer);

    @Select("select count(o.o_Id) from order2 o,product p where o_ItemId = p.p_Id and p.p_Name like #{0}")
    int countBypName(String p_Name);

    @Select("select count(o.o_Id) from order2 o,product p where o_ItemId = p.p_Id and o.o_Seller like #{0}")
    int countBySeller(String Seller);

    @Select("select o.o_Id, p.p_href, p.p_Price, p.p_Title, o.o_Buyer, o.o_Seller, o.o_Baddress,o.o_Saddress, o.o_Date,o.o_ItemId, o.o_Status, o.o_ExpressId, o.p_Num from order2 o, product p where o_ItemId = p.p_Id")
    List<Order> selectAll();

    @Select("select count(o.o_Id) from order2 o,product p where o_ItemId = p.p_Id")
    int countAll();

    //??????????????????
    @Select("select * from address where a_Account = #{a_Account}")
    Address selectAddressValue(String a_Account);

    @Update("update order2 set o_Baddress = #{0} where o_Id = #{1}")
    void addressUpdate(String o_Baddress, String o_Id);

    @Delete("delete from order2 where o_Id = #{o_Id}")
    void deleteOrderById(Order o);

    @Select("select count(o_Id) from order2 where o_Buyer = #{o_Buyer}")
    int orderBuyerCount(String o_Buyer);

    @Select("select count(o_Id) from order2 where o_Seller = #{o_Seller}")
    int orderSellerCount(String o_Seller);

    // ??????????????????
    @Update("update order2 set o_Status = #{o_Status} where o_Id = #{o_Id}")
    void StatusUpdate(Order o);

    @Select("select o.o_Id, p.p_href, p.p_Title, o.o_Buyer, o.o_Seller, o.o_Baddress, o.o_ItemId, o.o_Status, o.o_ExpressId, o.o_Date, o.p_Num from order2 o, product p where o_ItemId = p.p_Id and o.o_Buyer = #{0} and p_Title like #{1} limit #{2}, #{3}")
    List<Order> selectOrderAndProductBuyBySearchName(String Buy_Account,String SearchName, int page, int limit);

    @Select("select o.o_Id, p.p_href, p.p_Title, o.o_Buyer, o.o_Seller, o.o_Baddress, o.o_ItemId, o.o_Status, o.o_ExpressId, o.o_Date, o.p_Num from order2 o, product p where o_ItemId = p.p_Id and o.o_Seller = #{0} and p_Title like #{1} limit #{2}, #{3}")
    List<Order> selectOrderAndProductSellBySearchName(String account,String SearchName, int page, int limit);

    @Select("select count(o_Id) from order2")
    int selectOrderCount();

    @Insert("insert into order2(o_Id, o_ItemId, o_Buyer, o_Seller, o_Baddress, o_Saddress, o_Date, o_Status) values(#{o_Id},#{o_ItemId}, #{o_Buyer}, #{o_Seller}, #{o_Baddress}, #{o_Saddress}, #{o_Date}, #{o_Status})")
    void insertOne(Order o);

    @Select("select o_ExpressId from order2 where o_Id = #{0}")
    String selectExpressIdById(String o_Id);

    @Update("update order2 set o_ExpressId = #{1} where o_Id = #{0}")
    void updateExpressIdById(String o_Id, String expressId);

}
