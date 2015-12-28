

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import aircrafts.addAirCarftDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leila
 */
@WebServlet(urlPatterns = {"/addNewUser"})
public class addNewUser extends HttpServlet {

    final String url = "jdbc:mysql://localhost:3306/egyptair";
    final String user = "root"; //write your username
    final String password = "123456"; // write your password
    
    String name , pass , email , credit , phone ;
    
    Connection Con = null;
    Statement Stmt = null;
    ResultSet RS = null;
           
    /**
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        name    = request.getParameter("name");
        pass = request.getParameter("password");
        email  = request.getParameter("email");
        credit = request.getParameter("creditCard");
        phone = request.getParameter("phone");
        
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>add new user</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1> Egypt Air </h1>");
            int rawNum;
            
            String dbEmail = check(email);
             
            if(!email.equals(dbEmail)){
                
                
 
            //    out.println("before");
               rawNum= insert();
              ///  out.print("after");
               if(rawNum >0 ){
                   
                out.print("successfully adding user");
               } else {
                   
                out.print("error");
               }
            } else {
                out.print("the user is already exist");
            }
           out.println("</body>");
           out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(addAirCarftDB.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
  

    public String check(String email) throws SQLException{
      
        String dbEmail="";
         try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
            try {
                Con = DriverManager.getConnection(url, user, password);
                Stmt = Con.createStatement();
                RS = Stmt.executeQuery("SELECT * FROM egyptair.user where email = '" + email +"';");
                
            if(RS.next()){
               dbEmail =RS.getString("email");
             }
            Stmt.close();
            RS.close();
            Con.close();
            } catch (Exception cnfe) {
                System.err.println("Exception: " + cnfe);
            }
            return dbEmail;
    }
   
    public int insert() throws SQLException{
        int N = -5;
         try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
            try {
              
                    Con = DriverManager.getConnection(url, user, password);
                    Stmt = Con.createStatement();       
                  PreparedStatement pstmt =null;
                  pstmt = Con.prepareStatement("INSERT INTO egyptair.user VALUES(?,?,?,?,?)");
                    pstmt.setString(1, name);
                    pstmt.setString(2, password );
                    pstmt.setString(3, email);
                    pstmt.setString(4, credit);
                    pstmt.setString(5, phone);
                    
                    N = pstmt.executeUpdate();
             
                   
                    Stmt.close();
                    RS.close();
                     Con.close();
            } catch (Exception cnfe) {
                System.err.println("Exception: " + cnfe);
            }
        return N;
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
        processRequest(request, response);
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
        processRequest(request, response);
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

}
