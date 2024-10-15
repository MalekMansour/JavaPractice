import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import util.SortingUtility;

public class SortingApplication {
    public static void main(String[] args) {
        String fileName = "";
        char compareType = 'h';
        char sortType = 'b';

        for (String arg : args) {
            if (arg.toLowerCase().startsWith("-f")) {
                fileName = arg.substring(2);
            } else if (arg.toLowerCase().startsWith("-t")) {
                compareType = arg.toLowerCase().charAt(2);
            } else if (arg.toLowerCase().startsWith("-s")) {
                sortType = arg.toLowerCase().charAt(2);
            }
        }

        if (fileName.isEmpty() || !isValidCompareType(compareType) || !isValidSortType(sortType)) {
            System.out.println("Invalid arguments. Usage: java -jar Sort.jar -ffile_name -t[v|h|a] -s[b|s|i|m|q|z]");
            return;
        }

        try {
            Shape[] shapes = readShapesFromFile(fileName);
            Comparator<Shape> comparator = getComparator(compareType);

            long startTime, endTime;
            
            startTime = System.nanoTime();
            switch (sortType) {
                case 'b':
                    SortingUtility.bubbleSort(shapes);
                    break;
                case 's':
                    SortingUtility.selectionSort(shapes);
                    break;
                case 'i':
                    SortingUtility.insertionSort(shapes);
                    break;
                case 'm':
                    SortingUtility.mergeSort(shapes);
                    break;
                case 'q':
                    SortingUtility.quickSort(shapes);
                    break;
                case 'z':
                    SortingUtility.heapSort(shapes);
                    break;
            }
            endTime = System.nanoTime();

            System.out.println("Sorting time: " + (endTime - startTime) / 1_000_000.0 + " ms");

            System.out.println("First 3 elements:");
            for (int i = 0; i < Math.min(3, shapes.length); i++) {
                System.out.println(shapes[i]);
            }
            System.out.println("Last 3 elements:");
            for (int i = Math.max(0, shapes.length - 3); i < shapes.length; i++) {
                System.out.println(shapes[i]);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static boolean isValidCompareType(char compareType) {
        return compareType == 'v' || compareType == 'h' || compareType == 'a';
    }

    private static boolean isValidSortType(char sortType) {
        return sortType == 'b' || sortType == 's' || sortType == 'i' || sortType == 'm' || sortType == 'q' || sortType == 'z';
    }

    private static Shape[] readShapesFromFile(String fileName) throws IOException {
        List<Shape> shapes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int numShapes = Integer.parseInt(br.readLine().trim());
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length < 3) continue;
                String shapeType = parts[0];
                double height = Double.parseDouble(parts[1]);
                double secondParam = Double.parseDouble(parts[2]);
                shapes.add(createShape(shapeType, height, secondParam));
            }
        }
        return shapes.toArray(new Shape[0]);
    }

    private static Shape createShape(String shapeType, double height, double secondParam) {
        switch (shapeType.toLowerCase()) {
            case "cylinder":
                return new Cylinder(height, secondParam);
            case "cone":
                return new Cone(height, secondParam);
            case "pyramid":
                return new Pyramid(height, secondParam);
            case "squareprism":
                return new SquarePrism(height, secondParam);
            case "triangularprism":
                return new TriangularPrism(height, secondParam);
