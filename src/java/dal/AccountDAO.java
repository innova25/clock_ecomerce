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
import model.account;

/**
 *
 * @author admin
 */
public class AccountDAO extends DBContext {

    public List<account> getAllClient() {
        List<account> list = new ArrayList<>();
        String sql = "select * from [account] where [role] = 'client'";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                account a = new account(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("realname"), rs.getString("phone"), rs.getString("email"), rs.getString("address"), rs.getString("avatar"), rs.getString("role"));
                list.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public account checkLogin(String user, String pass) {
        String sql = "select * from [account] where [username] = ? and [password] = ? and [role] = 'client'";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, user);
            pre.setString(2, pass);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                account a = new account(rs.getString("username"), rs.getString("password"), rs.getString("role"));
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public account checkLoginAdmin(String user, String pass) {
        String sql = "select * from [account] where [username] = ? and [password] = ? and [role] = 'admin'";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, user);
            pre.setString(2, pass);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                account a = new account(rs.getString("username"), rs.getString("password"), rs.getString("role"));
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean checkUserClient(String user) {
        List<String> listUser = new ArrayList<>();
        boolean flag = false;
        String sql = "select [username] from [account] where [role] = 'client' ";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                String s = rs.getString("username");
                listUser.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        for (String u : listUser) {
            if (u.equalsIgnoreCase(user)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkUserAdmin(String user) {
        List<String> listUser = new ArrayList<>();
        boolean flag = false;
        String sql = "select [username] from [account] where [role] = 'admin' ";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                String s = rs.getString("username");
                listUser.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        for (String u : listUser) {
            if (u.equalsIgnoreCase(user)) {
                return false;
            }
        }
        return true;
    }

    public String addClient(String user, String pass, String name, String phone, String email, String address) {
        String sql = "insert into [account]([username],[password],[realname],[phone],[email],[address],[avatar],[role])\n"
                + "values ( ? , ? , ? , ? , ? , ? ,N'u1.jpg',N'client')";
        try {
            if (checkUserClient(user)) {
                PreparedStatement pre = connection.prepareStatement(sql);
                pre.setString(1, user);
                pre.setString(2, pass);
                pre.setString(3, name);
                pre.setString(4, phone);
                pre.setString(5, email);
                pre.setString(6, address);
                int noadd = pre.executeUpdate();
                if (noadd > 0) {
                    return "Create Successfully !";
                }
            } else {
                return "Username available !";
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return "Create failed !";
    }

    public String addAdmin(String user, String pass, String name, String phone, String email, String address) {
        String sql = "insert into [account]([username],[password],[realname],[phone],[email],[address],[avatar],[role])\n"
                + "values ( ? , ? , ? , ? , ? , ? ,N'u2.jpg',N'admin')";
        try {
            if (checkUserAdmin(user)) {
                PreparedStatement pre = connection.prepareStatement(sql);
                pre.setString(1, user);
                pre.setString(2, pass);
                pre.setString(3, name);
                pre.setString(4, phone);
                pre.setString(5, email);
                pre.setString(6, address);
                int noadd = pre.executeUpdate();
                if (noadd > 0) {
                    return "Create Successfully !";
                }
            } else {
                return "Username available !";
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return "Create failed !";
    }

    public account findByUsername(String user) {
        List<account> list = getAllClient();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equalsIgnoreCase(user)) {
                return list.get(i);
            }
        }
        return null;
    }

    public String updateInfo(String user, String pass, String name, String phone, String email, String address) {
        account a = findByUsername(user);
        String user_raw = a.getUsername();
        String sql = "update [account] set [password] = ?,[realname] = ? , [phone] = ? , [email] = ? , [address] =  ? where [username] = ? ";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, pass);
            pre.setString(2, name);
            pre.setString(3, phone);
            pre.setString(4, email);
            pre.setString(5, address);
            pre.setString(6, user_raw);
            int rs = pre.executeUpdate();
            if (rs > 0) {
                return "Update successfully !";
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public String deleteUserById(int id) {
        String sql = "delete from [account] where [account].[id] = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            return "Done!";
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
