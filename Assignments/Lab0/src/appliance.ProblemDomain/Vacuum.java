package appliance.ProblemDomain;

public class Vacuum extends Appliance {
    private String grade;
    private String batteryVoltage;

    public Vacuum(String[] data) {
        super(data);
        this.grade = data[6];
        this.batteryVoltage = data[7];
    }

    public String getBatteryVoltage() {
        return batteryVoltage;
    }

    public String getBatteryVoltageDisplay() {
        return "18".equalsIgnoreCase(batteryVoltage) ? "Low" : "High";
    }

    @Override
    public String toFileFormat() {
        return String.join(";", itemNumber, brand, String.valueOf(quantity), String.valueOf(wattage), color, String.valueOf(price), grade, batteryVoltage);
    }

    @Override
    public String toString() {
        return super.toString() + "\nGrade: " + grade + "\nBattery Voltage: " + getBatteryVoltageDisplay();
    }
}
