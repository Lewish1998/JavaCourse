public class Car {
    private String make;
    private String model;
    private Engine engine;
    private Gearbox gearBox;

    public Car(String make, String model, Engine engine, Gearbox gearbox) {
        this.make = make;
        this.model = model;
        this.engine = engine;
        this.gearBox = gearbox;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Gearbox getGearbox() {
        return this.gearBox;
    }

    public String start() {
        return this.engine.start();
    }

    public String rev() {
        return this.engine.rev();
    }

    public void changeGear(int gear) {
        this.gearBox.changeGear(gear);
    }

    public int getCurrentGear() {
        return this.gearBox.getCurrentGear();
    }
}