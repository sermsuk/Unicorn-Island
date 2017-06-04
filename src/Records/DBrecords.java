/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Records;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bonaliza
 */
public abstract class DBrecords {
    protected Connection conn;
    protected final String url = "jdbc:derby:gamedev;create=true";
    protected final String user = "admin_joben";
    protected final String pass = "benjopogi";
    
    protected void openConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            
            conn = DriverManager.getConnection(url, user, pass);
              
        } catch (ClassNotFoundException ex){
            System.out.println("Error: " + ex);
        } catch (SQLException e) {
            System.out.println("Database connection failed!" + e);
        }
    }
}
