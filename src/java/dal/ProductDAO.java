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
public class ProductDAO extends DBContext {

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
        String sql = "select[product].[id],[product].[name],[product].[describe] ,[product].[price],[product].[dateupdate],[product].[status],[product].[source],[product].[guarantee],[product].[shell],[product].[glasses],[product].[energy],[product].[waterproof],[product].[facesize],[product].[wiresize],[product].[checkgoods],[product].[advise],[product].[idtypeproduct],[product].[dispercent],([product].[price] - ([product].[price]*([product].[dispercent]*0.01))) as [newprice],COALESCE(SUM([orderdetail].[quantity]), 0) AS totalsale\n"
                + "from [product]\n"
                + "left join [orderdetail] on [product].[id] = [orderdetail].[productid]\n"
                + "join [typeproduct] on [product].idtypeproduct = [typeproduct].[id]\n"
                + "group by [product].[id],[product].[name],[product].[describe] ,[product].[price],[product].[dateupdate],[product].[status],[product].[source],[product].[guarantee],[product].[shell],[product].[glasses],[product].[energy],[product].[waterproof],[product].[facesize],[product].[wiresize],[product].[checkgoods],[product].[advise],[product].[idtypeproduct],[product].[dispercent]\n";
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

    public List<product> getProByPrice() {
        List<product> list = new ArrayList<>();
        String sql = "select[product].[id],[product].[name],[product].[describe] ,[product].[price],[product].[dateupdate],[product].[status],[product].[source],[product].[guarantee],[product].[shell],[product].[glasses],[product].[energy],[product].[waterproof],[product].[facesize],[product].[wiresize],[product].[checkgoods],[product].[advise],[product].[idtypeproduct],[product].[dispercent],([product].[price] - ([product].[price]*([product].[dispercent]*0.01))) as [newprice],COALESCE(SUM([orderdetail].[quantity]), 0) AS totalsale\n"
                + "from [product]\n"
                + "left join [orderdetail] on [product].[id] = [orderdetail].[productid]\n"
                + "join [typeproduct] on [product].idtypeproduct = [typeproduct].[id]\n"
                + "group by [product].[id],[product].[name],[product].[describe] ,[product].[price],[product].[dateupdate],[product].[status],[product].[source],[product].[guarantee],[product].[shell],[product].[glasses],[product].[energy],[product].[waterproof],[product].[facesize],[product].[wiresize],[product].[checkgoods],[product].[advise],[product].[idtypeproduct],[product].[dispercent]\n"
                + "order by [product].[price] desc";
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
        String sql = "select top 24 [product].[id],[product].[name],[product].[describe] ,[product].[price],[product].[dateupdate],[product].[status],[product].[source],[product].[guarantee],[product].[shell],[product].[glasses],[product].[energy],[product].[waterproof],[product].[facesize],[product].[wiresize],[product].[checkgoods],[product].[advise],[product].[idtypeproduct],[product].[dispercent],([product].[price] - ([product].[price]*([product].[dispercent]*0.01))) as [newprice],COALESCE(SUM([orderdetail].[quantity]), 0) AS totalsale\n"
                + "from [product]\n"
                + "left join [orderdetail] on [product].[id] = [orderdetail].[productid]\n"
                + "join [typeproduct] on [product].idtypeproduct = [typeproduct].[id]\n"
                + "group by [product].[id],[product].[name],[product].[describe] ,[product].[price],[product].[dateupdate],[product].[status],[product].[source],[product].[guarantee],[product].[shell],[product].[glasses],[product].[energy],[product].[waterproof],[product].[facesize],[product].[wiresize],[product].[checkgoods],[product].[advise],[product].[idtypeproduct],[product].[dispercent]\n"
                + "order by [totalsale] desc";
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
        String sql = "select top 16 [product].[id],[product].[name],[product].[describe] ,[product].[price],[product].[dateupdate],[product].[status],[product].[source],[product].[guarantee],[product].[shell],[product].[glasses],[product].[energy],[product].[waterproof],[product].[facesize],[product].[wiresize],[product].[checkgoods],[product].[advise],[product].[idtypeproduct],[product].[dispercent],([product].[price] - ([product].[price]*([product].[dispercent]*0.01))) as [newprice]\n"
                + "from [product]\n"
                + "left join [orderdetail] on [product].[id] = [orderdetail].[productid]\n"
                + "join [typeproduct] on [product].idtypeproduct = [typeproduct].[id]\n"
                + "order by [product].[dateupdate] desc";
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

    public List<product> search(String txt) {
        List<product> list = new ArrayList<>();
        String sql = "select[product].[id],[product].[name],[product].[describe] ,[product].[price],[product].[dateupdate],[product].[status],[product].[source],[product].[guarantee],[product].[shell],[product].[glasses],[product].[energy],[product].[waterproof],[product].[facesize],[product].[wiresize],[product].[checkgoods],[product].[advise],[product].[idtypeproduct],[product].[dispercent],([product].[price] - ([product].[price]*([product].[dispercent]*0.01))) as [newprice],COALESCE(SUM([orderdetail].[quantity]), 0) AS totalsale\n"
                + "from [product]\n"
                + "left join [orderdetail] on [product].[id] = [orderdetail].[productid]\n"
                + "join [typeproduct] on [product].idtypeproduct = [typeproduct].[id]\n"
                + "where [product].[name] like ? or [product].[describe] like ? or [product].[price] like ? or [product].[dateupdate] like ? or [product].[status] like ? or [product].[source] like ? or [product].[guarantee] like ? or [product].[shell] like ? or [product].[glasses] like ? or [product].[energy] like ? or [product].[waterproof] like ? or [product].[facesize] like ? or [product].[wiresize] like ? or [product].[checkgoods] like ? or [product].[advise] like ? or [product].[idtypeproduct] like ? or [product].[dispercent]  like ? \n"
                + "group by [product].[id],[product].[name],[product].[describe] ,[product].[price],[product].[dateupdate],[product].[status],[product].[source],[product].[guarantee],[product].[shell],[product].[glasses],[product].[energy],[product].[waterproof],[product].[facesize],[product].[wiresize],[product].[checkgoods],[product].[advise],[product].[idtypeproduct],[product].[dispercent]\n";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, "%" + txt + "%");
            pre.setString(2, "%" + txt + "%");
            pre.setString(3, "%" + txt + "%");
            pre.setString(4, "%" + txt + "%");
            pre.setString(5, "%" + txt + "%");
            pre.setString(6, "%" + txt + "%");
            pre.setString(7, "%" + txt + "%");
            pre.setString(8, "%" + txt + "%");
            pre.setString(9, "%" + txt + "%");
            pre.setString(10, "%" + txt + "%");
            pre.setString(11, "%" + txt + "%");
            pre.setString(12, "%" + txt + "%");
            pre.setString(13, "%" + txt + "%");
            pre.setString(14, "%" + txt + "%");
            pre.setString(15, "%" + txt + "%");
            pre.setString(16, "%" + txt + "%");
            pre.setString(17, "%" + txt + "%");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                List<images> listlink = getLinkImgByIdPro(rs.getInt("id"));
                List<review> listreview = getReviewByIdPro(rs.getInt("id"));
                product p = new product(rs.getInt("id"), rs.getString("name"), rs.getString("describe"), rs.getInt("price"), rs.getDate("dateupdate"), rs.getString("status"), rs.getString("source"), rs.getString("guarantee"), rs.getString("shell"), rs.getString("glasses"), rs.getString("energy"), rs.getString("waterproof"), rs.getInt("facesize"), rs.getInt("wiresize"), rs.getString("checkgoods"), rs.getString("advise"), rs.getInt("idtypeproduct"), rs.getInt("totalsale"), listlink, listreview, rs.getInt("dispercent"), rs.getInt("newprice"));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void addImg(int idpro, String link1, String link2) {
        String sql = "insert into [images]([productid],[link])\n"
                + "values ( ? , ?),\n"
                + "	    ( ? , ?);";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, idpro);
            pre.setString(2, link1);
            pre.setInt(3, idpro);
            pre.setString(4, link2);
            ResultSet rs = pre.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public product findProByName(String name) {
        product p = new product();
        String sql = "select * from [product] where [name] = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, name);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                p = new product(rs.getInt("id"), rs.getString("name"));
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM images WHERE productid IN (SELECT id FROM product WHERE id = ?); DELETE FROM product WHERE id = ?;";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            pre.setInt(2, id);

            // Thực hiện câu lệnh SQL sử dụng executeUpdate
            int rowsAffected = pre.executeUpdate();

            // Kiểm tra xem có bao nhiêu dòng đã bị ảnh hưởng (đã xóa)
            if (rowsAffected > 0) {
                System.out.println("Xóa thành công!");
            } else {
                System.out.println("Không có sản phẩm nào được xóa!");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
}

public void updateById(String name, String describe, int price, int dispercent, String source, String guarantee, String shell, String glasses, String energy, String waterproof, int id) {
        String sql = "update [product] set [name] = ?, [describe] = ?, [price] = ?, [dispercent] = ?, [dateupdate] = GETDATE(), [source] = ?, [guarantee] = ?, [shell] = ?, [glasses] = ?, [energy] = ?, [waterproof] = ?, [link]\n"
                + "where [product].[id] = ?;";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, name);
            pre.setString(2, describe);
            pre.setInt(3, price);
            pre.setInt(4, dispercent);
            pre.setString(5, source);
            pre.setString(6, guarantee + "Tháng");
            pre.setString(7, shell);
            pre.setString(8, glasses);
            pre.setString(9, energy);
            pre.setString(10, waterproof);
            pre.setInt(11, id);
            int rs = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void addProduct(int typepro, String name, String describe, int price, int dispercent, String source, String guarantee, String shell, String glasses, String energy, String waterproof, String link1, String link2) {
        String sql = "insert into [product]([idtypeproduct],[name],[describe],[price],[dateupdate],[dispercent],[source],[guarantee],[shell],[glasses],[energy],[waterproof],[facesize],[wiresize],[checkgoods],[advise])\n"
                + "values ( ? , ? , ? , ? , GETDATE(), ? , ? , ? , ? , ? , ? , ?, 40, 20 , N'Check khi nhận hàng', N'0978.828.888');";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, typepro);
            pre.setString(2, name);
            pre.setString(3, describe);
            pre.setInt(4, price);
            pre.setInt(5, dispercent);
            pre.setString(6, source);
            pre.setString(7, guarantee + "Tháng");
            pre.setString(8, shell);
            pre.setString(9, glasses);
            pre.setString(10, energy);
            pre.setString(11, waterproof);
            int rs = pre.executeUpdate();
            product p = findProByName(name);
            addImg(p.getId(), link1, link2);
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
    }
}
