package com.team.springboot.mapper;

import com.team.springboot.pojo.UserAddress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserAddressMapper {
    @Select("select * from User inner join Address on user.u_Account=Address.a_Account where u_Account=#{0}")
    UserAddress selectuserAddressById(String u_Account);
}
