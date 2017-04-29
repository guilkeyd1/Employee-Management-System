/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author apramodya
 */
public class DBOperations {

    String url = "jdbc:mysql://localhost:3306/employee";
    String username = "apramodya";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    boolean addEmployee(EmployeeDetails em) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO employeedetails VALUES (?,?,?,?,?,?,?,?)";

            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setInt(1, em.getRegID());
            pst.setString(2, em.getFirstname());
            pst.setString(3, em.getLastname());
            pst.setInt(4, em.getAge());
            pst.setString(5, em.getCountry());
            pst.setString(6, em.getEmail());
            pst.setString(7, em.getUsername());
            pst.setString(8, em.getPassword());

            pst.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {

            }
        }

    }

    int checkUsername(String username) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT username FROM employeedetails";
            
            pst = (PreparedStatement)con.prepareStatement(query);
            rs = pst.executeQuery();
            
            while(rs.next()){
                if(username.equals(rs.getString(1))){
                    return 0;
                }
            }
            
            return 1;
            
        } catch (Exception e) {
            System.out.println(e);
            return 2; 
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {

            }
        }

    }
}
