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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
@WebServlet(urlPatterns = {"/searchFlight"})
public class searchFlight extends HttpServlet {

    final String url = "jdbc:mysql://localhost:3306/egyptair";
    final String user = "root"; //write your username
    final String password = "M@hammed512"; // write your password
    
    
    String source, destination, dept_place, 
            cost, name, aircraftID, queryParamter,
            flightID,criteria;
    Date fdate;
     ArrayList<String> sources;
    ArrayList<String> destinations;
    ArrayList<String> dept_places;
    ArrayList<String> costs;
    ArrayList<String> names;
    ArrayList<String> aircraftIDs;
    ArrayList<String> flightIDs;
    ArrayList<Date> fdates;
    
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
            /* TODO output your page here. You may use following sample code. */
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Search Aircraft</title>");            
            out.println("</head>");
            out.println("<body>");
          
        criteria   = request.getParameter("criteria");
        //out.println("<h2>" + criteria + "  "  + queryParamter+ "<h2>");
        queryParamter  =request.getParameter("input");
        
        out.println("<h2>" + criteria + "  "  + queryParamter+ "</h2>");
            
        HttpSession session = request.getSession(true);
        //boolean check =getData(criteria,queryParamter);
        String LOL  =check(criteria,queryParamter);     
//         out.println("<h3>" + " size "+ flightIDs.size()+"</h5>");
//         out.println("<h5>" +criteria+ " " +   flightID + " from check -->  " + LOL + "  " + cost+"</h5>");
//         out.println("<h5>" + flightIDs.get(0) +flightIDs.size() +"  "  + costs.get(0)+ "</h5>");
//        
//        for(int i=0 ; i<flightIDs.size() ; i ++){
//            out.println("<h2>" + flightIDs.get(i)+ "</h2>");
//            out.println("<p>" + costs.get(i)+ "</p>");
//            out.println("<p>" + destinations.get(i)+ "</p>");
//            out.println("<p>" + sources.get(i)+ "</p>");
//        }
//        out.println("</body>");
//        out.println("</html>");
        if ( flightIDs.size() >0 ){
            
            session.setAttribute("flightIDs", flightIDs);
            session.setAttribute("flightNames", names);
            session.setAttribute("destinations", destinations);
            session.setAttribute("sources", sources);
            session.setAttribute("dept_places", dept_places);
            session.setAttribute("fdates", fdates);
            session.setAttribute("flightsAircraftID", aircraftIDs);
            session.setAttribute("costs", costs);
        }
        
        response.sendRedirect("Show flights Admin.jsp");
        }
    }

     public String check(String crit  , String param ) throws SQLException{
          dept_places = new ArrayList<>();
        destinations = new ArrayList<>();
        fdates = new ArrayList<>();
        flightIDs = new ArrayList<>();
        sources = new ArrayList<>();
        names = new ArrayList<>();
        aircraftIDs = new ArrayList<>();
        costs = new ArrayList<>();
         String check =null;
         try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
            try {
                Con = DriverManager.getConnection(url, user, password);
                Stmt = Con.createStatement();
                RS = Stmt.executeQuery("SELECT * FROM egyptair.flight where "+ crit+ " = '" + param +"';");
                
            if(RS.next()){
               check =RS.getString("src");
                               flightID = RS.getString("flightID");
                flightIDs.add(flightID);

                name = RS.getString("name");
                names.add(name);

                source = RS.getString("src");
                sources.add(source);

                destination = RS.getString("dest");
                destinations.add(destination);

                fdate = RS.getDate("fdate");
                fdates.add(fdate);

                dept_place = RS.getString("flightPlace");
                dept_places.add(dept_place);

                cost = RS.getString("cost");
                costs.add(cost);

                aircraftID = RS.getString("aircraftID");
                aircraftIDs.add(aircraftID);   
              }
            Stmt.close();
            RS.close();
            Con.close();
            } catch (Exception cnfe) {
                System.err.println("Exception: " + cnfe);
            }
            return check;
    }
     private boolean getData(String crit  , String param) throws SQLException{
      
         boolean check = false;
        String dbName="";
         try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
            try {
                Con = DriverManager.getConnection(url, user, password);
                Stmt = Con.createStatement();
                RS = Stmt.executeQuery("SELECT * FROM egyptair.flight where" + crit +" = '" + param +"';");
                
            if(RS.next()){
                check =true;
                flightID = RS.getString("flightID");
                flightIDs.add(flightID);

                name = RS.getString("name");
                names.add(name);

                source = RS.getString("src");
                sources.add(source);

                destination = RS.getString("dest");
                destinations.add(destination);

                fdate = RS.getDate("fdate");
                fdates.add(fdate);

                dept_place = RS.getString("flightPlace");
                dept_places.add(dept_place);

                cost = RS.getString("cost");
                costs.add(cost);

                aircraftID = RS.getString("aircraftID");
                aircraftIDs.add(aircraftID);                  
             }
            Stmt.close();
            RS.close();
            Con.close();
            } catch (Exception cnfe) {
                System.err.println("Exception: " + cnfe);
            }
            return check;
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
            Logger.getLogger(searchFlight.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(searchFlight.class.getName()).log(Level.SEVERE, null, ex);
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


/*

   public String check(String crit  , String param ) throws SQLException{
          
         String check =null;
         try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
            try {
                Con = DriverManager.getConnection(url, user, password);
                Stmt = Con.createStatement();
                RS = Stmt.executeQuery("SELECT * FROM egyptair.flight where "+ crit+ " = '" + param +"';");
                
            if(RS.next()){
               check =RS.getString("src");
              }
            Stmt.close();
            RS.close();
            Con.close();
            } catch (Exception cnfe) {
                System.err.println("Exception: " + cnfe);
            }
            return check;
    }
*/