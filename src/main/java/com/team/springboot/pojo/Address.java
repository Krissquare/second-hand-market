package com.team.springboot.pojo;

public class Address {
    private String a_Account;
    private String a_Address1;
    private String a_Address2;
    private String a_Address3;
    private String a_Address4;

    @Override
    public String toString() {
        return "a_Address1:" + this.getA_Address1() + " a_Address2:" + this.getA_Address2() + " a_Address3:" + this.getA_Address2() + " a_Address4:" + this.getA_Address4();
    }

    public String getA_Address1() {
        return a_Address1;
    }

    public void setA_Address1(String a_Address1) {
        this.a_Address1 = a_Address1;
    }

    public String getA_Address2() {
        return a_Address2;
    }

    public void setA_Address2(String a_Address2) {
        this.a_Address2 = a_Address2;
    }

    public String getA_Address3() {
        return a_Address3;
    }

    public void setA_Address3(String a_Address3) {
        this.a_Address3 = a_Address3;
    }

    public String getA_Address4() {
        return a_Address4;
    }

    public void setA_Address4(String a_Address4) {
        this.a_Address4 = a_Address4;
    }


    public String getA_Account() {
        return a_Account;
    }

    public void setA_Account(String a_Account) {
        this.a_Account = a_Account;
    }
}
