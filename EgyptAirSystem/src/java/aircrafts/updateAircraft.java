/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohammed
 */
@WebServlet(urlPatterns = {"/updateAircraft"})
public class updateAircraft extends HttpServlet {
  
    final String url = "jdbc:mysql://localhost:3306/egyptair";
    final String user = "root"; //write your username
    final String password = "M@hammed512"; // write your password
    
    String model,country,weight,seatsNum,classes,name,aircraftID;
    /*
        here we must have the aircraft id 
        and then check if the name already exist or the new name is exist 
        and we can make the name is sabet 3l4an ne search beh we 5las 
    */
    
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
     
     
    
       aircraftID = (String) request.getSession().getAttribute("aircraftid");
        model   = request.getParameter("model");
        name    = request.getParameter("name");
        country = request.getParameter("country");
        weight  = request.getParameter("weight");
        seatsNum= request.getParameter("seats");
        classes = request.getParameter("classes");
        
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
            
            //String aircraftID = check(aircraftID);
             
          //  if(aircraftID != null){
                
            out.println("before");
            rawNum= update();
            out.println("after");
            
            if(rawNum >0 ){
                out.print("the aircraft is updated successfully ");
            } else {
                out.print("error updating the aircraft" + rawNum);
            }
//            } else {
//                out.print("the aircraft is already exist" );
//            }
           out.println("</body>");
           out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(addAirCarftDB.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
  

    public String check(String name) throws SQLException{
      
        String aircraftID = "";
         try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
            try {
                Con = DriverManager.getConnection(url, user, password);
                Stmt = Con.createStatement();
                RS = Stmt.executeQuery("SELECT * FROM egyptair.aircraft where aircraftID = '" + aircraftID +"';");
                
            if(RS.next()){
               aircraftID =RS.getString("aircraftID");
             }
            Stmt.close();
            RS.close();
            Con.close();
            } catch (Exception cnfe) {
                System.err.println("Exception: " + cnfe);
            }
            return aircraftID;
    }
   
    public int update() throws SQLException{
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
                  
                    String updateTableSQL = "UPDATE aircraft SET model = ? , country = ?"
                            + ", name = ? ,weight = ? , seatsNum = ?, clases = ? WHERE aircraftID  = ?";
                  pstmt = Con.prepareStatement(updateTableSQL);
                    pstmt.setString(1, model);
                    pstmt.setString(2, country);
                    pstmt.setString(3, name);
                    pstmt.setString(4, weight);
                    pstmt.setString(5, seatsNum);
                    pstmt.setString(6, classes);
                    pstmt.setString(7, aircraftID);
                    N = pstmt.executeUpdate();
                   
                    Stmt.close();
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
