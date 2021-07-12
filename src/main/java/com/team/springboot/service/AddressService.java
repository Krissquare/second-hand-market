package com.team.springboot.service;


import com.team.springboot.pojo.Address;

import java.util.List;

public interface AddressService {

    Address selectAddressAll(String a_Account);
    void deleteAddressAll(String a_Account);
    void insertAddressOne(String a_Account, String a_Address1,String a_Address2,String a_Address3,String a_Address4);
    void updateAddressByAccount(Address a);
}
