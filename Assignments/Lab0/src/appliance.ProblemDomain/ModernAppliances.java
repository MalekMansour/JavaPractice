package appliance.ProblemDomain;

import java.io.*;
import java.util.*;

public class ModernAppliances {

    private static List<Appliance> appliances = new ArrayList<>();

    public static void main(String[] args) {
        loadAppliancesFromFile("src/appliances.txt");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to Modern Appliances!");
            System.out.println("How may we assist you?");
            System.out.println("1 – Check out appliance");
            System.out.println("2 – Find appliances by brand");
            System.out.println("3 – Display appliances by type");
            System.out.println("4 – Produce random appliance list");
            System.out.println("5 – Save & exit");
            System.out.print("Enter option: ");
            
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    checkOutAppliance(scanner);
                    break;
                case 2:
                    findApplianceByBrand(scanner);
                    break;
                case 3:
                    displayApplianceByType(scanner);
                    break;
                case 4:
                    produceRandomApplianceList(scanner);
                    break;
                case 5:
                    saveAndExit();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void checkOutAppliance(Scanner scanner) {
        System.out.print("Enter the item number of an appliance: ");
        String itemNumber = scanner.nextLine();
        boolean found = false;

        for (Appliance appliance : appliances) {
            if (appliance.getItemNumber().equals(itemNumber)) {
                found = true;
                if (appliance.getQuantity() > 0) {
                    appliance.decreaseQuantity();
                    System.out.println("Appliance \"" + itemNumber + "\" has been checked out.");
                } else {
                    System.out.println("The appliance is not available to be checked out.");
                }
                break;
            }
        }

        if (!found) {
            System.out.println("No appliances found with that item number.");
        }
    }

    private static void findApplianceByBrand(Scanner scanner) {
        System.out.print("Enter brand to search for: ");
        String brand = scanner.nextLine();
        boolean found = false;
        
        System.out.println("Matching Appliances:");
        for (Appliance appliance : appliances) {
            if (appliance.getBrand().equalsIgnoreCase(brand)) {
                System.out.println(appliance);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No matching appliances found.");
        }
    }

    private static void displayApplianceByType(Scanner scanner) {
        System.out.println("Appliance Types");
        System.out.println("1 – Refrigerators");
        System.out.println("2 – Vacuums");
        System.out.println("3 – Microwaves");
        System.out.println("4 – Dishwashers");
        System.out.print("Enter type of appliance: ");

        int type = scanner.nextInt();
        scanner.nextLine(); 
        
        switch (type) {
        case 1:
            System.out.print("Enter number of doors: 2 (double door), 3 (three doors) or 4 (four doors): ");
            int doors = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println("Matching refrigerators:");
            for (Appliance appliance : appliances) {
                if (appliance instanceof Refrigerator && ((Refrigerator) appliance).getNumberOfDoors() == doors) {
                    System.out.println(appliance);
                }
            }
            break;
        case 2:
            System.out.print("Enter battery voltage value. 18 V (low) or 24 V (high): ");
            String batteryVoltage = scanner.nextLine();
            System.out.println("Matching vacuums:");
            boolean found = false;
            for (Appliance appliance : appliances) {
                if (appliance instanceof Vacuum) {
                    Vacuum vacuum = (Vacuum) appliance;
                    if (vacuum.getBatteryVoltage().equalsIgnoreCase(batteryVoltage)) {
                        System.out.println(vacuum);
                        found = true;
                    }
                }
            }
            if (!found) {
                System.out.println("No matching vacuums found.");
            }
            break;
        case 3:
            System.out.print("Room where the microwave will be installed: K (kitchen) or W (work site): ");
            String roomType = scanner.nextLine().toUpperCase();
            System.out.println("Matching microwaves:");
            for (Appliance appliance : appliances) {
                if (appliance instanceof Microwave) {
                    Microwave microwave = (Microwave) appliance;
                    if (microwave.getRoomType().equalsIgnoreCase(roomType)) {
                        System.out.println(microwave);
                    }
                }
            }
            break;
         case 4:
                System.out.print("Enter the sound rating of the dishwasher: Qt (Quietest), Qr (Quieter), Qu (Quiet), or M (Moderate): ");
                String soundRatingInput = scanner.nextLine().toUpperCase();
                System.out.println("Matching dishwashers:");
                boolean foundDishwasher = false;
                for (Appliance appliance : appliances) {
                    if (appliance instanceof Dishwasher) {
                        Dishwasher dishwasher = (Dishwasher) appliance;
                        // Debug output
                        System.out.println("Checking dishwasher: " + dishwasher);
                        if (dishwasher.getSoundRating().equalsIgnoreCase(soundRatingInput)) {
                            System.out.println(dishwasher);
                            foundDishwasher = true;
                        }
                    }
                }
                if (!foundDishwasher) {
                    System.out.println("No matching dishwashers found.");
                }
                break;
            default:
                System.out.println("Invalid appliance type.");
        }
    }

    
    private static void produceRandomApplianceList(Scanner scanner) {
        System.out.print("Enter number of random appliances: ");
        int number = scanner.nextInt();
        scanner.nextLine(); 
        
        Collections.shuffle(appliances);
        for (int i = 0; i < Math.min(number, appliances.size()); i++) {
            System.out.println(appliances.get(i));
        }
    }

    private static void saveAndExit() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/appliances.txt"))) {
            for (Appliance appliance : appliances) {
                writer.println(appliance.toFileFormat());
            }
            System.out.println("Data saved. Goodbye!");
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    private static void loadAppliancesFromFile(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(";");
                Appliance appliance = createApplianceFromData(data);
                appliances.add(appliance);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + filePath);
        }
    }

    private static Appliance createApplianceFromData(String[] data) {
        String itemNumber = data[0];
        switch (itemNumber.charAt(0)) {
            case '1':
                return new Refrigerator(data);
            case '2':
                return new Vacuum(data);
            case '3':
                return new Microwave(data);
            case '4':
            case '5':
                return new Dishwasher(data);
            default:
                throw new IllegalArgumentException("Invalid item number.");
        }
    }
}
