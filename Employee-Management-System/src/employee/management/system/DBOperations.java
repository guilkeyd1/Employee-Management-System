/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author apramodya
 */
public class DBOperations {
    
    String url = "jdbc:mysql://localhost:3306/employee";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatment psd = null;
    
    void addEmployee(EmployeeDetails em){
        try{
            con = (Connection)DriverManager.getConnection(url,username,password);
            Strnig query = "INSERT INTO employee VALUES (?,?,?,?,?,?,?,?)";
        }catch(Exception e){
            
        }
        
    }
}
