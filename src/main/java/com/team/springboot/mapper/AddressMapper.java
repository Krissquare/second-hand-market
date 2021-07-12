package com.team.springboot.mapper;


import com.team.springboot.pojo.Address;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AddressMapper {

    @Select("select * from address where a_Account = #{a_Account}")
    Address selectAddressAll(String a_Account);

    @Delete("delete from address where a_Account = #{a_Account}")
    void deleteAddressAll(String a_Account);

    @Insert("insert into address values(#{0}, #{1},#{2},#{3},#{4})")
    void insertAddressOne(String a_Account, String a_Address1,String a_Address2,String a_Address3,String a_Address4);

    @Update("update address set a_Address1 = #{a_Address1}, a_Address2 = #{a_Address2}, a_Address3 = #{a_Address3}, a_Address4 = #{a_Address4} where a_Account = #{a_Account}")
    void updateAddressByAccount(Address a);

}
