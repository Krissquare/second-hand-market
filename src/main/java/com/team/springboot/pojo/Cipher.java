package com.team.springboot.pojo;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;

public class Cipher {
    public static String Encipher(String originPassword){
        String encipheredPassword = originPassword;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(originPassword.getBytes());
            encipheredPassword = new BigInteger(1,md5.digest()).toString(16);
        }catch (NoSuchAlgorithmException e){
            System.err.println("没有这个加密算法");
        }
        return encipheredPassword;
    }

    public static String Decipher(String encipheredPassword){
        String originPassword = encipheredPassword;

        return originPassword;
    }

    private static ArrayList<String> whiteList = new ArrayList<String>(Arrays.asList("admin","kris","user1","user2","user3"));

    public static Boolean isInWhiteList(String userName){//无需加密的用户
        for (String s: whiteList){
            if (userName.equals(s)){
                return true;
            }
        }
        return false;
    }
}
