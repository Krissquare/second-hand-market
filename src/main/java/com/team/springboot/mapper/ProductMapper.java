package com.team.springboot.mapper;

import com.team.springboot.pojo.Product;
import com.team.springboot.pojo.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("select count(*) from product")
    int selectCount();
    @Select("select count(*) from product where p_Account = #{0}")
    int selectCountByaccount(String p_Account);

    @Select("select count(*) from product where p_Name like #{0}")
    int selectCountByp_Name(String p_Name);
    @Select("select count(*) from product where p_Account = #{0} AND p_Name like #{1}")
    int selectCountByp_nameAndaccount(String p_Account,String p_Name);

    @Select("select p_href,p_Id,p_Account,p_Name,p_Title,p_originalPrice,p_Price,p_num,p_Date from product inner join Category on product.c_Id=Category.c_Id where (p_Title like #{0} OR p_Name like #{0} OR c_Name like #{0})")
    List<Product> selectProductByp_name(String p_Name);

    @Select("select p_Id,p_Account,p_Name,p_Title,p_Price,p_originalPrice,p_num,p_Date,p_Status from product where p_Id = #{0}")
    Product selectProductById(int p_ID);

    @Select("select * from product where p_Id = #{0}")
    Product selectProductsById(int p_ID);

    @Select("select p_Id,p_Account,p_Name,p_Title,p_Des,p_Price,p_Date,p_num from product where p_Id = #{0}")
    Product selectProductallById(int p_ID);

    @Delete("Delete from product where p_Id = #{0}")
    void deleteProductById(int p_ID);


    @Update("update product set p_Title = #{p_Title}, p_Des = #{p_Des}, p_Price = #{p_Price}, p_Date = #{p_Date}  where p_Id = #{p_Id}")
    void updateProduct(Product product);


    @Select("select p_href from product where p_Id = #{p_Id}")
    Product imgHref(int p_Id);

    @Update("update product set p_href = #{0} where p_Id = #{1}")
    void setHref(String p_href, int p_Id);

    @Update("update product set p_Status = #{0} where p_Id = #{1}")
    void setStatusById(String p_Status,int p_ID);

    @Update("update product set p_href1 = #{0} where p_Id = #{1}")
    void setHref1(String p_href, int p_Id);

    @Select("select * from product where p_Id = #{p_Id}")
    Product selectById(int p_Id);

    @Select("select p_Id,p_Account,p_Name,c_Name,p_Title,p_originalPrice,p_Price,p_href,p_num,p_Date,p_Status from product inner join Category on product.c_Id=Category.c_Id and p_num!=0 and p_Status!='已下架'")
    List<Product> selectProductAll();

}
