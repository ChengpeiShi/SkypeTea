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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

/**
 *
 * @author wanfeiliu
 */
@WebServlet(name = "showEquipment")
public class showEquipment extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     String url = "jdbc:derby://localhost:1527/";
    String dbName = "Test";
    String driver = "org.apache.derby.jdbc.ClientDriver";//com.mysql.jdbc.Driver";
    String userName = "root"; 
    String password = "19Lwf84s";
    //initilize the SearchMachine bean.
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
        //processRequest(request, response);
          String sqlQuery= null;
          //String employeeTye = null;
          Connection con = null;
          Statement st = null;
          
          ResultSet rs = null;
          
          //Result result;
          //init result set
          List<Machine> result = null;
          
          //try to get the parameter from the web page.
          String param = request.getParameter("type");
          //doing query
          if(param.equalsIgnoreCase("all")){
              //get data record
              result = ejb.getAllMachine();
          }
          
          else if(param.equalsIgnoreCase("on") || param.equalsIgnoreCase("off")){
              result = ejb.getByPowerstate(param);
          }
          else if (param.equalsIgnoreCase("windows")){
              result = ejb.getByPlatform("win%");
          }
          else if (param.equalsIgnoreCase("ubuntu")){
              result = ejb.getByPlatform("ubuntu%");
          }
          else {
              result = ejb.getByPlatform(param);
          }
          
          
         
          
        
          
        
        
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
            // st = con.createStatement();
             //rs = st.executeQuery(sqlQuery);
             //result = ResultSupport.toResult(rs);
             
               //this will dispatch the result to jsp
             request.setAttribute("result", result);
             RequestDispatcher rd = request.getRequestDispatcher("/machineView.jsp");
             rd.forward(request, response);      
             
          
        
          con.close();

          } catch (Exception e) {
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
          List<Machine> result = null;
          //try to get the parameter from the web page.
          String param = request.getParameter("equipmentid");
          
          int id= 0;
          try{
           id = Integer.parseInt(param);
          } catch (NumberFormatException e){
              
          }
          //sqlQuery = sm.searchID(id);
          //get data record
        result = ejb.getByid(id);
        
        try {
            // Load the Driver
            //Class.forName(driver).newInstance();
            
            // Get Connection
             //con = DriverManager.getConnection(url+dbName,userName,password);
             //st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
            // ResultSet.CONCUR_READ_ONLY);
             //rs = st.executeQuery(sqlQuery);
             //result = ResultSupport.toResult(rs);
             
             int size = result.size();
            
             
             if(size >0){
               //this will dispatch the result to jsp
             request.setAttribute("result", result);
             RequestDispatcher rd = request.getRequestDispatcher("/machineView.jsp");
             rd.forward(request, response);      
             } else {
                 request.setAttribute("result", "Cannot fine the machine, please enter valid machine information.");
             RequestDispatcher rd = request.getRequestDispatcher("/machineErrorPage.jsp");
             rd.forward(request, response);
             }
          
        
          con.close();

          } catch (Exception e) {
          e.printStackTrace();
          }
        
        
        processRequest(request, response);
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet showEquipment</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet showEquipment at " + request.getParameter("equipmentid") + "</h1>");
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
