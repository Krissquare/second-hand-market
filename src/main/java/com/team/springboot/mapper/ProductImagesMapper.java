package com.team.springboot.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductImagesMapper {

    @Select("select * from product_images where p_Id = #{0}")
    public List<String> selectAllImages(int p_Id);

    @Insert("insert into product_images value(#{0},#{1})")
    public void insertOneImage(int p_Id, String p_Image);

    @Delete("delete from product_images where p_Id=#{0} and p_Image=#{1}")
    public void deleteOneImage(int p_Id, String p_Image);

    @Delete("delete from product_images where p_Id=#{0}")
    public void deleteAllImages(int p_Id);
}
