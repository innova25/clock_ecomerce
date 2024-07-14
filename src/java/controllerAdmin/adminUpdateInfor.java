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
import jakarta.servlet.http.HttpSession;
import model.product;

/**
 *
 * @author admin
 */
@WebServlet(name="adminUpdateInfor", urlPatterns={"/adminupdateinfor"})
public class adminUpdateInfor extends HttpServlet {
   
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
            out.println("<title>Servlet adminUpdateInfor</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet adminUpdateInfor at " + request.getContextPath () + "</h1>");
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
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        int idpro_raw = Integer.parseInt(request.getParameter("idpro"));
        ProductDAO d = new ProductDAO();
        product p = d.getProbyId(idpro_raw);
        session.setAttribute("proid", p);
        request.getRequestDispatcher("admin.updateinfor.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String describe = request.getParameter("describe");
        int price = Integer.parseInt(request.getParameter("price"));
        int dispercent = Integer.parseInt(request.getParameter("dispercent"));
        String source = request.getParameter("source");
        String guarantee = request.getParameter("guarantee");
        String shell = request.getParameter("shell");
        String glasses = request.getParameter("glasses");
        String energy = request.getParameter("energy");
        String waterproof = request.getParameter("waterproof");
        String link1 = request.getParameter("link1");
        String link2 = request.getParameter("link2");
        ProductDAO p = new ProductDAO();
        product a = (product) session.getAttribute("proid");
//  out.print(name +" "+ describe +" "+ price +" "+ dispercent +" "+ source +" "+ guarantee +" "+ shell +" "+ glasses +" "+ energy +" "+waterproof+" "+a.getId());
        p.updateById( name, describe, price, dispercent, source, guarantee, shell, glasses, energy, waterproof, a.getId() );
        String url = "adminchitietsanpham?id="+a.getId();
        out.print(url);
        response.sendRedirect(url);
        
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
