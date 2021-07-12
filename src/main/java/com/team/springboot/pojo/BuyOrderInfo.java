package com.team.springboot.pojo;

public class BuyOrderInfo {
    private int s_Id;
    private String p_Title;
    private double p_Price;
    private String o_Seller;
    private String o_Baddress;
    private int p_Id;


    public BuyOrderInfo() {
    }


    @Override
    public String toString() {
        return "BuyOrderInfo{" +
                "p_Title='" + p_Title + '\'' +
                ", p_Price=" + p_Price +
                ", o_Seller='" + o_Seller + '\'' +
                ", o_Baddress='" + o_Baddress + '\'' +
                ", p_Id=" + p_Id +'\'' +
                '}';
    }

    public int getS_Id() {
        return s_Id;
    }

    public void setS_Id(int s_Id) {
        this.s_Id = s_Id;
    }

    public int getP_Id() {
        return p_Id;
    }

    public void setP_Id(int p_Id) {
        this.p_Id = p_Id;
    }

    public String getP_Title() {
        return p_Title;
    }

    public void setP_Title(String p_Title) {
        this.p_Title = p_Title;
    }

    public double getP_Price() {
        return p_Price;
    }

    public void setP_Price(double p_Price) {
        this.p_Price = p_Price;
    }

    public String getO_Seller() {
        return o_Seller;
    }

    public void setO_Seller(String o_Seller) {
        this.o_Seller = o_Seller;
    }

    public String getO_Baddress() {
        return o_Baddress;
    }

    public void setO_Baddress(String o_Baddress) {
        this.o_Baddress = o_Baddress;
    }



}
