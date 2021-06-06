package baza1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    public String INSERT = "insert into cars values (?, ?, ?, ?)";
    public String DELETE = "delete from cars where id = ?";
    public String UPDATE = "update cars set model = ?, price = ?, year = ? where id = ?";
    public String GET = "select * from cars where id = ? limit = 1";
    public String GETALL = "select * from cars";
       
    public Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/car", "root", "");
    }
    
    public void add(Car car) throws SQLException {
        Connection con = connect();
        PreparedStatement ps = con.prepareStatement(INSERT);
        ps.setInt(1, car.id);
        ps.setString(2, car.model);
        ps.setDouble(3, car.price);
        ps.setShort(4, car.year);
        ps.execute();
        con.close();
    }
    
    public void remove(Car car) throws SQLException {
        Connection con = connect();
        PreparedStatement ps = con.prepareStatement(DELETE);
        ps.setInt(1, car.id);
        ps.execute();
        con.close();   
    }
    
//    public void update(Car car) throws SQLException {
//        Connection con = connect();
//        PreparedStatement ps = con.prepareStatement(UPDATE);
//        ps.setInt(1, car.id);
//        ps.setString(2, car.model);
//        ps.setDouble(3, car.price);
//        ps.setShort(4, car.year);
//        ps.execute();
//        con.close();
//    }
    
    public List get() throws SQLException {
        List list = new ArrayList();
        Connection con = connect();
        PreparedStatement ps = con.prepareStatement(GETALL);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            list.add(new Car(rs.getString(2), rs.getDouble(3), rs.getShort(4)));
        }
        con.close();
        return list;
    }
}
