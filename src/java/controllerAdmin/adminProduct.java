/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controllerAdmin;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
@WebServlet(name="adminProduct", urlPatterns={"/adminproduct"})
public class adminProduct extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet adminProduct</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet adminProduct at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        ProductDAO p = new ProductDAO();
        //0
        List<model.product> list3 = p.getAllByType(3);//Lấy tất cả sản phẩm vô điều kiện
        int numPs3 = list3.size();
        int numPerPage3 = 8;
        int numpage3 = numPs3/numPerPage3+(numPs3%numPerPage3==0?0:1);
        int start3, end3;
        String tpage3 = request.getParameter("page3");
        int page3;
        try{
            page3 = Integer.parseInt(tpage3);
        } catch (NumberFormatException e){
            page3 = 1;
        }
        start3 = (page3 - 1) * numPerPage3;
        if(page3*numPerPage3> numPs3){
            end3 = numPs3;
        } else {
            end3 = page3 * numPerPage3;
        }
        List<model.product> arr3 = p.getListByPage((ArrayList<model.product>) list3, start3, end3);
        request.setAttribute("data3", arr3);
        request.setAttribute("num3", numpage3);
        //1
        List<model.product> list1 = p.getAllByType(1);//Lấy tất cả sản phẩm vô điều kiện
        int numPs1 = list1.size();
        int numPerPage1 = 8;
        int numpage1 = numPs1/numPerPage1+(numPs1%numPerPage1==0?0:1);
        int start1, end1;
        String tpage1 = request.getParameter("page1");
        int page1;
        try{
            page1 = Integer.parseInt(tpage1);
        } catch (NumberFormatException e){
            page1 = 1;
        }
        start1 = (page1 - 1) * numPerPage1;
        if(page1*numPerPage1> numPs1){
            end1 = numPs1;
        } else {
            end1 = page1 * numPerPage1;
        }
        List<model.product> arr1 = p.getListByPage((ArrayList<model.product>) list1, start1, end1);
        request.setAttribute("data1", arr1);
        request.setAttribute("num1", numpage1);
        //2
        List<model.product> list2 = p.getAllByType(2);//Lấy tất cả sản phẩm vô điều kiện
        int numPs2 = list2.size();
        int numPerPage2 = 8;
        int numpage2 = numPs2/numPerPage2+(numPs2%numPerPage2==0?0:1);
        int start2, end2;
        String tpage2 = request.getParameter("page2");
        int page2;
        try{
            page2 = Integer.parseInt(tpage2);
        } catch (NumberFormatException e){
            page2 = 1;
        }
        start2 = (page2 - 1) * numPerPage2;
        if(page2*numPerPage2> numPs2){
            end2 = numPs2;
        } else {
            end2 = page2 * numPerPage2;
        }
        List<model.product> arr2 = p.getListByPage((ArrayList<model.product>) list2, start2, end2);
        request.setAttribute("data2", arr2);
        request.setAttribute("num2", numpage2);
        //4
        List<model.product> list4 = p.getAllByType(4);//Lấy tất cả sản phẩm vô điều kiện
        int numPs4 = list4.size();
        int numPerPage4 = 8;
        int numpage4 = numPs4/numPerPage4+(numPs4%numPerPage4==0?0:1);
        int start4, end4;
        String tpage4 = request.getParameter("page4");
        int page4;
        try{
            page4 = Integer.parseInt(tpage4);
        } catch (NumberFormatException e){
            page4 = 1;
        }
        start4 = (page4 - 1) * numPerPage4;
        if(page4*numPerPage4> numPs4){
            end4 = numPs4;
        } else {
            end4 = page4 * numPerPage4;
        }
        List<model.product> arr4 = p.getListByPage((ArrayList<model.product>) list4, start4, end4);
        request.setAttribute("data4", arr4);
        request.setAttribute("num4", numpage4);
        //5
        List<model.product> list5 = p.getAllByType(5);//Lấy tất cả sản phẩm vô điều kiện
        int numPs5 = list5.size();
        int numPerPage5 = 8;
        int numpage5 = numPs5/numPerPage5+(numPs5%numPerPage5==0?0:1);
        int start5, end5;
        String tpage5 = request.getParameter("page5");
        int page5;
        try{
            page5 = Integer.parseInt(tpage5);
        } catch (NumberFormatException e){
            page5 = 1;
        }
        start5 = (page5 - 1) * numPerPage5;
        if(page5*numPerPage5> numPs5){
            end5 = numPs5;
        } else {
            end5 = page5 * numPerPage5;
        }
        List<model.product> arr5 = p.getListByPage((ArrayList<model.product>) list5, start5, end5);
        request.setAttribute("data5", arr5);
        request.setAttribute("num5", numpage5);
        //6
        List<model.product> list6 = p.getAllByType(6);//Lấy tất cả sản phẩm vô điều kiện
        int numPs6 = list6.size();
        int numPerPage6 = 8;
        int numpage6 = numPs6/numPerPage6+(numPs6%numPerPage6==0?0:1);
        int start6, end6;
        String tpage6 = request.getParameter("page6");
        int page6;
        try{
            page6 = Integer.parseInt(tpage6);
        } catch (NumberFormatException e){
            page6 = 1;
        }
        start6 = (page6 - 1) * numPerPage6;
        if(page6*numPerPage6> numPs6){
            end6 = numPs6;
        } else {
            end6 = page6 * numPerPage6;
        }
        List<model.product> arr6 = p.getListByPage((ArrayList<model.product>) list6, start6, end6);
        request.setAttribute("data6", arr6);
        request.setAttribute("num6", numpage6);
        //0
        List<model.product> list7 = p.getAllByType(7);//Lấy tất cả sản phẩm vô điều kiện
        int numPs7 = list7.size();
        int numPerPage7 = 8;
        int numpage7 = numPs7/numPerPage7+(numPs7%numPerPage7==0?0:1);
        int start7, end7;
        String tpage7 = request.getParameter("page7");
        int page7;
        try{
            page7 = Integer.parseInt(tpage7);
        } catch (NumberFormatException e){
            page7 = 1;
        }
        start7 = (page7 - 1) * numPerPage7;
        if(page7*numPerPage7> numPs7){
            end7 = numPs7;
        } else {
            end7 = page7 * numPerPage7;
        }
        List<model.product> arr7 = p.getListByPage((ArrayList<model.product>) list7, start7, end7);
        request.setAttribute("data7", arr7);
        request.setAttribute("num7", numpage7);
        //8
        List<model.product> list8 = p.getAllByType(8);//Lấy tất cả sản phẩm vô điều kiện
        int numPs8 = list8.size();
        int numPerPage8 = 8;
        int numpage8 = numPs8/numPerPage8+(numPs8%numPerPage8==0?0:1);
        int start8, end8;
        String tpage8 = request.getParameter("page8");
        int page8;
        try{
            page8 = Integer.parseInt(tpage8);
        } catch (NumberFormatException e){
            page8 = 1;
        }
        start8 = (page8 - 1) * numPerPage8;
        if(page8*numPerPage8> numPs8){
            end8 = numPs8;
        } else {
            end8 = page8 * numPerPage8;
        }
        List<model.product> arr8 = p.getListByPage((ArrayList<model.product>) list8, start8, end8);
        request.setAttribute("data8", arr8);
        request.setAttribute("num8", numpage8);
        //9
        List<model.product> list9 = p.getAllByType(9);//Lấy tất cả sản phẩm vô điều kiện
        int numPs9 = list9.size();
        int numPerPage9 = 8;
        int numpage9 = numPs9/numPerPage9+(numPs9%numPerPage9==0?0:1);
        int start9, end9;
        String tpage9 = request.getParameter("page9");
        int page9;
        try{
            page9 = Integer.parseInt(tpage9);
        } catch (NumberFormatException e){
            page9 = 1;
        }
        start9 = (page9 - 1) * numPerPage9;
        if(page9*numPerPage9> numPs9){
            end9 = numPs9;
        } else {
            end9 = page9 * numPerPage9;
        }
        List<model.product> arr9 = p.getListByPage((ArrayList<model.product>) list9, start9, end9);
        request.setAttribute("data9", arr9);
        request.setAttribute("num9", numpage9);
        request.getRequestDispatcher("admin.product.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
