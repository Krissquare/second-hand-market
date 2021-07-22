package com.team.springboot.pojo;

public class Wishlist {
    private int w_Id;
    private String u_Account;
    private int p_Id;
    public int getP_Id()
    {
        return p_Id;
    }
     public void setP_Id(int p_Id)
     {
         this.p_Id=p_Id;
     }
     public int getW_Id()
     {
         return w_Id;
     }
     public void setW_Id(int w_Id)
     {
         this.w_Id=w_Id;
     }
     public String getU_Account()
     {
         return u_Account;
     }
     public void setU_Account(String u_Account)
     {
         this.u_Account=u_Account;
     }
}
