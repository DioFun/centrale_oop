package model;

public class Car {
    private final int registrationNumber;
    private String brand;
    private Engine engine;
    private Person driver;
    private static int registrationCounter = 0;


    public Car() {
        this.registrationNumber = registrationCounter++;
        this.brand = "Unknown";
        this.engine = new Engine();
    }

    public Car(String brand, char fuel, int power) {
        this(brand);
        this.engine = new Engine(fuel, power);
    }

    public Car(String brand, Engine engine) {
        this(brand);
        if (engine != null) this.engine = new Engine(engine);
    }

    public Car(String brand) {
        this();
        if (brand != null && !brand.isEmpty()) this.brand = brand;
    }

    public int getRegistrationNumber() {
        return this.registrationNumber;
    }

    public String getBrand() {
        return this.brand;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public void setEngine(Engine engine) {
        this.engine = new Engine(engine);
    }

    public Person getDriver() {
        return this.driver;
    }

    public boolean isAvailable() {
        return this.driver == null;
    }

    public void assignDriver(Person driver) {
        if (driver != null && this.isAvailable() && !driver.isPedestrian() && driver.getCar().getRegistrationNumber() == this.getRegistrationNumber()) {
            this.driver = driver;
        }
    }

    public void removeDriver() {
        if (this.driver.isPedestrian()) this.driver = null;
    }

    @Override
    public String toString() {
        return "Car{" +
                "registrationNumber=" + registrationNumber +
                ", brand='" + brand + '\'' +
                ", engine=" + engine +
                '}';
    }

    public static void main(String[] args) {
        Engine e1 = new Engine(null);
        Engine e2 = new Engine('E', 1000);
        Car c1 = new Car(null, e1);
        Car c2 = new Car("Ferrari", e2);
        Car c3 = new Car("Ferrari", e2);
        System.out.println("c1 : " + c1.toString());
        System.out.println("c2 : " + c2.toString());
        System.out.println("c3 : " + c3.toString());
        e2.setPower(1200);
        System.out.println("c2 : " + c2.toString());
        System.out.println("c3 : " + c3.toString());
    }
}
