package login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author leila
 */
@WebServlet(urlPatterns = {"/validationLoginAdmin"})
public class validationLoginAdmin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    final String url = "jdbc:mysql://localhost:3306/egyptair";
    final String user = "root"; //write your username
    final String password = "M@hammed512"; // write your password
    
    String userName;
    Connection Con = null;
    Statement Stmt = null;
    ResultSet RS = null;
    String pass = null; 
           
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
     
        // here we will make sure the input 
        String name, password;
        name = request.getParameter("nameAdmin");
        password = request.getParameter("passwordAdmin");
        HttpSession session = request.getSession(true);

        
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             //TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet vaildate</title>");            
            out.println("</head>");
            out.println("<body>");
            
          
            
            String dbPass = check(name);
            out.println(name + " " +dbPass + " " + password + " " + pass + " "+ userName);
            if(password.equals(dbPass)){
                
                out.print("<h2> Hello "+ userName + " </h2>");
                
                session.setAttribute("name", name);
                session.setAttribute("password", password);
               response.sendRedirect("adminHome.jsp");
            } else {
                out.print("User name or Password is wrong");
               
            }
           out.println("</body>");
           out.println("</html>");
        }
      
      
     
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(validationLoginAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(validationLoginAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    

    public String check(String name) throws SQLException{
          
        String pas = null;
         try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
            try {
                Con = DriverManager.getConnection(url, user, password);
                Stmt = Con.createStatement();
                    RS = Stmt.executeQuery("SELECT password FROM egyptair.admin where name= '" + name +"';");
                
               
            if(RS.next()){
               pas =RS.getString("password");
               //userName =RS.getString("name");
               
             }
            Stmt.close();
            RS.close();
            Con.close();
            } catch (Exception cnfe) {
                System.err.println("Exception: " + cnfe);
            }
            if(pas ==null)
                 return "hey" +name;
            return pas;
    }
    

}
