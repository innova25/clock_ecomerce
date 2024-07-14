/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author admin
 */
public class review {
    private int reviewid;
    private String content;
    private Date reviewdate;
    private int idaccount;
    private int productid;
    private int rate;
    private String nameclient;

   

    public review() {
    }

    public review(int reviewid, String content, Date reviewdate, int idaccount, int productid, int rate, String nameclient) {
        this.reviewid = reviewid;
        this.content = content;
        this.reviewdate = reviewdate;
        this.idaccount = idaccount;
        this.productid = productid;
        this.rate = rate;
        this.nameclient = nameclient;
    }


    public int getReviewid() {
        return reviewid;
    }

    public void setReviewid(int reviewid) {
        this.reviewid = reviewid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReviewdate() {
        return reviewdate;
    }

    public void setReviewdate(Date reviewdate) {
        this.reviewdate = reviewdate;
    }

    public int getIdaccount() {
        return idaccount;
    }

    public void setIdaccount(int idaccount) {
        this.idaccount = idaccount;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getNameclient() {
        return nameclient;
    }

    public void setNameclient(String nameclient) {
        this.nameclient = nameclient;
    }

    @Override
    public String toString() {
        return "review{" + "reviewid=" + reviewid + ", content=" + content + ", reviewdate=" + reviewdate + ", idaccount=" + idaccount + ", productid=" + productid + ", rate=" + rate + ", nameclient=" + nameclient + '}';
    }

    
    
}
