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
 * @author Mohammed
 */
@WebServlet(urlPatterns = {"/getAircrafts"})
public class getAircrafts extends HttpServlet {

     final String url = "jdbc:mysql://localhost:3306/egyptair";
    final String user = "root"; //write your username
    final String password = "M@hammed512"; // write your password
    
    
    String model,country,weight,seatsNum,calsses,name,aircraftID;
    
    ArrayList <String> models;
    ArrayList <String> countries ; 
    ArrayList <String> weights ;
    ArrayList <String> seats;
    ArrayList <String> classesNum ; 
    ArrayList <String> names ;
    ArrayList <String> aircraftsIds ;

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet getAircrafts</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet getAircrafts at " 
//                    + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//              
    
                    response.sendRedirect("show aircrafts.jsp");

        }
        
       }

     public boolean getAircrafts() throws SQLException{
        
        models = new ArrayList<>();
        countries = new ArrayList<>()  ; 
        weights = new ArrayList<>();
        seats = new ArrayList<>();
        classesNum = new ArrayList<>(); 
        names = new ArrayList<>(); 
        aircraftsIds = new ArrayList<>();
        
          try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
       
            try {
                Con = DriverManager.getConnection(url, user, password);
                Stmt = Con.createStatement();
             
                RS = Stmt.executeQuery("SELECT * FROM egyptair.aircraft;");
                while(RS.next()){
                    
                    model   = RS.getString("model");
                    models.add(model);
                    
                    name    = RS.getString("name");
                    names.add(name);
                    
                    country = RS.getString("country");
                    countries.add(country);
                    
                    weight  = RS.getString("weight");
                    weights.add(weight);
                    
                    seatsNum= RS.getString("seats");
                    seats.add(seatsNum);
                    
                    calsses = RS.getString("classes");
                    classesNum.add(calsses);
                    
                    aircraftID = RS.getString("aircraftID");
                    aircraftsIds.add(aircraftID);
                }
                Stmt.close();
                RS.close();
                Con.close();
                return true;
                
            } catch (Exception cnfe) {
                System.err.println("Exception: " + cnfe);
            }
            return false ;
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
        
        response.sendRedirect("show aircrafts.jsp");
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
        
        response.sendRedirect("show aircrafts.jsp");
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
