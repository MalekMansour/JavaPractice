package appliance.ProblemDomain;

public class Dishwasher extends Appliance {
    private String feature;
    private String soundRating;

    public Dishwasher(String[] data) {
        super(data);
        this.feature = data[6];
        this.soundRating = data[7];
    }

    public String getFeature() {
        return feature;
    }

    public String getSoundRating() {
        switch (soundRating.toUpperCase()) {
            case "QT":
                return "Quietest";
            case "QR":
                return "Quieter";
            case "QU":
                return "Quiet";
            case "M":
                return "Moderate";
            default:
                return "Unknown";
        }
    }

    @Override
    public String toFileFormat() {
        return String.join(";", itemNumber, brand, String.valueOf(quantity), String.valueOf(wattage), color, String.valueOf(price), feature, soundRating);
    }

    @Override
    public String toString() {
        return super.toString() + "\nFeature: " + feature + "\nSound Rating: " + getSoundRating();
    }
}
