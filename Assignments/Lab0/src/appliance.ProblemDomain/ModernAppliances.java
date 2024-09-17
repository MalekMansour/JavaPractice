/* 
Date: 2024-09-17
Author: Malek Mansour
Description: Modern Appliances manages a list of household appliances (Vacuums, Microwaves, Refrigerators, Dishwashers). 
The program allows the user to check out appliances by brand or by type. Users can also generate a random list of appliances. 
The program reads appliance data from the appliances.txt file. It processes the user's commands from the interface and can save 
updated data back to the file. Inputs include user commands and other parameters like item number, brand, or type. 
*/

package appliance.ProblemDomain;

import java.io.*;
import java.util.*;

public class ModernAppliances {
	
	// This is the list to store all the appliances
    private static List<Appliance> appliances = new ArrayList<>();

    public static void main(String[] args) {
    	// Load appliances from appliances.txt when the program starts
        loadAppliancesFromFile("src/appliances.txt");
        Scanner scanner = new Scanner(System.in);
        // Main loop for user inputs
        while (true) {
        	// Display the main menu
            System.out.println("Welcome to Modern Appliances!");
            System.out.println("How may we assist you?");
            System.out.println("1 – Check out appliance");
            System.out.println("2 – Find appliances by brand");
            System.out.println("3 – Display appliances by type");
            System.out.println("4 – Produce random appliance list");
            System.out.println("5 – Save & exit");
            System.out.print("Enter option: ");
            
            String input = scanner.nextLine(); 
            int option; 
            
            try {
            	// convert the user input to an integer
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                // if input is not an integer
                System.out.println("Not a valid command. Please try again.");
                continue;
            }
            
            // Process the user's choice
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
                	// Handle invalid options
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to handle checking out an appliance
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

    // Method to find appliances by brand
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

    // Method to display appliances by type
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
            scanner.nextLine(); 
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
            	// Handle invalid appliance type
                System.out.println("Invalid appliance type.");
        }
    }

    // Method to produce a random list of appliances
    private static void produceRandomApplianceList(Scanner scanner) {
        System.out.print("Enter number of random appliances: ");
        int number = scanner.nextInt();
        scanner.nextLine(); 
        
        // Shuffle the list and print a random selection of appliances
        Collections.shuffle(appliances);
        for (int i = 0; i < Math.min(number, appliances.size()); i++) {
            System.out.println(appliances.get(i));
        }
    }

    // Method to save data to file and exit the program
    private static void saveAndExit() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/appliances.txt"))) {
        	// Write each appliance to the file (appliances.txt)
            for (Appliance appliance : appliances) {
                writer.println(appliance.toFileFormat());
            }
            System.out.println("Data saved. Goodbye!");
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    // Method to load appliances from a file
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

    // Method to create an appliance object from file data
    private static Appliance createApplianceFromData(String[] data) {
        String itemNumber = data[0];
        switch (itemNumber.charAt(0)) {
     // Determine appliance type based on item number
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
