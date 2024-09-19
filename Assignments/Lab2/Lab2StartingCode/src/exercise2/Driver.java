package exercise2;

import java.util.Random;
import java.util.Scanner;

public class Driver {

    public static final int SIZE = 100;
    public static final int UPPER_BOUND = 10;

    public static void main(String[] args) {
        Integer[] nums = new Integer[SIZE];
        Random rand = new Random();
        int randnum = rand.nextInt(UPPER_BOUND);
        nums[0] = randnum;

        for (int i = 1; i < SIZE; i++) {
            randnum = rand.nextInt(UPPER_BOUND);
            nums[i] = nums[i - 1] + randnum;
        }

        System.out.println("Sorted Array:");
        for (int num : nums) {
            System.out.println(num);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the number to search for: ");
        int target = scanner.nextInt();
        scanner.close();

        int index = binarySearch(nums, target);
        if (index != -1) {
            System.out.println("\nTarget number " + target + " is found at index " + index);
        } else {
            System.out.println("\nTarget number " + target + " is not in the array.");
        }
    }

    public static int binarySearch(Integer[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; 

            if (nums[mid] == target) {
                return mid; 
            } else if (nums[mid] < target) {
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }

        return -1; 
    }
}
