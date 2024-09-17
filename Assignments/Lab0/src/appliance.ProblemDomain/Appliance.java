package appliance.ProblemDomain;

public abstract class Appliance {
    protected String itemNumber;
    protected String brand;
    protected int quantity;
    protected int wattage;
    protected String color;
    protected double price;

    public Appliance(String[] data) {
        this.itemNumber = data[0];
        this.brand = data[1];
        this.quantity = Integer.parseInt(data[2]);
        this.wattage = Integer.parseInt(data[3]);
        this.color = data[4];
        this.price = Double.parseDouble(data[5]);
    }

    public abstract String toFileFormat();

    public String getItemNumber() {
        return itemNumber;
    }

    public String getBrand() {
        return brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void decreaseQuantity() {
        if (quantity > 0) {
            quantity--;
        }
    }

    public int getWattage() {
        return wattage;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item Number: " + itemNumber + "\nBrand: " + brand + "\nQuantity: " + quantity +
               "\nWattage: " + wattage + "W\nColor: " + color + "\nPrice: $" + price;
    }
}

