/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class payments {
    private int id;
    private double amount;
    private String paymentmethod;
    private int idorderdetail;
    private int idaccount;

    public payments() {
    }

    public payments(int id, double amount, String paymentmethod, int idorderdetail, int idaccount) {
        this.id = id;
        this.amount = amount;
        this.paymentmethod = paymentmethod;
        this.idorderdetail = idorderdetail;
        this.idaccount = idaccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public int getIdorderdetail() {
        return idorderdetail;
    }

    public void setIdorderdetail(int idorderdetail) {
        this.idorderdetail = idorderdetail;
    }

    public int getIdaccount() {
        return idaccount;
    }

    public void setIdaccount(int idaccount) {
        this.idaccount = idaccount;
    }
    
    
}
