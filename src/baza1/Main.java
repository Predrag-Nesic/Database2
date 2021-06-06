package baza1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            
// This is the main thing for now in this code, I created a database called "car" and i added objects
// one by one using helper class
            Car car1 = new Car("Audi", 7000, (short) 2020);
            Car car2 = new Car("Audi", 7000, (short) 2020);
            Helper h = new Helper();
//            h.add(car2);
//            h.get();

//            h.remove(car2);
            List<Car> list = new ArrayList<>();
            list = h.get();

            for (Car c : list) {
                System.out.println(c);
            }
        } catch (SQLException e) {
            System.out.println("Error has occured: " + e);
        }
    }
}
