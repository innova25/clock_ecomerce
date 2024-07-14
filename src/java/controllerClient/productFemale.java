/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controllerClient;


import dal.ProductFemaleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.typeproduct;

/**
 *
 * @author admin
 */
@WebServlet(name="productFemale", urlPatterns={"/productfemale"})
public class productFemale extends HttpServlet {
   
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
            out.println("<title>Servlet productFemale</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet productFemale at " + request.getContextPath () + "</h1>");
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
        PrintWriter out = response.getWriter();
        ProductFemaleDAO p = new ProductFemaleDAO();
        //0
        List<model.product> list = p.getAllPro();//Lấy tất cả sản phẩm vô điều kiện
        int numPs = list.size();
        int numPerPage = 8;
        int numpage = numPs/numPerPage+(numPs%numPerPage==0?0:1);
        int start, end;
        String tpage = request.getParameter("page");
        int page;
        try{
            page = Integer.parseInt(tpage);
        } catch (NumberFormatException e){
            page = 1;
        }
        start = (page - 1) * numPerPage;
        if(page*numPerPage> numPs){
            end = numPs;
        } else {
            end = page * numPerPage;
        }
        List<model.product> arr = p.getListByPage((ArrayList<model.product>) list, start, end);
        request.setAttribute("data", arr);
        request.setAttribute("num", numpage);
        //1
        List<model.product> list1 = p.getAllProBySale();//Lấy tất cả sản phẩm vô điều kiện
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
        List<model.product> list2 = p.getNewPro();//Lấy tất cả sản phẩm vô điều kiện
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
        request.getRequestDispatcher("client.indexfemale.jsp").forward(request, response);
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
