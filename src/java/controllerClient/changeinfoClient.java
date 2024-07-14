/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controllerClient;

import com.oracle.wls.shaded.org.apache.xpath.operations.Quo;
import dal.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.account;

/**
 *
 * @author admin
 */
@WebServlet(name="changeinfoClient", urlPatterns={"/changeinfoclient"})
public class changeinfoClient extends HttpServlet {
   
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
            out.println("<title>Servlet changeinfoClient</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet changeinfoClient at " + request.getContextPath () + "</h1>");
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
        account a = (account) session.getAttribute("account");
        if ( a == null ){
            request.getRequestDispatcher("view/user/login.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("view/user/changeinfo.jsp").forward(request, response);
        }
        
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
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String pass = request.getParameter("uppass");
        String name = request.getParameter("upname");
        String phone = request.getParameter("upphone");
        String email = request.getParameter("upemail");
        String address = request.getParameter("upadd");
        account a = (account)session.getAttribute("disacc");// Chưa lấy được account;
        if ( pass.isEmpty() || pass == null){
            pass = a.getPassword();
        }
        if ( name.isEmpty() || name == null){
            name = a.getRealname();
        }
        if ( phone.isEmpty() || phone == null){
            phone = a.getPhone();
        }
        if ( email.isEmpty() || email == null){
            email = a.getEmail();
        }
        if ( address.isEmpty() || address == null){
            address = a.getAddress();
        }
        AccountDAO ad = new AccountDAO();
        if (ad.updateInfo(a.getUsername(), pass, name, phone, email, address) != null){
            account b = new account(a.getId(), a.getUsername(), pass, name , phone, email, address, a.getAvatar(), a.getRole() );
            session.setAttribute("disacc", b);
            request.getRequestDispatcher("client.thongtintaikhoan.jsp").forward(request, response);
        } else {
            session.setAttribute("mes", "Update Failed !");
            request.getRequestDispatcher("view/user/changeinfo.jsp").forward(request, response);
        }
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
