/*
 * DBConnection.java
 *
 * Created on November 22, 2006, 4:43 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package database;

import java.sql.*;

/**
 *
 * @author mmans039
 */
public class DBConnection {
    public Connection con;
    private String url = "jdbc:mysql://localhost:3306/";
    private String dbName = "test";
    private String user = "root";
    private String pass = "19Lwf84s";
    private String driver = "com.mysql.jdbc.Driver";
    
    /** Creates a new instance of DBConnection */
    public DBConnection() throws Exception {
    //public static void main(String[] args) {
    
    try {
            // Load the Driver
            Class.forName(driver).newInstance();
            
            // Get Connection
            con = DriverManager.getConnection(url+dbName,user,pass);
            Statement st = con.createStatement();
          ResultSet res = st.executeQuery("SELECT * FROM  machine");
          while (res.next()) {
          int id = res.getInt("id");
          String msg = res.getString("platform");
          System.out.println(id + "\t" + msg);
          }
          String sql = "INSERT into machine VALUES("+"Win8"+","+"on"+","+'8'+")";
          int val = st.executeUpdate(sql);
          if(val==1)
             System.out.print("Successfully inserted value");
          con.close();



            
            
            
            
        }
        catch(Exception ex) {
            throw new Exception("Couldn't Open connection to database" + ex.getMessage());
        }
    }
    
    public void remove() {
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    protected Connection getConnection() {
        return con;
    }
    
    protected synchronized void releaseConnection() {
        remove();
    }

    
    
    
}
