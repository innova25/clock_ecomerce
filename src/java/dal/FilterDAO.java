/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.images;
import model.product;
import model.review;

/**
 *
 * @author admin
 */
public class FilterDAO extends DBContext {

    public List<images> getLinkImgByIdPro(int id) {
        List<images> list = new ArrayList<>();
        String sql = "select [images].[link] from [images] where [images].[productid] = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                images img = new images(rs.getString("link"));
                list.add(img);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<review> getReviewByIdPro(int id) {
        List<review> list = new ArrayList<>();
        String sql = "select [reviews].[reviewid],[reviews].[content],[reviews].[rate],[reviews].[review_date],[reviews].[idaccount],[reviews].[productid],[account].[realname]\n"
                + "from [reviews] \n"
                + "join [account] on [reviews].[idaccount] = [account].[id]\n"
                + "where [reviews].[productid] = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                review re = new review(rs.getInt("reviewid"), rs.getString("content"), rs.getDate("review_date"), rs.getInt("idaccount"), rs.getInt("productid"), rs.getInt("rate"), rs.getString("realname"));
                list.add(re);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<product> listBy2Filter(int cate, int type) {
        List<product> list = new ArrayList<>();
        String sql = "select[product].[id],[product].[name],[product].[describe] ,[product].[price],[product].[dateupdate],[product].[status],[product].[source],[product].[guarantee],[product].[shell],[product].[glasses],[product].[energy],[product].[waterproof],[product].[facesize],[product].[wiresize],[product].[checkgoods],[product].[advise],[product].[idtypeproduct],[product].[dispercent],([product].[price] - ([product].[price]*([product].[dispercent]*0.01))) as [newprice],COALESCE(SUM([orderdetail].[quantity]), 0) AS totalsale\n"
                + "FROM product\n"
                + "join [orderdetail] on [product].[id] = [orderdetail].[productid]\n"
                + "JOIN typeproduct ON product.idtypeproduct = typeproduct.id\n"
                + "LEFT JOIN category ON typeproduct.categoryid = category.id\n"
                + "WHERE (category.id = ? )\n"
                + "AND (typeproduct.id = ? )\n"
                + "group by [product].[id],[product].[name],[product].[describe] ,[product].[price],[product].[dateupdate],[product].[status],[product].[source],[product].[guarantee],[product].[shell],[product].[glasses],[product].[energy],[product].[waterproof],[product].[facesize],[product].[wiresize],[product].[checkgoods],[product].[advise],[product].[idtypeproduct],[product].[dispercent]\n";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, cate);
            pre.setInt(2, type);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                List<images> listlink = getLinkImgByIdPro(rs.getInt("id"));
                List<review> listreview = getReviewByIdPro(rs.getInt("id"));
                product p = new product(rs.getInt("id"), rs.getString("name"), rs.getString("describe"), rs.getInt("price"), rs.getDate("dateupdate"), rs.getString("status"), rs.getString("source"), rs.getString("guarantee"), rs.getString("shell"), rs.getString("glasses"), rs.getString("energy"), rs.getString("waterproof"), rs.getInt("facesize"), rs.getInt("wiresize"), rs.getString("checkgoods"), rs.getString("advise"), rs.getInt("idtypeproduct"), rs.getInt("totalsale"), listlink, listreview, rs.getInt("dispercent"), rs.getInt("newprice"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public List<product> listBy1Filtera(int cate) {
        List<product> list = new ArrayList<>();
        String sql = "select[product].[id],[product].[name],[product].[describe] ,[product].[price],[product].[dateupdate],[product].[status],[product].[source],[product].[guarantee],[product].[shell],[product].[glasses],[product].[energy],[product].[waterproof],[product].[facesize],[product].[wiresize],[product].[checkgoods],[product].[advise],[product].[idtypeproduct],[product].[dispercent],([product].[price] - ([product].[price]*([product].[dispercent]*0.01))) as [newprice],COALESCE(SUM([orderdetail].[quantity]), 0) AS totalsale\n"
                + "FROM product\n"
                + "join [orderdetail] on [product].[id] = [orderdetail].[productid]\n"
                + "JOIN typeproduct ON product.idtypeproduct = typeproduct.id\n"
                + "LEFT JOIN category ON typeproduct.categoryid = category.id\n"
                + "WHERE (category.id = ? )\n"
                + "group by [product].[id],[product].[name],[product].[describe] ,[product].[price],[product].[dateupdate],[product].[status],[product].[source],[product].[guarantee],[product].[shell],[product].[glasses],[product].[energy],[product].[waterproof],[product].[facesize],[product].[wiresize],[product].[checkgoods],[product].[advise],[product].[idtypeproduct],[product].[dispercent]\n";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, cate);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                List<images> listlink = getLinkImgByIdPro(rs.getInt("id"));
                List<review> listreview = getReviewByIdPro(rs.getInt("id"));
                product p = new product(rs.getInt("id"), rs.getString("name"), rs.getString("describe"), rs.getInt("price"), rs.getDate("dateupdate"), rs.getString("status"), rs.getString("source"), rs.getString("guarantee"), rs.getString("shell"), rs.getString("glasses"), rs.getString("energy"), rs.getString("waterproof"), rs.getInt("facesize"), rs.getInt("wiresize"), rs.getString("checkgoods"), rs.getString("advise"), rs.getInt("idtypeproduct"), rs.getInt("totalsale"), listlink, listreview, rs.getInt("dispercent"), rs.getInt("newprice"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<product> listBy1Filterb(int type) {
        List<product> list = new ArrayList<>();
        String sql = "select[product].[id],[product].[name],[product].[describe] ,[product].[price],[product].[dateupdate],[product].[status],[product].[source],[product].[guarantee],[product].[shell],[product].[glasses],[product].[energy],[product].[waterproof],[product].[facesize],[product].[wiresize],[product].[checkgoods],[product].[advise],[product].[idtypeproduct],[product].[dispercent],([product].[price] - ([product].[price]*([product].[dispercent]*0.01))) as [newprice],COALESCE(SUM([orderdetail].[quantity]), 0) AS totalsale\n"
                + "FROM product\n"
                + "join [orderdetail] on [product].[id] = [orderdetail].[productid]\n"
                + "JOIN typeproduct ON product.idtypeproduct = typeproduct.id\n"
                + "LEFT JOIN category ON typeproduct.categoryid = category.id\n"
                + "AND (typeproduct.id = ? )\n"
                + "group by [product].[id],[product].[name],[product].[describe] ,[product].[price],[product].[dateupdate],[product].[status],[product].[source],[product].[guarantee],[product].[shell],[product].[glasses],[product].[energy],[product].[waterproof],[product].[facesize],[product].[wiresize],[product].[checkgoods],[product].[advise],[product].[idtypeproduct],[product].[dispercent]\n";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, type);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                List<images> listlink = getLinkImgByIdPro(rs.getInt("id"));
                List<review> listreview = getReviewByIdPro(rs.getInt("id"));
                product p = new product(rs.getInt("id"), rs.getString("name"), rs.getString("describe"), rs.getInt("price"), rs.getDate("dateupdate"), rs.getString("status"), rs.getString("source"), rs.getString("guarantee"), rs.getString("shell"), rs.getString("glasses"), rs.getString("energy"), rs.getString("waterproof"), rs.getInt("facesize"), rs.getInt("wiresize"), rs.getString("checkgoods"), rs.getString("advise"), rs.getInt("idtypeproduct"), rs.getInt("totalsale"), listlink, listreview, rs.getInt("dispercent"), rs.getInt("newprice"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {
        FilterDAO dao = new FilterDAO();
        List<product> list = new ArrayList<>();
//        list = dao.listByFilter(null, 1);
        System.out.println(list.size());
        for (product p : list) {
            System.out.println(p.getName() + "," + p.getNewprice());
        }
    }
}
