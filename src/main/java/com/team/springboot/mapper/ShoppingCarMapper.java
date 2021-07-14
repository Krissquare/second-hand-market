package com.team.springboot.mapper;

import com.team.springboot.pojo.ShoppingCar;
import com.team.springboot.pojo.ShoppingCarProduct;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShoppingCarMapper {
    @Insert("insert into shoppingcar(u_Account, p_Id,p_Num) value (#{0},#{1},1)")
    void insertOne(String u_Account, int p_Id);

    @Select("select * from shoppingcar where s_Id = #{0}")
    ShoppingCar selectById(String s_Id);

    @Select("select * from shoppingcar where u_Account=#{0} and p_Id=#{1}")
    ShoppingCar selectByAccountId(String u_Account,int p_Id);

    @Select("select p.p_Id,s.s_Id, p.p_Title, p.p_href, p.p_Price,s.p_Num \n" +
            "from shoppingcar s, product p\n" +
            "where s.u_Account = #{0} and s.p_Id = p.p_Id")
    List<ShoppingCarProduct> selectShoppingCarProductById(String u_Account);

    @Select("select count(s_Id) from shoppingcar where u_Account = #{u_Account}")
    int getCountByAccount(String u_Account);

    @Select("select IFNULL(sum(p_Price),0) from shoppingcar, product where u_Account = #{u_Account} and shoppingcar.p_Id = product.p_Id")
    double getTotalPrice(String u_Account);
//
    @Delete("Delete from shoppingcar where s_Id = #{0} ")
    void deleteById(int s_Id);

    @Update("update shoppingcar set p_Num=p_Num+#{2} where u_Account=#{0} and p_Id=#{1}")
    void updateByAccountId(String u_Account,int p_Id,int num);

}