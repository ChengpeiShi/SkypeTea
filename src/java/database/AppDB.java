/*
 * AppDB.java
 *
 * Created on November 22, 2006, 5:13 PM
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
public class AppDB extends DBConnection {
    
    /** Creates a new instance of AppDB */
    public AppDB() throws Exception {
        super();
    }
    
    public boolean CheckUserIfExists(String username, String password) {
        try {
            // Query
            String query = "SELECT * FROM machine";
            
            // Get Connection
            getConnection();
        
            // Set the prepared Statment
            PreparedStatement ps = con.prepareStatement(query);
    
            // Set the first Argument
            ps.setString(1,username);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                if(password.equals(rs.getString("password"))) {
                    return true;
                }
                else 
                {
                    return false;
                }
            }
            else 
            {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
}
