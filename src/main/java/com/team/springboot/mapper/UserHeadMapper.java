package com.team.springboot.mapper;

import com.team.springboot.pojo.User;
import com.team.springboot.pojo.UserHead;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserHeadMapper {
    @Insert("Insert into userHead(u_Url,u_Account) values(#{u_Url},#{u_Account})")
    void insertHead(UserHead userHead);
    @Update("update userHead set u_Url = #{u_Url} where u_Account = #{u_Account}")
    void updateHead(UserHead u);
    @Select("select * from userHead where u_Account = #{u_Account}")
    UserHead selectHead(String u_Account);
}
