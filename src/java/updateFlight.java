
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
@WebServlet(urlPatterns = {"/updateFlight"})
public class updateFlight extends HttpServlet {

    final String url = "jdbc:mysql://localhost:3306/egyptair";
    final String user = "root"; //write your username
    final String password = "esraa94"; // write your password
    Connection Con = null;
    Statement Stmt = null;
    ResultSet RS = null;
    String source, destination, dept_place, cost, name, aircraftID, flightID, aircraftName;
    int day, month, year;
    Date fdate;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        flightID = (String) request.getSession().getAttribute("SelectedflightID");
        name = request.getParameter("name");
        source = request.getParameter("source");
        destination = request.getParameter("destination");
        dept_place = request.getParameter("dept_place");
        cost = request.getParameter("cost");
        aircraftName = request.getParameter("aircraftname");
        day = Integer.parseInt(request.getParameter("day"));
        month = Integer.parseInt(request.getParameter("month"));
        year = Integer.parseInt(request.getParameter("year"));
        Date d = new Date(year, month, day);
        fdate = d;
        int rawNum;
        if (check()) {
            rawNum = update();
        }
    }

    public boolean check() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Con = DriverManager.getConnection(url, user, password);
            Stmt = Con.createStatement();
            RS = Stmt.executeQuery("SELECT * FROM egyptair.aircraft where name = '" + aircraftName + "';");

            if (RS.next()) {
                aircraftID = RS.getString("aircraftID");
                return true;
            }
            Stmt.close();
            RS.close();
            Con.close();
        } catch (Exception cnfe) {
            System.err.println("Exception: " + cnfe);
        }
        return false;
    }

    public int update() throws SQLException {
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

            String updateTableSQL = "UPDATE flight SET name = ? , src = ?"
                    + ", dest = ? ,fdate = ? , flightPlace = ?, cost = ?, aircraftID = ? WHERE flightID = ?";
            pstmt = Con.prepareStatement(updateTableSQL);
            pstmt.setString(1, name);
            pstmt.setString(2, source);
            pstmt.setString(3, destination);
            pstmt.setDate(4, fdate);
            pstmt.setString(5, dept_place);
            pstmt.setString(6, cost);
            pstmt.setString(7, aircraftID);
            pstmt.setString(8, flightID);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(updateFlight.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(updateFlight.class.getName()).log(Level.SEVERE, null, ex);
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
