package baza1;

public class Car {
    static int ID = 1;
    int id;
    String model;
    double price;
    short year;
    
    public Car() {
        
    }

    public Car(String model, double price, short year) {
        id = Car.ID++;
        this.model = model;
        this.price = price;
        this.year = year;
    }
    
    public String toString() {
        return "Car {" + id + ", " + model + ", " + price + ", " + year + "}";
    }
}
