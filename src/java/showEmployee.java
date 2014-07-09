/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ece658.ejb.SearchEmployee;
import ece658.ejb.Tester;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author wanfeiliu
 */
@WebServlet(name = "showEmployee")
public class showEmployee extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    String url = "jdbc:derby://localhost:1527/";
    String dbName = "Test";
    String driver = "org.apache.derby.jdbc.ClientDriver";//com.mysql.jdbc.Driver";
    String userName = "root"; 
    String password = "19Lwf84s";
    
    //initialize the searchEmployee bean.
    //SearchEmployee se = new SearchEmployee();
    
    @EJB SearchEmployee ejb;
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
    //DB CONNECTIONINFO
          
          
          String sqlQuery= null;
          //String employeeTye = null;
          Connection con = null;
          Statement st = null;
          
          ResultSet rs = null;
          
          //Result result;
          
          //init result set
          List<Tester> result = null;
          //try to get the parameter from the web page.
          String param = request.getParameter("type");
          
          //sqlQuery = se.searchState(param);
          //doing corresponding operation
          if (param==null){
              result = ejb.getAllTester();
          }
          else {
              result = ejb.getByStatus(param);
          
          }
          
          /*
          if (param==null){
              sqlQuery = "select * from tester";
          }
          else {
          sqlQuery = "select * from tester where STATUS = "+"'"+param+"'";
          
          }
          */
          
        
        
         /**PrintWriter out = response.getWriter();
         response.setContentType("text/html");
         out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet showEmployee</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet showEmployee at " + param + "</h1>");
         out.println("<html><body>"); */
          
         try {
            // Load the Driver
            //Class.forName(driver).newInstance();
            
            // Get Connection
             //con = DriverManager.getConnection(url+dbName,userName,password);
             //st = con.createStatement();
             //rs = st.executeQuery(sqlQuery);
             //result = ResultSupport.toResult(rs);
             
               //this will dispatch the result to jsp
             request.setAttribute("result", result);
             RequestDispatcher rd = request.getRequestDispatcher("/employeeView.jsp");
             rd.forward(request, response);      
                   
         
          con.close();

          } catch (Exception e){
          e.printStackTrace();
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
          String sqlQuery= null;
          //String employeeTye = null;
          Connection con = null;
          Statement st = null;
          
          ResultSet rs = null;
          
          //Result result;
           //init result set
        List<Tester> result = null;
        String param =  request.getParameter("employeename");
        //sqlQuery = se.searchName(param.toLowerCase());
        //query
        result = ejb.getByName(param.toLowerCase());
        try {
            // Load the Driver
            //Class.forName(driver).newInstance();
            
            // Get Connection
             //con = DriverManager.getConnection(url+dbName,userName,password);
             //st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
             //ResultSet.CONCUR_READ_ONLY);
            // rs = st.executeQuery(sqlQuery);
             //ResultSetMetaData rsmd = rs.getMetaData(); 
             //result = ResultSupport.toResult(rs);
             
             //int size = 0;
             //rs.last();
             //size = rs.getRow();
             //rs.beforeFirst();
            int size = 0;
            size = result.size();
             if(size >0){
             
               //this will dispatch the result to jsp
             request.setAttribute("result", result);
             RequestDispatcher rd = request.getRequestDispatcher("/employeeView.jsp");
             rd.forward(request, response);      
             }else{
             request.setAttribute("result", "Cannot find this employee, please enter valid name.");
             RequestDispatcher rd = request.getRequestDispatcher("/employeeError.jsp");
             rd.forward(request, response); 
             }
         
          con.close();

          } catch (Exception e){
          e.printStackTrace();
          } 
        
        //processRequest(request, response);
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
            out.println("<title>Servlet showEmployee</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet showEmployee at " + request.getParameter("employeename") + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
}
