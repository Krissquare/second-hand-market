package com.team.springboot.pojo;

public class ShoppingCarProduct {
    private int s_Id;
    private String p_Title;
    private String p_href;
    private double p_Price;
    private int p_Id;

    public ShoppingCarProduct() {
    }

    public int getP_Id() {
        return p_Id;
    }

    public void setP_Id(int p_Id) {
        this.p_Id = p_Id;
    }

    public int getS_Id() {
        return s_Id;
    }

    public void setS_Id(int s_Id) {
        this.s_Id = s_Id;
    }

    public String getP_Title() {
        return p_Title;
    }

    public void setP_Title(String p_Title) {
        this.p_Title = p_Title;
    }

    public String getP_href() {
        return p_href;
    }

    public void setP_href(String p_href) {
        this.p_href = p_href;
    }

    public double getP_Price() {
        return p_Price;
    }

    public void setP_Price(double p_Price) {
        this.p_Price = p_Price;
    }
}
