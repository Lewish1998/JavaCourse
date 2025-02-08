public class Gearbox {
    private String type;
    private int numberOfGears;
    private int currentGear;

    public Gearbox(String type, int numberOfGears) {
        this.type = type;
        this.numberOfGears = numberOfGears;
        this.currentGear = 0;
    }

    public String getType() {
        return this.type;
    }

    public int getNumberOfGears() {
        return this.numberOfGears;
    }

    public int getCurrentGear() {
        return this.currentGear;
    }

    public void changeGear(int gear) {
        this.currentGear = gear;
    }
}