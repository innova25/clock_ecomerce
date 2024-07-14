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
import model.typeproduct;

/**
 *
 * @author admin
 */
public class ProductMaleDAO extends DBContext {
// TÌM SẢN PHẨM BẰNG ID
    public product getProbyId(int id) {
        product p = new product();
        String sql = "select [product].[id],[product].[name],[product].[describe] ,[product].[price],[product].[dateupdate],[product].[status],[product].[source],[product].[guarantee],[product].[shell],[product].[glasses],[product].[energy],[product].[waterproof],[product].[facesize],[product].[wiresize],[product].[checkgoods],[product].[advise],[product].[idtypeproduct],[product].[dispercent],([product].[price] - ([product].[price]*([product].[dispercent]*0.01))) as [newprice],COALESCE(SUM([orderdetail].[quantity]), 0) AS totalsale\n"
                + "from [product]\n"
                + "left join [orderdetail] on [product].[id] = [orderdetail].[productid]\n"
                + "join [typeproduct] on [product].idtypeproduct = [typeproduct].[id]\n"
                + "where [product].[id] = ?\n"
                + "group by [product].[id],[product].[name],[product].[describe] ,[product].[price],[product].[dateupdate],[product].[status],[product].[source],[product].[guarantee],[product].[shell],[product].[glasses],[product].[energy],[product].[waterproof],[product].[facesize],[product].[wiresize],[product].[checkgoods],[product].[advise],[product].[idtypeproduct],[product].[dispercent]";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                List<images> listlink = getLinkImgByIdPro(rs.getInt("id"));
                List<review> listreview = getReviewByIdPro(rs.getInt("id"));
                p = new product(rs.getInt("id"), rs.getString("name"), rs.getString("describe"), rs.getInt("price"), rs.getDate("dateupdate"), rs.getString("status"), rs.getString("source"), rs.getString("guarantee"), rs.getString("shell"), rs.getString("glasses"), rs.getString("energy"), rs.getString("waterproof"), rs.getInt("facesize"), rs.getInt("wiresize"), rs.getString("checkgoods"), rs.getString("advise"), rs.getInt("idtypeproduct"), rs.getInt("totalsale"), listlink, listreview, rs.getInt("dispercent"), rs.getInt("newprice"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return p;
    }
// TẠO PHÂN TRANG
    public List<product> getListByPage(ArrayList<product> list, int start, int end) {
        ArrayList<product> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }
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
// LẤY TẤT CẢ CÁC SẢN PHẨM KHÔNG CÓ ĐIỀU KIỆN
    public List<product> getAllPro() {
        List<product> list = new ArrayList<>();
        String sql ="select[product].[id],[product].[name],[product].[describe] ,[product].[price],[product].[dateupdate],[product].[status],[product].[source],[product].[guarantee],[product].[shell],[product].[glasses],[product].[energy],[product].[waterproof],[product].[facesize],[product].[wiresize],[product].[checkgoods],[product].[advise],[product].[idtypeproduct],[product].[dispercent],([product].[price] - ([product].[price]*([product].[dispercent]*0.01))) as [newprice],COALESCE(SUM([orderdetail].[quantity]), 0) AS totalsale\n" +
                    "from [product]\n" +
                    "left join [orderdetail] on [product].[id] = [orderdetail].[productid]\n" +
                    "join [typeproduct] on [product].idtypeproduct = [typeproduct].[id]\n" +
                    "join [category] on [typeproduct].[categoryid] = [category].[id]\n" +
                    "where [category].[id] = 1\n" +
                    "group by [product].[id],[product].[name],[product].[describe] ,[product].[price],[product].[dateupdate],[product].[status],[product].[source],[product].[guarantee],[product].[shell],[product].[glasses],[product].[energy],[product].[waterproof],[product].[facesize],[product].[wiresize],[product].[checkgoods],[product].[advise],[product].[idtypeproduct],[product].[dispercent]";
                try {
            PreparedStatement pre = connection.prepareStatement(sql);
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
// BEST SELLER
    public List<product> getAllProBySale() {
        List<product> list = new ArrayList<>();
        String sql ="select [product].[id],[product].[name],[product].[describe] ,[product].[price],[product].[dateupdate],[product].[status],[product].[source],[product].[guarantee],[product].[shell],[product].[glasses],[product].[energy],[product].[waterproof],[product].[facesize],[product].[wiresize],[product].[checkgoods],[product].[advise],[product].[idtypeproduct],[product].[dispercent],([product].[price] - ([product].[price]*([product].[dispercent]*0.01))) as [newprice],COALESCE(SUM([orderdetail].[quantity]), 0) AS totalsale\n" +
                    "from [product]\n" +
                    "left join [orderdetail] on [product].[id] = [orderdetail].[productid]\n" +
                    "join [typeproduct] on [product].idtypeproduct = [typeproduct].[id]\n" +
                    "join [category] on [typeproduct].[categoryid] = [category].[id]\n" +
                    "where [category].[id] = 1\n" +
                    "group by [product].[id],[product].[name],[product].[describe] ,[product].[price],[product].[dateupdate],[product].[status],[product].[source],[product].[guarantee],[product].[shell],[product].[glasses],[product].[energy],[product].[waterproof],[product].[facesize],[product].[wiresize],[product].[checkgoods],[product].[advise],[product].[idtypeproduct],[product].[dispercent]\n" +
                    "order by [totalsale] desc";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                List<images> listlink = getLinkImgByIdPro(rs.getInt("id"));
                product p = new product(rs.getInt("id"), rs.getString("name"), rs.getString("describe"), rs.getInt("price"), rs.getDate("dateupdate"), rs.getString("status"), rs.getString("source"), rs.getString("guarantee"), rs.getString("shell"), rs.getString("glasses"), rs.getString("energy"), rs.getString("waterproof"), rs.getInt("facesize"), rs.getInt("wiresize"), rs.getString("checkgoods"), rs.getString("advise"), rs.getInt("idtypeproduct"), listlink, rs.getInt("dispercent"), rs.getInt("newprice"), rs.getInt("totalsale"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
// SẢN PHẨM MỚI NHẤT
    public List<product> getNewPro() {
        List<product> list = new ArrayList<>();
        String sql ="select  [product].[id],[product].[name],[product].[describe] ,[product].[price],[product].[dateupdate],[product].[status],[product].[source],[product].[guarantee],[product].[shell],[product].[glasses],[product].[energy],[product].[waterproof],[product].[facesize],[product].[wiresize],[product].[checkgoods],[product].[advise],[product].[idtypeproduct],[product].[dispercent],([product].[price] - ([product].[price]*([product].[dispercent]*0.01))) as [newprice]\n" +
                    "from [product]\n" +
                    "left join [orderdetail] on [product].[id] = [orderdetail].[productid]\n" +
                    "join [typeproduct] on [product].idtypeproduct = [typeproduct].[id]\n" +
                    "join [category] on [typeproduct].[categoryid] = [category].[id]\n" +
                    "where [category].[id] = 1\n" +
                    "order by [product].[dateupdate] desc";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                List<images> listlink = getLinkImgByIdPro(rs.getInt("id"));
                product p = new product(rs.getInt("id"), rs.getString("name"), rs.getString("describe"), rs.getInt("price"), rs.getDate("dateupdate"), rs.getString("status"), rs.getString("source"), rs.getString("guarantee"), rs.getString("shell"), rs.getString("glasses"), rs.getString("energy"), rs.getString("waterproof"), rs.getInt("facesize"), rs.getInt("wiresize"), rs.getString("checkgoods"), rs.getString("advise"), rs.getInt("idtypeproduct"), listlink, rs.getInt("dispercent"), rs.getInt("newprice"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
// SẮP XẾP THEO MỘT ĐIỀU KIỆN GÌ ĐÓ
    public List<product> orderByPro(int i, String cd, String order) {
        List<product> list = new ArrayList<>();
        String sql = "select *\n"
                + "from [product]\n"
                + "join [typeproduct] on [product].idtypeproduct = [typeproduct].id\n"
                + "join [category] on [typeproduct].categoryid = [category].id\n"
                + "where [category].id = ?"
                + "order by ? ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, i);
            pre.setString(2, cd);
            pre.setString(3, order);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                product p = new product(rs.getInt("id"), rs.getString("name"), rs.getString("describe"), rs.getInt("price"), rs.getDate("dateupdate"), rs.getString("status"), rs.getString("source"), rs.getString("guarantee"), rs.getString("shell"), rs.getString("glasses"), rs.getString("energy"), rs.getString("waterproof"), rs.getInt("facesize"), rs.getInt("wiresize"), rs.getString("checkgoods"), rs.getString("advise"), rs.getInt("idtypeproduct"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
// LẤY CÁC SẢN PHẨM CÓ CÙNG TYPEPRODUCT  
    public List<product> getAllByType(int type) {
        List<product> list = new ArrayList<>();
        String sql = "select[product].[id],[product].[name],[product].[describe] ,[product].[price],[product].[dateupdate],[product].[status],[product].[source],[product].[guarantee],[product].[shell],[product].[glasses],[product].[energy],[product].[waterproof],[product].[facesize],[product].[wiresize],[product].[checkgoods],[product].[advise],[product].[idtypeproduct],[product].[dispercent],([product].[price] - ([product].[price]*([product].[dispercent]*0.01))) as [newprice],COALESCE(SUM([orderdetail].[quantity]), 0) AS totalsale\n"
                + "from [product]\n"
                + "left join [orderdetail] on [product].[id] = [orderdetail].[productid]\n"
                + "join [typeproduct] on [product].idtypeproduct = [typeproduct].[id]\n"
                + "where [typeproduct].[id] = ?\n"
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
// LẤY CÁC SẢN PHẨM KHÁC CÓ CÙNG TYPEPRODUCT  
    public List<product> getOtherPro(int type) {
        List<product> list = new ArrayList<>();
        String sql = "select top 4 [product].[id],[product].[name],[product].[describe] ,[product].[price],[product].[dateupdate],[product].[status],[product].[source],[product].[guarantee],[product].[shell],[product].[glasses],[product].[energy],[product].[waterproof],[product].[facesize],[product].[wiresize],[product].[checkgoods],[product].[advise],[product].[idtypeproduct],[product].[dispercent],([product].[price] - ([product].[price]*([product].[dispercent]*0.01))) as [newprice],COALESCE(SUM([orderdetail].[quantity]), 0) AS totalsale\n"
                + "from [product]\n"
                + "left join [orderdetail] on [product].[id] = [orderdetail].[productid]\n"
                + "join [typeproduct] on [product].idtypeproduct = [typeproduct].[id]\n"
                + "where [typeproduct].[id] = ?\n"
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
// LẤY NAME CỦA TYPEPRODUCT
    public typeproduct getType(int id){
        String sql ="select *\n" +
                    "from [typeproduct]\n" +
                    "where [typeproduct].[id] = ?";
        try{
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            if (rs.next()){
                typeproduct tp = new typeproduct(rs.getInt("id"), rs.getString("name"),rs.getInt("categoryid"));
                return tp;
            }
        } catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        ProductMaleDAO d = new ProductMaleDAO();
        List<product> r = d.getAllPro();
        for ( int i = 0 ; i < r.size() ; i++){
            System.out.println(r.get(i).getName());
        }
    }
}
