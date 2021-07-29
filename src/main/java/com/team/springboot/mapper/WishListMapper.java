package com.team.springboot.mapper;

import com.team.springboot.pojo.ShoppingCar;
import com.team.springboot.pojo.WishProduct;
import com.team.springboot.pojo.Wishlist;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WishListMapper {

    @Insert("insert into wishlist(u_Account, p_Id) value (#{0},#{1})")
    void insertOne(String u_Account, int p_Id);

    @Select("select * from wishlist where u_Account=#{0} and p_Id=#{1}")
    Wishlist selectByAccountId(String u_Account,int p_Id);

    @Select("select w.w_Id,w.u_Account,w.p_Id,p.p_Title, p.p_href, p.p_Price,p.p_Des,p_originalPrice from wishlist w,product p where w.p_Id=p.p_Id and w.u_Account=#{0}")
    List<WishProduct> selectByAccount(String u_Account);

    @Delete("delete from wishlist where u_Account=#{0} and p_Id=#{1}")
    void deleteByAccountId(String u_Account,int p_Id);

}
