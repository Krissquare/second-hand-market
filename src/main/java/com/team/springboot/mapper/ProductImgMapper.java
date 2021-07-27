package com.team.springboot.mapper;

import com.team.springboot.pojo.ProductImg;
import com.team.springboot.pojo.UserHead;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductImgMapper {
    @Insert("Insert into productImg(p_Id,p_href) values(#{0},#{1})")
    void insert(int p_Id,String p_href);

    @Select("Select p_Id,p_href from productImg where p_Id=#{0}")
    List<ProductImg> selectById(int p_Id);
}
