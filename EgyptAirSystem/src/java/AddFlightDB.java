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

/**
 *
 * @author Khaled
 */
@WebServlet(urlPatterns = {"/AddFlightDB"})
public class AddFlightDB extends HttpServlet {

    final String url = "jdbc:mysql://localhost:3306/egyptair";
    final String user = "root"; //write your username
    final String password = "esraa94"; // write your password

    String source, destination, dept_place, cost, name, aircraftID, flightID;
    Date fdate;
    int day ,month,year;
    Connection Con = null;
    Statement Stmt = null;
    ResultSet RS = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        name = request.getParameter("name");
        source = request.getParameter("source");
        destination = request.getParameter("destination");
        dept_place = request.getParameter("dept_place");
        cost = request.getParameter("cost");
        aircraftID = request.getParameter("aircraftID");
        day =Integer.parseInt( request.getParameter("day"));
        month =Integer.parseInt( request.getParameter("month"));
        year =Integer.parseInt( request.getParameter("year"));
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>add new Flight</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h1> Egypt Air </h1>");
            int rawNum;

            String dbName = check(name);

            if (!name.equals(dbName)) {
                if (checkAircraft()) {
                    DateFormat dateFormat = new SimpleDateFormat("MMdd");
                    Calendar cal = Calendar.getInstance();
                    flightID = dateFormat.format(cal.getTime())
                            + name.charAt(0) + name.charAt(1);
                    Date d =new Date(year, month, day);
                    fdate=d;
                    out.println("before");
                    rawNum = insert();
                    out.print("after");
                    if (rawNum > 0) {

                        out.print("the flight is added successfully ");
                    } else {

                        out.print("error adding the flight");
                    }
                } else {
                    out.print("the aircraft doesn't exist");
                }
            } else {
                out.print("the flight already exists");
            }
            //response.sendRedirect("adminHome.jsp");
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(AddFlightDB.class.getName()).log(Level.SEVERE, null, ex);
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

    public String check(String name) throws SQLException {

        String dbName = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Con = DriverManager.getConnection(url, user, password);
            Stmt = Con.createStatement();
            RS = Stmt.executeQuery("SELECT * FROM egyptair.flight where name = '" + name + "';");

            if (RS.next()) {
                dbName = RS.getString("name");
            }
            Stmt.close();
            RS.close();
            Con.close();
        } catch (Exception cnfe) {
            System.err.println("Exception: " + cnfe);
        }
        return dbName;
    }

    public boolean checkAircraft() {
        boolean flag = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Con = DriverManager.getConnection(url, user, password);
            Stmt = Con.createStatement();
            RS = Stmt.executeQuery("SELECT * FROM egyptair.aircraft where aircraftID = '" + aircraftID + "';");

            if (RS.next()) {
                flag = true;
            }
            Stmt.close();
            RS.close();
            Con.close();
        } catch (Exception cnfe) {
            System.err.println("Exception: " + cnfe);
        }
        return flag;
    }

    public int insert() throws SQLException {
        String dbName = "";
        int N = -5;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {

            Con = DriverManager.getConnection(url, user, password);
            Stmt = Con.createStatement();
            PreparedStatement pstmt = null;
            pstmt = Con.prepareStatement("INSERT INTO eygptair.registered VALUES(?,?,?,?,?,?,?,?)");
            pstmt.setString(1, flightID);
            pstmt.setString(2, name);
            pstmt.setString(3, source);
            pstmt.setString(4, destination);
            pstmt.setDate(5, fdate);
            pstmt.setString(6, dept_place);
            pstmt.setString(7, cost);
            pstmt.setString(8, aircraftID);

            N = pstmt.executeUpdate();

            Stmt.close();
            RS.close();
            Con.close();
        } catch (Exception cnfe) {
            System.err.println("Exception: " + cnfe);
        }
        return N;
    }

}
