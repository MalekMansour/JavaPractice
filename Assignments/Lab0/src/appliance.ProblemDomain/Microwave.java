package appliance.ProblemDomain;

public class Microwave extends Appliance {
    private double capacity;
    private String roomType;

    public Microwave(String[] data) {
        super(data);
        this.capacity = Double.parseDouble(data[6]); 
        this.roomType = data[7]; 
    }

    public String getRoomType() {
        return roomType;
    }

    @Override
    public String toFileFormat() {
        return String.join(";", itemNumber, brand, String.valueOf(quantity), String.valueOf(wattage), color, String.valueOf(price), String.valueOf(capacity), roomType);
    }

    @Override
    public String toString() {
        return super.toString() + "\nCapacity: " + capacity + "\nRoom Type: " + roomType;
    }
}
