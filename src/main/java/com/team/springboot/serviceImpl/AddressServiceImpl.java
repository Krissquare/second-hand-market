package com.team.springboot.serviceImpl;

import com.team.springboot.mapper.AddressMapper;
import com.team.springboot.pojo.Address;
import com.team.springboot.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressMapper addressMapper;

    @Override
    public Address selectAddressAll(String a_Account) {
        return addressMapper.selectAddressAll(a_Account);
    }

    @Override
    public void deleteAddressAll(String a_Account) {
        addressMapper.deleteAddressAll(a_Account);
    }

    @Override
    public void insertAddressOne(String a_Account, String a_Address1, String a_Address2, String a_Address3, String a_Address4) {
        addressMapper.insertAddressOne(a_Account, a_Address1, a_Address2, a_Address3, a_Address4);
    }


    @Override
    public void updateAddressByAccount(Address a) {
        addressMapper.updateAddressByAccount(a);
    }
}
