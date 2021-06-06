package baza1;

import java.sql.*;

public class Baza2 {
    public static void main(String[] args) {
        Connection con = null;
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/car", "root", "");
            
            if(!con.isClosed()) {
                System.out.println("Connection established.");
            } else {
                System.out.println("Connection is not established.");
            }
            
            Statement stmt = con.createStatement();
            String upit = "create table friends3(\n" +
                    "id int primary key,\n" +
                    "ime varchar(30),\n" +
                    "prezime varchar(30)\n" +
                    ")";
//            stmt.execute(upit);
            
        } catch(SQLException e) {
            System.out.println("SQL exception has has occured " + e);
        }
    }
}
