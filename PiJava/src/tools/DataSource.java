/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class DataSource {
    private Connection cnx;
 

    private static DataSource instance;

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
            return instance;
        } else {
            return instance;
        }
    }

    private DataSource() {
        
        try {
            cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/javapi","root","");
            System.out.println("Connected !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public Connection getCnx() {
        
        return cnx;
    }
    
}
