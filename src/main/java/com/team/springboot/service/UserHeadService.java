package com.team.springboot.service;

import com.team.springboot.pojo.UserHead;
import org.springframework.stereotype.Service;


public interface UserHeadService {

    void insertHead(UserHead userHead);
    void updateHead(UserHead userHead);
    UserHead selectHead(String u_Account);
}
