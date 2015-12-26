/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
 * @author Mohammed
 */
@WebServlet(urlPatterns = {"/addAirCarftDB"})
public class addAirCarftDB extends HttpServlet {

    
    final String url = "jdbc:mysql://localhost:3306/egyptair";
    final String user = "root"; //write your username
    final String password = "M@hammed512"; // write your password
    
    String model,country,weight,seatsNum,calsses,name,aircraftID;
    
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
     
        model   = request.getParameter("model");
        name    = request.getParameter("name");
        country = request.getParameter("country");
        weight  = request.getParameter("weight");
        seatsNum= request.getParameter("seats");
        calsses = request.getParameter("classes");
        
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>add new Aircraft</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1> Egypt Air </h1>");
            int rawNum;
            
            String dbName = check(name);
             
            if(!name.equals(dbName)){
                
                DateFormat dateFormat = new SimpleDateFormat("MMdd");
                Calendar cal = Calendar.getInstance();
                aircraftID = dateFormat.format(cal.getTime())
                        +name.charAt(0) + name.charAt(1);
 
                out.println("before" + "\n");
               rawNum= insert();
                out.println("after");
               if(rawNum >0 ){
                   
                out.print("the aircraft is added successfully ");
               } else {
                   
                out.println("Hey m4 3aref leh error adding the aircraft");
               }
            } else {
                out.println("the aircraft is already exist");
            }
           out.println("</body>");
           out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(addAirCarftDB.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
  

    public String check(String name) throws SQLException{
      
        String dbName="";
         try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
            try {
                Con = DriverManager.getConnection(url, user, password);
                Stmt = Con.createStatement();
                RS = Stmt.executeQuery("SELECT * FROM egyptair.aircraft where name = '" + name +"';");
                
            if(RS.next()){
               dbName =RS.getString("name");
             }
            Stmt.close();
            RS.close();
            Con.close();
            } catch (Exception cnfe) {
                System.err.println("Exception: " + cnfe);
            }
            return dbName;
    }
   
    public int insert() throws SQLException{
        String dbName="";
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
                   
                   pstmt = Con.prepareStatement("INSERT INTO aircraft VALUES(?,?,?,?,?,?,?)");
                    pstmt.setString(1, aircraftID);
                    pstmt.setString(2, model);
                    pstmt.setString(3, country);
                    pstmt.setString(4, name);
                    pstmt.setString(5, weight);
                    pstmt.setString(6, seatsNum);
                    pstmt.setString(7, calsses);
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
