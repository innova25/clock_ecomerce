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
import model.order;

/**
 *
 * @author admin
 */
public class CartDAO extends DBContext{
    public List<order> getAllOrder(int idacc){
        List<order> list = new ArrayList<>();
        String sql ="select a.[id],a.[total],a.[address],a.[orderdate],a.[orderdelivery],a.[accountid],a.[staffid], b.[quantity], c.[name]\n" +
                    "from [order] as a\n" +
                    "join [orderdetail] as b on a.[id] = b.[orderid]\n" +
                    "join [product] as c on b.[productid] = c.[id]\n" +
                    "where a.accountid = ?";
        try{
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, idacc);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                order o = new order(rs.getInt("id"), rs.getInt("total"), rs.getString("name"), rs.getInt("quantity"));
                list.add(o);
            }
        } catch (SQLException e){
            System.out.println(e);
        }
        return list;
    } 
}
