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
import model.statistic;

/**
 *
 * @author admin
 */
public class StatisticalDAO extends DBContext {

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

    public List<product> statisticByMonth(int month) {
        List<product> list = new ArrayList<>();
        String sql = "select [product].[id],[product].[name],[product].[describe] ,[product].[price],[product].[dateupdate],[product].[status],[product].[source],[product].[guarantee],[product].[shell],[product].[glasses],[product].[energy],[product].[waterproof],[product].[facesize],[product].[wiresize],[product].[checkgoods],[product].[advise],[product].[idtypeproduct],[product].[dispercent],([product].[price] - ([product].[price]*([product].[dispercent]*0.01))) as [newprice],COALESCE(SUM([orderdetail].[quantity]), 0) AS totalsale\n"
                + "from [product]\n"
                + "left join [orderdetail] on [product].[id] = [orderdetail].[productid]\n"
                + "join [order] on [order].[id] = [orderdetail].[orderid]\n"
                + "join [typeproduct] on [product].idtypeproduct = [typeproduct].[id]\n"
                + "where Month([order].[orderdate]) = ?\n"
                + "group by [product].[id],[product].[name],[product].[describe] ,[product].[price],[product].[dateupdate],[product].[status],[product].[source],[product].[guarantee],[product].[shell],[product].[glasses],[product].[energy],[product].[waterproof],[product].[facesize],[product].[wiresize],[product].[checkgoods],[product].[advise],[product].[idtypeproduct],[product].[dispercent]";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, month);
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
// Tong so san pham ban duoc theo tung thang

    public List<statistic> monthTotal() {
        String sql = "WITH AllMonths AS (\n"
                + "    SELECT 1 AS MonthNumber\n"
                + "    UNION SELECT 2\n"
                + "    UNION SELECT 3\n"
                + "    UNION SELECT 4\n"
                + "    UNION SELECT 5\n"
                + "    UNION SELECT 6\n"
                + "    UNION SELECT 7\n"
                + "    UNION SELECT 8\n"
                + "    UNION SELECT 9\n"
                + "    UNION SELECT 10\n"
                + "    UNION SELECT 11\n"
                + "    UNION SELECT 12\n"
                + ")\n"
                + "\n"
                + "SELECT AllMonths.MonthNumber, COALESCE(SUM(Quantity), 0) AS TotalSold\n"
                + "FROM AllMonths\n"
                + "LEFT JOIN (\n"
                + "    SELECT MONTH(O.orderdate) AS MonthNumber, SUM(OD.quantity) AS Quantity\n"
                + "    FROM [order] O\n"
                + "    INNER JOIN orderdetail OD ON O.id = OD.orderid\n"
                + "    GROUP BY MONTH(O.orderdate)\n"
                + ") AS MonthlyData ON AllMonths.MonthNumber = MonthlyData.MonthNumber\n"
                + "GROUP BY AllMonths.MonthNumber\n"
                + "ORDER BY AllMonths.MonthNumber;";
        List<statistic> list = new ArrayList<>();
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                statistic s = new statistic(rs.getInt("MonthNumber"), rs.getInt("TotalSold"));
                list.add(s);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<statistic> dayTotal() {
        String sql = "WITH Last7Days AS (\n"
                + "    SELECT TOP 7 DATEADD(DAY, -number, GETDATE()) AS Day\n"
                + "    FROM master.dbo.spt_values\n"
                + "    WHERE type = 'P' AND number >= 0 AND number < 7\n"
                + ")\n"
                + "SELECT\n"
                + "    CAST(Last7Days.Day AS DATE) AS Day,\n"
                + "    ISNULL(SUM(o.total), 0) AS TotalSales\n"
                + "FROM Last7Days\n"
                + "LEFT JOIN [order] o ON CAST(o.orderdate AS DATE) = CAST(Last7Days.Day AS DATE)\n"
                + "GROUP BY CAST(Last7Days.Day AS DATE)\n"
                + "ORDER BY CAST(Last7Days.Day AS DATE)";
        List<statistic> list = new ArrayList<>();
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                statistic s = new statistic(rs.getInt("Day"), rs.getInt("TotalSales"));
                list.add(s);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Integer> moneyByMonth() {
        String sql = "WITH AllMonths AS (\n"
                + "    SELECT '2023-01' AS MonthYear\n"
                + "    UNION SELECT '2023-02'\n"
                + "    UNION SELECT '2023-03'\n"
                + "    UNION SELECT '2023-04'\n"
                + "    UNION SELECT '2023-05'\n"
                + "    UNION SELECT '2023-06'\n"
                + "    UNION SELECT '2023-07'\n"
                + "    UNION SELECT '2023-08'\n"
                + "    UNION SELECT '2023-09'\n"
                + "    UNION SELECT '2023-10'\n"
                + "    UNION SELECT '2023-11'\n"
                + "    UNION SELECT '2023-12'\n"
                + ")\n"
                + "\n"
                + "SELECT\n"
                + "    ISNULL(SUM(o.total), 0) AS TotalSales\n"
                + "FROM AllMonths am\n"
                + "LEFT JOIN [order] o ON am.MonthYear = CONVERT(VARCHAR(7), o.orderdate, 120)\n"
                + "GROUP BY am.MonthYear\n"
                + "ORDER BY am.MonthYear";
        List<Integer> list = new ArrayList<>();
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt("TotalSales"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Integer> moneyByDay() {
        String sql = "-- Truy vấn để lấy tổng số tiền bán được của 7 ngày gần nhất\n"
                + "WITH Last7Days AS (\n"
                + "    SELECT DATEADD(DAY, -rn, GETDATE()) AS Day\n"
                + "    FROM (\n"
                + "        SELECT ROW_NUMBER() OVER (ORDER BY GETDATE()) AS rn\n"
                + "        FROM master.dbo.spt_values\n"
                + "        WHERE type = 'P'\n"
                + "    ) AS RowNumber\n"
                + "    WHERE rn <= 7\n"
                + ")\n"
                + "SELECT\n"
                + "    CAST(Last7Days.Day AS DATE) AS Day,\n"
                + "    ISNULL(SUM(o.total), 0) AS TotalSales\n"
                + "FROM Last7Days\n"
                + "LEFT JOIN [order] o ON CAST(o.orderdate AS DATE) = CAST(Last7Days.Day AS DATE)\n"
                + "GROUP BY CAST(Last7Days.Day AS DATE)\n"
                + "ORDER BY CAST(Last7Days.Day AS DATE)";
        List<Integer> list = new ArrayList<>();
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt("TotalSales"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public int totalSaler() {
        int total = 0;
        String sql = "SELECT SUM(total) AS TotalRevenue\n"
                + "FROM [order]";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                total = rs.getInt("TotalRevenue");
            }
            return total;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return total;
    }

    public static void main(String[] args) {
        StatisticalDAO st = new StatisticalDAO();
        List<Integer> l = st.moneyByMonth();
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
        System.out.println(st.totalSaler());
    }
}
