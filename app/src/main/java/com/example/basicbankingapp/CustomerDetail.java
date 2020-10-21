package com.example.basicbankingapp;

public class CustomerDetail {
    int id,flag,idr;
    String name,email;
    double amount,credit;

    public CustomerDetail(int id, String name, String email, double amount, int flag, double credit, int idr) {
        this.id = id;
        this.flag = flag;
        this.idr = idr;
        this.name = name;
        this.email = email;
        this.amount = amount;
        this.credit = credit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getIdr() {
        return idr;
    }

    public void setIdr(int idr) {
        this.idr = idr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
}
