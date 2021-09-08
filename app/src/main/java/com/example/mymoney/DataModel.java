package com.example.mymoney;

public class DataModel {
    String listmemo;
    int listmoney;

    public String getListmemo() {
        return listmemo;
    }

    public void setListmemo(String listmemo) {
        this.listmemo = listmemo;
    }

    public int getListmoney() {
        return listmoney;
    }

    public void setListmoney(int listmoney) {
        this.listmoney = listmoney;
    }

    public DataModel(String listmemo, int listmoney) {
        this.listmemo = listmemo;
        this.listmoney = listmoney;
    }
}
