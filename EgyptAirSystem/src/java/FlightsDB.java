
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
@WebServlet(urlPatterns = {"/FlightsDB"})
public class FlightsDB extends HttpServlet {

    String source, destination, dept_place, cost, name, aircraftID, flightID;
    Date fdate;
    ArrayList<String> sources;
    ArrayList<String> destinations;
    ArrayList<String> dept_places;
    ArrayList<String> costs;
    ArrayList<String> names;
    ArrayList<String> aircraftIDs;
    ArrayList<String> flightIDs;
    ArrayList<Date> fdates;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet FlightsDB</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet FlightsDB at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
            getAircrftsDB();
            HttpSession session = request.getSession(true);
            if (flightIDs.size() != 0) {
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

    void getAircrftsDB() {
        dept_places = new ArrayList<>();
        destinations = new ArrayList<>();
        fdates = new ArrayList<>();
        flightIDs = new ArrayList<>();
        sources = new ArrayList<>();
        names = new ArrayList<>();
        aircraftIDs = new ArrayList<>();
        costs = new ArrayList<>();
        Connection Con = null;
        Statement Stmt = null;
        ResultSet RS = null;
        String pass = null;
        final String url = "jdbc:mysql://localhost:3306/egyptair";
        final String user = "root"; //write your username
        final String password = "M@hammed512"; // write your password

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Con = DriverManager.getConnection(url, user, password);
            Stmt = Con.createStatement();
            RS = Stmt.executeQuery("SELECT * FROM egyptair.flight;");

            while (RS.next()) {
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
