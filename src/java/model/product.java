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
public class product {
    private int id;
    private String name;
    private String describe;
    private int price;
    private Date dateupdate;
    private String status;
    private String source;
    private String guarantee;
    private String shell;
    private String glasses;
    private String energy;
    private String waterproof;
    private int facesize;
    private int wiresize;
    private String checkgoods;
    private String advise;
    private int idtypeproduct;
    private int totalsale;
    private String img;
    private List<images> listimg;
    private List<review> listreview;
    private int dispercent;
    private int newprice;
    private int quantity;

    public product(int id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    
    public product() {
    }

    public product(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    

    public product(int id, String name, String describe, int price, Date dateupdate, String status, String source, String guarantee, String shell, String glasses, String energy, String waterproof, int facesize, int wiresize, String checkgoods, String advise, int idtypeproduct, int totalsale, List<images> listimg, List<review> listreview, int dispercent, int newprice) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.price = price;
        this.dateupdate = dateupdate;
        this.status = status;
        this.source = source;
        this.guarantee = guarantee;
        this.shell = shell;
        this.glasses = glasses;
        this.energy = energy;
        this.waterproof = waterproof;
        this.facesize = facesize;
        this.wiresize = wiresize;
        this.checkgoods = checkgoods;
        this.advise = advise;
        this.idtypeproduct = idtypeproduct;
        this.totalsale = totalsale;
        this.listimg = listimg;
        this.listreview = listreview;
        this.dispercent = dispercent;
        this.newprice = newprice;
    }
    
    
    
//  Thông tin cơ bản của sản phẩm , không có số lượng bán được
    
    public product(int id, String name, String describe, int price, Date dateupdate, String status, String source, String guarantee, String shell, String glasses, String energy, String waterproof, int facesize, int wiresize, String checkgoods, String advise, int idtypeproduct,String img,int dispercent, int newprice) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.price = price;
        this.dateupdate = dateupdate;
        this.status = status;
        this.source = source;
        this.guarantee = guarantee;
        this.shell = shell;
        this.glasses = glasses;
        this.energy = energy;
        this.waterproof = waterproof;
        this.facesize = facesize;
        this.wiresize = wiresize;
        this.checkgoods = checkgoods;
        this.advise = advise;
        this.idtypeproduct = idtypeproduct;
        this.img = img;
        this.dispercent = dispercent;
        this.newprice = newprice;
    }
    
    
    
    public product(int id, String name, String describe, int price, Date dateupdate, String status, String source, String guarantee, String shell, String glasses, String energy, String waterproof, int facesize, int wiresize, String checkgoods, String advise, int idtypeproduct,List<images> listimg,int dispercent, int newprice) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.price = price;
        this.dateupdate = dateupdate;
        this.status = status;
        this.source = source;
        this.guarantee = guarantee;
        this.shell = shell;
        this.glasses = glasses;
        this.energy = energy;
        this.waterproof = waterproof;
        this.facesize = facesize;
        this.wiresize = wiresize;
        this.checkgoods = checkgoods;
        this.advise = advise;
        this.idtypeproduct = idtypeproduct;
        this.listimg = listimg;
        this.dispercent = dispercent;
        this.newprice = newprice;
    }
// Thông tin cơ bản của sản phẩm ,có số lượng bán được
    public product(int id, String name, String describe, int price, Date dateupdate, String status, String source, String guarantee, String shell, String glasses, String energy, String waterproof, int facesize, int wiresize, String checkgoods, String advise, int idtypeproduct,List<images> listimg,int dispercent, int newprice, int totalsale) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.price = price;
        this.dateupdate = dateupdate;
        this.status = status;
        this.source = source;
        this.guarantee = guarantee;
        this.shell = shell;
        this.glasses = glasses;
        this.energy = energy;
        this.waterproof = waterproof;
        this.facesize = facesize;
        this.wiresize = wiresize;
        this.checkgoods = checkgoods;
        this.advise = advise;
        this.idtypeproduct = idtypeproduct;
        this.totalsale = totalsale;
        this.listimg = listimg;
        this.dispercent = dispercent;
        this.newprice = newprice;
    }
    
    public product(int id, String name, String describe, int price, Date dateupdate, String status, String source, String guarantee, String shell, String glasses, String energy, String waterproof, int facesize, int wiresize, String checkgoods, String advise, int idtypeproduct) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.price = price;
        this.dateupdate = dateupdate;
        this.status = status;
        this.source = source;
        this.guarantee = guarantee;
        this.shell = shell;
        this.glasses = glasses;
        this.energy = energy;
        this.waterproof = waterproof;
        this.facesize = facesize;
        this.wiresize = wiresize;
        this.checkgoods = checkgoods;
        this.advise = advise;
        this.idtypeproduct = idtypeproduct;
    }

    public product(int id, String name, String describe, int price, Date dateupdate, String status, String source, String guarantee, String shell, String glasses, String energy, String waterproof, int facesize, int wiresize, String checkgoods, String advise, int idtypeproduct, int totalsale, String img) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.price = price;
        this.dateupdate = dateupdate;
        this.status = status;
        this.source = source;
        this.guarantee = guarantee;
        this.shell = shell;
        this.glasses = glasses;
        this.energy = energy;
        this.waterproof = waterproof;
        this.facesize = facesize;
        this.wiresize = wiresize;
        this.checkgoods = checkgoods;
        this.advise = advise;
        this.idtypeproduct = idtypeproduct;
        this.totalsale = totalsale;
        this.img = img;
    }

    public product(int id, String name, String describe, int price, Date dateupdate, String status, String source, String guarantee, String shell, String glasses, String energy, String waterproof, int facesize, int wiresize, String checkgoods, String advise, int idtypeproduct, int dispercent, int newprice) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.price = price;
        this.dateupdate = dateupdate;
        this.status = status;
        this.source = source;
        this.guarantee = guarantee;
        this.shell = shell;
        this.glasses = glasses;
        this.energy = energy;
        this.waterproof = waterproof;
        this.facesize = facesize;
        this.wiresize = wiresize;
        this.checkgoods = checkgoods;
        this.advise = advise;
        this.idtypeproduct = idtypeproduct;
        this.dispercent = dispercent;
        this.newprice = newprice;
    }

    public List<review> getListreview() {
        return listreview;
    }

    public void setListreview(List<review> listreview) {
        this.listreview = listreview;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDateupdate() {
        return dateupdate;
    }

    public void setDateupdate(Date dateupdate) {
        this.dateupdate = dateupdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(String guarantee) {
        this.guarantee = guarantee;
    }

    public String getShell() {
        return shell;
    }

    public void setShell(String shell) {
        this.shell = shell;
    }

    public String getGlasses() {
        return glasses;
    }

    public void setGlasses(String glasses) {
        this.glasses = glasses;
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public String getWaterproof() {
        return waterproof;
    }

    public void setWaterproof(String waterproof) {
        this.waterproof = waterproof;
    }

    public int getFacesize() {
        return facesize;
    }

    public void setFacesize(int facesize) {
        this.facesize = facesize;
    }

    public int getWiresize() {
        return wiresize;
    }

    public void setWiresize(int wiresize) {
        this.wiresize = wiresize;
    }

    public String getCheckgoods() {
        return checkgoods;
    }

    public void setCheckgoods(String checkgoods) {
        this.checkgoods = checkgoods;
    }

    public String getAdvise() {
        return advise;
    }

    public void setAdvise(String advise) {
        this.advise = advise;
    }

    public int getIdtypeproduct() {
        return idtypeproduct;
    }

    public void setIdtypeproduct(int idtypeproduct) {
        this.idtypeproduct = idtypeproduct;
    }

    public int getTotalsale() {
        return totalsale;
    }

    public void setTotalsale(int totalsale) {
        this.totalsale = totalsale;
    }

    public int getDiscount() {
        return dispercent;
    }

    public void setDiscount(int dispercent) {
        this.dispercent = dispercent;
    }

    public int getNewprice() {
        return newprice;
    }

    public void setNewprice(int newprice) {
        this.newprice = newprice;
    }

    public List<images> getListimg() {
        return listimg;
    }

    public void setListimg(List<images> listimg) {
        this.listimg = listimg;
    }

    public int getDispercent() {
        return dispercent;
    }

    public void setDispercent(int dispercent) {
        this.dispercent = dispercent;
    }

    
}
