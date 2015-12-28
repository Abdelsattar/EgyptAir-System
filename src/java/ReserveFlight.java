
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
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
 * @author Khaled
 */
@WebServlet(urlPatterns = {"/ReserveFlight"})
public class ReserveFlight extends HttpServlet {

    final String url = "jdbc:mysql://localhost:3306/egyptair";
    final String user = "root"; //write your username
    final String password = "esraa94"; // write your password

    Connection Con = null;
    Statement Stmt = null;
    ResultSet RS = null;

    String name, flightID, email;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        name = request.getParameter("flightname");
        email = (String) request.getSession().getAttribute("email");
        if (CheckandGetflightID()) {
            if (checkPrevEntery()) {
                insert();
            } else {
                //d5lha abl kda
            }
        } else {
            //flight m4 mawgooda
        }
    }

    boolean checkPrevEntery() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Con = DriverManager.getConnection(url, user, password);
            Stmt = Con.createStatement();
            RS = Stmt.executeQuery("SELECT * FROM egyptair.reserved where email='" + email + "';");
            while (RS.next()) {
                String fID = RS.getString("flightID");
                if (fID.equals(flightID)) {
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReserveFlight.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    boolean CheckandGetflightID() {
        boolean flag = false;
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
                flag = true;
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

    public int insert() throws SQLException {
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
            pstmt = Con.prepareStatement("INSERT INTO eygptair.reserved VALUES(?,?)");
            pstmt.setString(1, email);
            pstmt.setString(2, flightID);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ReserveFlight.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ReserveFlight.class.getName()).log(Level.SEVERE, null, ex);
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
