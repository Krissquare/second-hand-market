package com.team.springboot.service;

import com.team.springboot.pojo.UserAddress;

import java.util.List;

public interface UserAddressService {
    UserAddress selectuserAddressById(String p_Account);
}
