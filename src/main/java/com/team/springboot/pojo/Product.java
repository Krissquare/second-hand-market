package com.team.springboot.pojo;


import java.sql.Date;

public class Product implements Comparable<Product>{
    private int p_Id;
    private String p_Account;
    private String p_Name;
    private String c_Id;
    private String p_Title;
    private Date p_Date;
    private Double p_originalPrice;
    private Double p_Price;
    private String p_Des;
    private String p_href;
    private String p_Status;
    private int p_num;
    public Product(int p_Id, String p_Des, Date p_Date) {
        this.p_Id = p_Id;
        this.p_Des = p_Des;
        this.p_Date = p_Date;
    }

    public Product(int p_Id, String p_Account, String p_Name, String p_Title,String p_Des, Double p_originalPrice,Double p_Price, Date p_Date,int p_num,String p_Status) {
        this.p_Id = p_Id;
        this.p_Account = p_Account;
        this.p_Name = p_Name;
        this.p_Title = p_Title;
        this.p_originalPrice=p_originalPrice;
        this.p_Price = p_Price;
        this.p_Des = p_Des;
        this.p_Date = p_Date;
        this.p_num=p_num;
        this.p_Status=p_Status;
    }

    public Product() {
    }



    public String getP_href() {
        return p_href;
    }

    public void setP_href(String p_href) {
        this.p_href = p_href;
    }

    public Product(int p_Id, String p_Account, String p_Name, String p_Title, Date p_Date,Double p_originalPrice ,Double p_Price, String p_Des) {
        this.p_Id = p_Id;
        this.p_Account = p_Account;
        this.p_Name = p_Name;
        this.p_Title = p_Title;
        this.p_originalPrice=p_originalPrice;
        this.p_Price = p_Price;
        this.p_Des = p_Des;
        this.p_Date = p_Date;
    }


    public Product(int p_Id, String p_Account, String p_Name, String p_Title, Double p_Price) {
        this.p_Id = p_Id;
        this.p_Account = p_Account;
        this.p_Name = p_Name;
        this.p_Title = p_Title;
        this.p_Price = p_Price;
    }

    public Product(int p_Id, String p_Account, String p_Name, String c_Id, String p_Title, String p_Des, Double p_Price, Date p_Date) {
        this.p_Id = p_Id;
        this.p_Account = p_Account;
        this.p_Name = p_Name;
        this.c_Id = c_Id;
        this.p_Title = p_Title;
        this.p_Des = p_Des;
        this.p_Price = p_Price;
        this.p_Date = p_Date;
    }

    public Product(int p_Id, String p_Account, String p_Name, String c_Id, String p_Title, String p_Des, Double p_Price) {
        this.p_Id = p_Id;
        this.p_Account = p_Account;
        this.p_Name = p_Name;
        this.c_Id = c_Id;
        this.p_Title = p_Title;
        this.p_Des = p_Des;
        this.p_Price = p_Price;
    }


    public int getP_Id() {
        return p_Id;
    }

    public void setP_Id(int p_Id) {
        this.p_Id = p_Id;
    }

    public String getP_Account() {
        return p_Account;
    }

    public void setP_Account(String p_Account) {
        this.p_Account = p_Account;
    }

    public String getP_Name() {
        return p_Name;
    }

    public Double getP_originalPrice() {
        return p_originalPrice;
    }

    public void setP_Name(String p_Name) {
        this.p_Name = p_Name;
    }

    public String getC_Id() {
        return c_Id;
    }

    public void setC_Id(String c_Id) {
        this.c_Id = c_Id;
    }

    public String getP_Title() {
        return p_Title;
    }

    public void setP_Title(String p_Title) {
        this.p_Title = p_Title;
    }

    public String getP_Des() {
        return p_Des;
    }

    public Double getP_Price() {
        return p_Price;
    }

    public void setP_Price(Double p_Price) {
        this.p_Price = p_Price;
    }

    public void setP_Des(String p_Des) {
        this.p_Des = p_Des;
    }

    public void setP_originalPrice(Double p_originalPrice) {
        this.p_originalPrice = p_originalPrice;
    }

    public Date getP_Date() {
        return p_Date;
    }

    public void setP_Date(Date p_Date) {
        this.p_Date = p_Date;
    }

    public int getP_num() {
        return p_num;
    }

    public void setP_num(int p_num) {
        this.p_num = p_num;
    }

    public String getP_Status() {
        return p_Status;
    }

    public void setP_Status(String p_Status) {
        this.p_Status = p_Status;
    }

    @Override
    public int compareTo(Product o)
    {
        return (int)(this.p_num-o.p_num);

    }
}
