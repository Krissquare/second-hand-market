package com.team.springboot.pojo;


public class User {
    private String u_Account;
    private String u_Name;
    private String u_Password;
    private String u_RePassword;
    private String u_Email;
    private String u_Sex;
    private String u_Url;

    public String getU_Url() {
        return u_Url;
    }

    public void setU_Url(String u_Url) {
        this.u_Url = u_Url;
    }

    public String getU_Account() {
        return u_Account;
    }

    public void setU_Account(String u_Account) {
        this.u_Account = u_Account;
    }

    private String u_Phone;

    public String getU_RePassword() {
        return u_RePassword;
    }

    public void setU_RePassword(String u_RePassword) {
        this.u_RePassword = u_RePassword;
    }

    public String getU_Name() {
        return u_Name;
    }

    public void setU_Name(String u_Name) {
        this.u_Name = u_Name;
    }

    public String getU_Password() {
        return u_Password;
    }

    public void setU_Password(String u_Password) {
        this.u_Password = u_Password;
    }

    public String getU_Email() {
        return u_Email;
    }

    public void setU_Email(String u_Email) {
        this.u_Email = u_Email;
    }

    public String getU_Sex() {
        return u_Sex;
    }

    public void setU_Sex(String u_Sex) {
        this.u_Sex = u_Sex;
    }

    public String getU_Phone() {
        return u_Phone;
    }

    public void setU_Phone(String u_Phone) {
        this.u_Phone = u_Phone;
    }

    public User() {

    }

    public User(String u_Account, String u_Name, String u_Password, String u_Email, String u_Sex, String u_Phone) {
        this.u_Account = u_Account;
        this.u_Name = u_Name;
        this.u_Password = u_Password;
        this.u_Email = u_Email;
        this.u_Sex = u_Sex;
        this.u_Phone = u_Phone;
    }

    @Override
    public String toString() {
        return "u_Account:" + this.getU_Account() + " u_Name" + this.u_Name + " u_Password:" + this.getU_Password() + " u_Sex:" + this.u_Sex;
    }
}
