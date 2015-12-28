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
 * @author Khaled
 */
@WebServlet(urlPatterns = {"/getFlights"})
public class GetFlight extends HttpServlet {

    final String url = "jdbc:mysql://localhost:3306/egyptair";
    final String user = "root"; //write your username
    final String password = "esraa94"; // write your password

    String source, destination, dept_place, cost, name, aircraftID, flightID;
    Date fdate;
    Connection Con = null;
    Statement Stmt = null;
    ResultSet RS = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html;charset=UTF-8");
         HttpSession session = request.getSession(true);
        if (checkFlight()) {
            session.setAttribute("SelectedflightID", flightID);
                session.setAttribute("SelectedflightName", name);
                session.setAttribute("Selecteddestination", destination);
                session.setAttribute("Selectedsource", source);
                session.setAttribute("Selecteddept_place", dept_place);
                session.setAttribute("Selectedfdate", fdate);
                session.setAttribute("SelectedflightsAircraftID", aircraftID);
                session.setAttribute("Selectedcost", cost);
        }
        response.sendRedirect("edit flight.jsp");
    }

    public boolean checkFlight() {
        boolean flag = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Con = DriverManager.getConnection(url, user, password);
            Stmt = Con.createStatement();
            RS = Stmt.executeQuery("SELECT * FROM egyptair.flight where flightID = '" + flightID + "';");

            if (RS.next()) {
                flag = true;
                aircraftID = RS.getString("aircraftID");
                cost = RS.getString("cost");
                name = RS.getString("name");
                source = RS.getString("src");
                destination = RS.getString("dest");
                fdate = RS.getDate("fdate");
                dept_place = RS.getString("flightPlace");
                flightID = RS.getString("flightID");
            }
            Stmt.close();
            RS.close();
            Con.close();
        } catch (Exception cnfe) {
            System.err.println("Exception: " + cnfe);
        }
        return flag;
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
    }// </editor-fold>k 
}
