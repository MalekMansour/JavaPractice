package appliance.ProblemDomain;

public class Dishwasher extends Appliance {
    private String feature;
    private String soundRating;

    public Dishwasher(String[] data) {
        super(data);
        this.feature = data[6];
        this.soundRating = data[7];  
    }

    public String getSoundRating() {
        return soundRating;
    }

    @Override
    public String toFileFormat() {
        return String.join(";", itemNumber, brand, String.valueOf(quantity), String.valueOf(wattage), color, String.valueOf(price), feature, soundRating);
    }

    @Override
    public String toString() {
        return super.toString() + "\nFeature: " + feature + "\nSoundRating: " + soundRating;
    }
}
