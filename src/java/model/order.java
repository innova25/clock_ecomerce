/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public class order {
    private int id;
    private int total;
    private String address;
    private Date orderdate;
    private Date orderdelivery;
    private int account;
    private int staffid;
    private String nameproduct;
    private int quantity;
    private account user;
    private int status;


    public order(int id, int total, String nameproduct, int quantity) {
        this.id = id;
        this.total = total;
        this.nameproduct = nameproduct;
        this.quantity = quantity;
    }

    public order(int total, String address, Date orderdate, Date orderdelivery, int account) {
        this.total = total;
        this.address = address;
        this.orderdate = orderdate;
        this.orderdelivery = orderdelivery;
        this.account = account;
    }
    
    

    public order(int id, int total, String address, Date orderdate, Date orderdelivery, int account, int staffid, String nameproduct, int quantity) {
        this.id = id;
        this.total = total;
        this.address = address;
        this.orderdate = orderdate;
        this.orderdelivery = orderdelivery;
        this.account = account;
        this.staffid = staffid;
        this.nameproduct = nameproduct;
        this.quantity = quantity;
    }

    public order(int id, int total, String address, Date orderdate, Date orderdelivery, int account, int staffid) {
        this.id = id;
        this.total = total;
        this.address = address;
        this.orderdate = orderdate;
        this.orderdelivery = orderdelivery;
        this.account = account;
        this.staffid = staffid;
    }

    public order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Date getOrderdelivery() {
        return orderdelivery;
    }

    public void setOrderdelivery(Date orderdelivery) {
        this.orderdelivery = orderdelivery;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getStaffid() {
        return staffid;
    }

    public void setStaffid(int staffid) {
        this.staffid = staffid;
    }

    public String getNameproduct() {
        return nameproduct;
    }

    public void setNameproduct(String nameproduct) {
        this.nameproduct = nameproduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public account getUser() {
        return user;
    }

    public void setUser(account user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
    
}
