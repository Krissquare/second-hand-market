package com.team.springboot.serviceImpl;

import com.team.springboot.mapper.UserHeadMapper;
import com.team.springboot.pojo.UserHead;
import com.team.springboot.service.UserHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserHeadServicempl implements UserHeadService {
    @Autowired
    UserHeadMapper userHeadMapper;

    @Override
    public void insertHead(UserHead userHead)
    {
        userHeadMapper.insertHead(userHead);
    }
    @Override
    public void updateHead(UserHead userHead)
    {
        userHeadMapper.updateHead(userHead);
    }

    @Override
    public UserHead selectHead(String u_Account) {
        return userHeadMapper.selectHead(u_Account);
    }
}
