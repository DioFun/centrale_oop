package model;

public class Person {
    private String firstName;
    private String lastName;
    private String address;
    private Car car;
    private final int id;
    private static int counter = 0;

    public Person() {
        this.firstName = "John";
        this.lastName = "Doe";
        this.address = "Unknown";
        this.id = counter++;
    }

    public Person(String firstName, String lastName, String address) {
        this();
        if (firstName != null && !firstName.isEmpty()) this.firstName = firstName;
        if (lastName != null && !lastName.isEmpty()) this.lastName = lastName;
        if (address != null && !address.isEmpty()) this.address = address;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public int getId() {
        return this.id;
    }

    public Car getCar() {
        return this.car;
    }

    public void setAddress(String address) {
        if (address != null && !address.isEmpty())
            this.address = address;
    }

    public boolean isPedestrian() {
        return this.car == null;
    }

    public boolean assignCar(Car car) {
        if (car != null && car.isAvailable() && this.isPedestrian()) {
            this.car = car;
            if (!car.assignDriver(this)) {
                this.car = null;
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean returnCar() {
        if (this.isPedestrian()) return false;
        Car car = this.car;
        this.car = null;
        car.removeDriver();
        return true;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", car=" + car +
                ", id=" + id +
                '}';
    }

    public static void main(String[] args) {
        Car car = new Car(null);
        Person person = new Person();
        person.assignCar(car);
        System.out.println(person);
        Car car2 = new Car("Ferrari");
        person.assignCar(car2);
        System.out.println(person);
        Person person2 = new Person("Jane", "Doe", "Unknown");
        person2.assignCar(car);
        System.out.println(person2);
        car.assignDriver(person2);
        System.out.println(person2);
        car.removeDriver();
        System.out.println(person);
    }
}
