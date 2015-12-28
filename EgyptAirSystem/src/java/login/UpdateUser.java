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
@WebServlet(name = "UpdateUser", urlPatterns = {"/UpdateUser"})
public class UpdateUser extends HttpServlet {

    final String url = "jdbc:mysql://localhost:3306/egyptair";
    final String user = "root"; //write your username
    final String password = "123456"; // write your password

    String name, pass, email, credit, phone;
    /*
        here we must have the aircraft id 
        and then check if the name already exist or the new name is exist 
        and we can make the name is sabet 3l4an ne search beh we 5las 
     */

    Connection Con = null;
    Statement Stmt = null;
    ResultSet RS = null;

    /**
     * /**
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
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        name = request.getParameter("name");
        pass = request.getParameter("password");
        email = request.getParameter("email");
        credit = request.getParameter("creditCard");
        phone = request.getParameter("phone");

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>update user</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h1> Egypt Air </h1>");

            update();

        }
    }
    
    public void update() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {

            Con = DriverManager.getConnection(url, user, password);
            Stmt = Con.createStatement();
            PreparedStatement pstmt = null;

            String updateTableSQL = "UPDATE user SET name = ? , password = ?"
                    + ", email = ? , creditcardNum = ?, phone = ? WHERE email  = ?";
            pstmt = Con.prepareStatement(updateTableSQL);
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setString(4, credit);
            pstmt.setString(5, phone);
            pstmt.executeUpdate();

            Stmt.close();
            Con.close();
        } catch (Exception cnfe) {
            System.err.println("Exception: " + cnfe);
        }
    }

}
