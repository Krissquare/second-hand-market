package com.team.springboot.service;


import com.team.springboot.pojo.Address;
import com.team.springboot.pojo.Password;
import com.team.springboot.pojo.Product;
import com.team.springboot.pojo.User;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserService {
    User selectUserById(String u_Account);
    void updateUser(User u);
    String selectPasswordById(String u_Account);
    void updatePassword(Password p);
    Address selectAddressAll(String a_Account);
    void insertOne(User u);
    void updatePwd(User u);
    int selectCount();
    int selectCountByAccount(String p_Account);
    List<User> selectUserAll(int page, int limit);
    void deleteUser(String u_Account);
    List<User>selectUserByIdrtlist(String u_Account);
    void updateHeadp(String url,String u_Account);

}
