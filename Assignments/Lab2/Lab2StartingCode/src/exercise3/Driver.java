// For this exercise I will be using the Bubble Sorting Method (b)

package exercise3;

import java.util.Random;

public class Driver
{
    public static final int SIZE = 100;
    public static final int UPPER_BOUND = 1000;

    public static void main(String[] args)
    {
        // Create the array of random integers
        Integer[] nums = new Integer[SIZE];
        Random rand = new Random();

        for (int i = 0; i < SIZE; i++)
        {
            nums[i] = rand.nextInt(UPPER_BOUND);
        }

        // Print the array before sorting
        System.out.println("Before sorting:");
        printArray(nums);

        if (args.length > 0)
        {
            char choice = args[0].charAt(0);
            switch (choice)
            {
                case 'b': // Bubble Sort
                    bubbleSort(nums);
                    break;
                case 'i': 
                    System.out.println("Insertion Sort selected but not implemented.");
                    break;
                case 's': 
                    System.out.println("Selection Sort selected but not implemented.");
                    break;
                case 'q': 
                    System.out.println("Quick Sort selected but not implemented.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select b, i, s, or q.");
                    break;
            }
        }

        System.out.println("\nAfter sorting:");
        printArray(nums);
    }

    public static void printArray(Integer[] array)
    {
        for (int i : array)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Bubble Sort algorithm implementation
    public static void bubbleSort(Integer[] array)
    {
        int n = array.length;
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n - i - 1; j++)
            {
                if (array[j] > array[j + 1])
                {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
