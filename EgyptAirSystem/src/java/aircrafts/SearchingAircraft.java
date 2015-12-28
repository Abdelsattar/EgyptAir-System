
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
@WebServlet(urlPatterns = {"/SearchingAircraft"})
public class SearchingAircraft extends HttpServlet {

    
     final String url = "jdbc:mysql://localhost:3306/egyptair";
    final String user = "root"; //write your username
    final String password = "M@hammed512"; // write your password
    
    
    String model,country,weight,seatsNum,calsses,name,aircraftID;
  
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
        response.setContentType("text/html;charset=UTF-8");
          try (PrintWriter out = response.getWriter()) {

                      
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Search Aircraft</title>");            
            out.println("</head>");
            out.println("<body>");
            name   = request.getParameter("aircraftName");
           getData(name);
           HttpSession session = request.getSession(true);

           if(model != null){
                session.setAttribute("model", model);
                session.setAttribute("name",   name);
                session.setAttribute("weight", weight);
                session.setAttribute("seats",  seatsNum);
                session.setAttribute("classes", calsses);
                session.setAttribute("country" ,country );
                session.setAttribute("aircraftid", aircraftID);
                        
             }
  
          //  session.setAttribute("checkaircrfts", false);
            response.sendRedirect("edit aircraft.jsp");            
        }
        
    }
    
    
    
    public String getData(String na) throws SQLException{
      
        String dbName="";
         try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
            try {
                Con = DriverManager.getConnection(url, user, password);
                Stmt = Con.createStatement();
                RS = Stmt.executeQuery("SELECT * FROM egyptair.aircraft where name = '" + na +"';");
                
            if(RS.next()){
                aircraftID =RS.getString("aircraftID");
                model   = RS.getString("model");
                name    = RS.getString("name");
                country = RS.getString("country");
                weight  = RS.getString("weight");
                seatsNum= RS.getString("seatsNum");
                calsses = RS.getString("clases");                    
             }
            Stmt.close();
            RS.close();
            Con.close();
            } catch (Exception cnfe) {
                System.err.println("Exception: " + cnfe);
            }
            return aircraftID;
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
//     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
             processRequest(request, response);
         } catch (SQLException ex) {
             Logger.getLogger(SearchingAircraft.class.getName()).log(Level.SEVERE, null, ex);
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
             Logger.getLogger(SearchingAircraft.class.getName()).log(Level.SEVERE, null, ex);
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

}
