package appliance.ProblemDomain;

public class Refrigerator extends Appliance {
    private int numberOfDoors;
    private int height;
    private int width;

    public Refrigerator(String[] data) {
        super(data);
        this.numberOfDoors = Integer.parseInt(data[6]);
        this.height = Integer.parseInt(data[7]);
        this.width = Integer.parseInt(data[8]);
    }

    @Override
    public String toFileFormat() {
        return itemNumber + ";" + brand + ";" + quantity + ";" + wattage + ";" + color + ";" + price + ";" + numberOfDoors + ";" + height + ";" + width;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nNumber of Doors: " + getNumberOfDoorsDescription() +
               "\nHeight: " + height + " inches" +
               "\nWidth: " + width + " inches";
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    private String getNumberOfDoorsDescription() {
        switch (numberOfDoors) {
            case 2:
                return "Double Doors";
            case 3:
                return "Three Doors";
            case 4:
                return "Four Doors";
            default:
                return "Unknown";
        }
    }
}
