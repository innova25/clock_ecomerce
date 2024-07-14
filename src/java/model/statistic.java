/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class statistic {
    private int month;
    private int date;
    private int week;
    private int totalsale;

    public statistic() {
    }

    public statistic(int totalsale) {
        this.totalsale = totalsale;
    }
    
    public statistic(int month, int totalsale) {
        this.month = month;
        this.totalsale = totalsale;
    }
    
    

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }
    
    

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getTotalsale() {
        return totalsale;
    }

    public void setTotalsale(int totalsale) {
        this.totalsale = totalsale;
    }
    
    
}
