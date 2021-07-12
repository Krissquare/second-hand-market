package com.team.springboot.pojo;

public class UserHead {
    private String u_Url;
    private String u_Account;
    public String getU_Url() {
        return u_Url;
    }
    public void setU_Url(String u_Url) {
        this.u_Url = u_Url;
    }

    public String getU_Account() {
        return u_Account;
    }

    public UserHead()
    {

    }

    public UserHead(String u_Account)
    {
        this.u_Url=null;
        this.u_Account=u_Account;
    }
    public UserHead(String u_Url,String u_Account) {
        this.u_Url=u_Url;
        this.u_Account = u_Account;

    }
}
