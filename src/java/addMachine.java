/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ece658.ejb.Machine;
import ece658.ejb.SearchMachine;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author wanfeiliu
 */
public class addMachine extends HttpServlet {
    
    
    String url = "jdbc:derby://localhost:1527/";
    String dbName = "Test";
    String driver = "org.apache.derby.jdbc.ClientDriver";//com.mysql.jdbc.Driver";
    String userName = "root"; 
    String password = "19Lwf84s";
    
    //initialize the searchEmployee bean.
    //SearchMachine sm = new SearchMachine();
    @EJB SearchMachine ejb;
    

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
        
        Connection con = null;
          Statement st = null;
          
          ResultSet rs = null;
           String sqlQuery= null;
          //Result result;
          //init result set
        List<Machine> result = null;
        String idString  =  request.getParameter("id");
        int id= 0;
          try{
           id = Integer.parseInt(idString);
          } catch (NumberFormatException e){   
          }
          
          
        String platform = request.getParameter("platform");
        String powerstate = request.getParameter("powerstate");
        String skype = request.getParameter("skype");
        
        //sqlQuery = sm.addMachine(id, platform, powerstate, skype);
        
        try {
            // Load the Driver
            //Class.forName(driver).newInstance();
            
            // Get Connection
             //con = DriverManager.getConnection(url+dbName,userName,password);
             //st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
             //ResultSet.CONCUR_READ_ONLY);
             //return how many rows will be affected.
             //rs = st.executeQuery("select * from machine where ID="+id);
              //add the machine into database
               //check the id already exists
             result = ejb.getByid(id);         
             int count = result.size();
             
             //if(rs.next()){
               //  count = rs.getInt(1);
             //}
             // the employee is not there.
             if(count == 0){
             
             //int updateSuccess = st.executeUpdate(sqlQuery);
             
             //need some error handling properly
             
             //ResultSetMetaData rsmd = rs.getMetaData(); 
             //result = ResultSupport.toResult(rs);
             
             /*int size = 0;
             rs.last();
             size = rs.getRow();
             rs.beforeFirst();*/
             //rs = st.executeQuery("select * from tester where ID="+id);
            
             //add the machine into database
             ejb.addMachine(id, platform, powerstate, skype);

               //this will dispatch the result to jsp
             request.setAttribute("result", "This machine has been added.");
             RequestDispatcher rd = request.getRequestDispatcher("/machineSuccessPage.jsp");
             rd.forward(request, response); 
             st.executeUpdate(sqlQuery);
             }
             else {
             request.setAttribute("result", "This machine cannot be added, please enter valid machine ID.");
             RequestDispatcher rd = request.getRequestDispatcher("/machineErrorPage.jsp");
             rd.forward(request, response); 
             }
         
          con.close();

          } catch (Exception e){
          e.printStackTrace();
          } 
        
        processRequest(request, response);
    }

    
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addMachine</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addMachine at " + request.getParameter("id") + "</h1>");
            out.println("<h1>Servlet addMachine at " + request.getParameter("platform") + "</h1>");
            out.println("<h1>Servlet addMachine at " + request.getParameter("powerstate") + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
