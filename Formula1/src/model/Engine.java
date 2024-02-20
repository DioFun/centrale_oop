package model;

public class Engine {
    private char fuel;
    private int power;

    private static final int MIN_POWER = 600;
    private static final char DIESEL = 'D';
    private static final char PETROL = 'P';

    /**
     * Default constructor
     */
    public Engine() {
        this.fuel = PETROL;
        this.power = MIN_POWER;
    }

    /**
     * Constructor with parameters
     * @param fuel
     * @param power
     */
    public Engine(char fuel, int power) {
        this();
        if (fuel == DIESEL)
            this.fuel = fuel;
        this.power = Math.max(power, this.power);
    }

    /**
     * Copy constructor
     * @param engine
     */
    public Engine(Engine engine) {
        this();
        if (engine == null)
            return;
        this.fuel = engine.fuel;
        this.power = engine.power;
    }

    public char getFuel() {
        return this.fuel;
    }

    public int getPower() {
        return this.power;
    }

    public void setFuel(char fuel) {
        if (fuel == DIESEL || fuel == PETROL)
            this.fuel = fuel;
    }

    public void setPower(int power) {
        if (power >= MIN_POWER)
            this.power = power;
    }

    @Override
    public String toString() {
        return "Engine{fuel:" + this.fuel + ",power:" + this.power + "}";
    }

    public static void main(String[] args) {
        Engine engine1, engine2, engine3;
        engine1 = new Engine();
        System.out.println(engine1);
        engine2 = new Engine('D', 800);
        System.out.println(engine2);
        engine3 = new Engine(engine2);
        System.out.println(engine3);
        Engine engine4 = new Engine('Z', 200);
        System.out.println(engine4);
    }
}


