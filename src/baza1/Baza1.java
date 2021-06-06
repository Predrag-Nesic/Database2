package baza1;

import java.sql.*;

public class Baza1 {

    public static void main(String[] args) {
        
        //From Java 7 this is not necessary
//        try {
//            Class.forName("org.apache.derby.jdbc.ClientDriver");
//        } catch(ClassNotFoundException e) {
//            System.err.println("Class not found " + e);
//        }
        
        Connection con = null;
        int no_of_rows = 0;

        try {
            con =  DriverManager.getConnection(
            "jdbc:derby://localhost:1527/testDb", "username", "password");
            if(con != null) {
            System.out.println("Konekcija je uspostavljena");
            }
            Statement stmt = con.createStatement();
            String upit = "create table friends3(\n" +
                    "id int primary key,\n" +
                    "ime varchar(30),\n" +
                    "prezime varchar(30)\n" +
                    ")";
//            stmt.execute(upit);
                 
            String upit2 = "insert into friends values(4, 'Zika', 'Milic')";
            
//            stmt.executeUpdate(upit2);
            String upit3 = "update friends set ime = 'Laza' where id = 3";
            stmt.executeUpdate(upit3);
            String upit4 = "update friends set ime = ? where id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(upit4);
            preparedStatement.setString(1, "Martin");
            preparedStatement.setInt(2, 2);
            preparedStatement.executeUpdate(upit4);
            ResultSet rs = stmt.executeQuery("select * from friends");
            while(rs.next()) {
                no_of_rows++;
                System.out.println(rs.getString(2) + "\t" + rs.getString("prezime"));
            }
            System.out.println("There are " + no_of_rows + " in the table.");
            
            
        } catch(SQLException e) {
            System.err.println("Error has occured " + e);
        }
        
    }
    
}
