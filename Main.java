import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car {

    private String CarID;

    private String brand;

    private String model;

    private Double basePricePerDay;

    private boolean isAvailable;

    public Car(String carID, String brand, String model, Double basePricePerDay) {
        this.CarID = carID;
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.isAvailable = true;
    }

    public String getCarID() {
        return CarID;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Double getBasePricePerDay() {
        return basePricePerDay;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Double calculatePrice(int rentalDays) {
        return basePricePerDay * rentalDays;
    }

    public void rent (){
        isAvailable=false;
    }

    public void returnCar() {
        isAvailable = true;
    }

   



}

class Costumer {
    private String costumerId;
    private String name;


public Costumer (String costumerId, String name){
    this.costumerId = costumerId;
    this.name = name;
}

public String getCostumerId(){
    return costumerId;
}

public String getName(){
    return name;
}



}

class Rental {
    private Car car;

    private Costumer costumer;

    private int days;

    public Rental(Car car, Costumer costumer, int days) {
        this.car = car;
        this.costumer = costumer;
        this.days = days;
    }

    public Car getCar(){
        return car;
    }

    public Costumer getCostumer(){
        return costumer;
    }

    public int getDays(){
        return days;
    }

}

class CarRentalSystem {

    private List<Car> cars;
    private List<Rental> rentals;
    private List<Costumer> customers; 

    public CarRentalSystem() {
        cars = new ArrayList<>();
        rentals = new ArrayList<>();
        customers = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void rentCar(Car car, Costumer customer, int days) { 
        if (car.isAvailable()) {
            rentals.add(new Rental(car, customer, days)); 
            car.rent(); 
        } else {
            System.out.println("Car is not available.");
        }
    }

    public void returnCar(Car car) {
        car.returnCar();
        Rental rentalToRemove = null;
        for (Rental rental : rentals) {
            if (rental.getCar().equals(car)) {
                rentalToRemove = rental;
                System.out.println("Car returned successfully!");
                break;
            }
        }
        if (rentalToRemove != null) {
            rentals.remove(rentalToRemove);
        } else {
            System.out.println("Car was not rented.");
        }
    }
}
