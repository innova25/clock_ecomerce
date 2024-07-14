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
import model.review;

/**
 *
 * @author admin
 */
public class ReviewDAO extends DBContext{
    public void addReview(int id) {
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
    }
}
