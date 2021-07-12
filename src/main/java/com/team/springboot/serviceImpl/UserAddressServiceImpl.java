package com.team.springboot.serviceImpl;

import com.team.springboot.mapper.ProductCategoryMapper;
import com.team.springboot.mapper.UserAddressMapper;
import com.team.springboot.pojo.UserAddress;
import com.team.springboot.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressServiceImpl implements UserAddressService {
    @Autowired
    UserAddressMapper userAddressMapper;


    @Override
    public UserAddress selectuserAddressById(String u_Account) {
        return userAddressMapper.selectuserAddressById(u_Account);
    }
}
