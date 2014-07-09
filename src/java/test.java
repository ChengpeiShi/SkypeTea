
import ece658.ejb.SearchEmployee;
import ece658.ejb.Tester;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.List;
import javax.ejb.EJB;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wanfeiliu
 */
public class test {
    public static void main(String[] args) {
        
          //String url = "jdbc:derby://localhost:1527/";
          //String dbName = "Test";
          //String driver = "org.apache.derby.jdbc.ClientDriver";//com.mysql.jdbc.Driver";
          //String userName = "root"; 
          //String password = "19Lwf84s";
          
          //SearchMachine sm = new SearchMachine();
          SearchEmployee se = new SearchEmployee();
          List<Tester> result = null;
          
          
          try {
            // Load the Driver
            //Class.forName(driver).newInstance();
            
            // Get Connection
            //Connection con = DriverManager.getConnection(url+dbName,userName,password);
            //Statement st = con.createStatement();
            //String query = sm.searchPlatform("Windows");
            //String query = se.addEmployee(100, "fake", "fake", 100, "fake", 100, 100, "fake");
            //query = "select * from Machine where platform IN ("+"'"+"win7"+"'"+","+"'"+"winxp"+"'"+","+"'"+"win8"+"'"+","+"'"+"vista"+"'"+")";//+","+"'winxp'"+","+"'win8'"+","+"'vista'";
           
//"insert into tester(id,) values(100, 'fake', 'fake', 100, 'fake', 100, 100, 'fake')"; //        ","+"'"+"fake"+"'"+","+"'"+"fake"+"'"+","+100+","+"'"+"fake"+"'"+","+100+","+100+","+"'"+"fake"+"'"+")";
            //ResultSet res ;
            //int error = st.executeUpdate(query);
            
            //res = st.executeQuery("select * from tester");
           // res = st.
          result = se.getAllTester();
          int size = result.size();
            
          for(int i=0; i<size; i++){
             System.out.println(result.get(i).getId()); 
              
          }
          
          
          
          /*while (size >0) {
          int id = res.getInt("id");
          String msg = res.getString("name");
          String msg2 = res.getString("salary");
          System.out.println(id + "\t" + msg + "\t"+ msg2);
          }*/
          
          //con.close();

          } catch (Exception e) {
          e.printStackTrace();
          }
          }
    
    
}
