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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cart;
import model.orderdetail;

/**
 *
 * @author admin
 */
public class OrderDetailDAO extends DBContext {

    public void saveCart(int orderId, Map<Integer, Cart> carts) {
        try {

            String sql = "insert into [orderdetail] ([orderid],[price],[productid],[quantity],[total])\n"
                    + "values ( ? , ? , ? , ? , ?);";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, orderId);
            for (Map.Entry<Integer, Cart> entry : carts.entrySet()) {
                Integer productId = entry.getKey();
                Cart cart = entry.getValue();
                stm.setInt(2, cart.getProduct().getNewprice());
                stm.setInt(3, productId);
                stm.setInt(4, cart.getQuantity());
                stm.setInt(5, cart.getQuantity() * cart.getProduct().getNewprice());
                stm.executeUpdate();
            }

        } catch (Exception ex) {
            System.out.println(ex);;
        }
    }

    public List<orderdetail> getAllOrderDetailById(int id) {
        List<orderdetail> OrderDetails = new ArrayList<>();
        try {
            String sql = "SELECT * FROM orderdetail Where orderid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                orderdetail order = new orderdetail();
                order.setId(rs.getInt("id"));
                order.setQuantity(rs.getInt("quantity"));
                order.setPrice(rs.getInt("price"));
                order.setTotal(rs.getInt("total"));
                order.setNote(rs.getString("note"));
                order.setOrderid(rs.getInt("orderid"));
                order.setProductid(rs.getInt("productid"));
                OrderDetails.add(order);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return OrderDetails;
    }

    public void delete(int id) {

        try {

            String sql = "DELETE FROM [orderdetail]\n"
                    + "      WHERE id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
