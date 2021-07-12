package com.team.springboot.mapper;

import com.team.springboot.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GoodsMapper {

    @Select("select p_Account, p_Title, p_Price,p_num from product  where p_Id = #{0}")
    Product selectProduct(int p_Id);
}
