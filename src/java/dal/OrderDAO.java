/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.order;

/**
 *
 * @author admin
 */
public class OrderDAO extends DBContext {

    public int createReturnId(order order) {
        try {
            String sql = "insert into [order]([accountid],[address],[orderdate],[orderdelivery],[total])\n"
                    + "values ( ? , ? , ? , ? , ?);";
            PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, order.getAccount());
            stm.setString(2, order.getAddress());
            stm.setDate(3, (Date) order.getOrderdate());
            stm.setDate(4, (Date) order.getOrderdelivery());
            stm.setInt(5, order.getTotal());
            stm.executeUpdate();
            ResultSet rs = stm.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public List<order> getAllOrder() {
        List<order> Orders = new ArrayList<>();
        try {
            String sql = "select * from [order]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                order order = new order();
                order.setTotal( rs.getInt("total"));
                order.setAddress(rs.getString("address"));
                order.setOrderdate(rs.getDate("orderdate"));
                order.setOrderdelivery(rs.getDate("orderdelivery"));
                order.setAccount(rs.getInt("accountid"));
                Orders.add(order);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return Orders;
    }
}
