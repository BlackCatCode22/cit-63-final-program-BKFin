import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // Linear Search Method
    public static int linearSearch(int[] array, int target) {
        int iterations = 0;
        for (int i = 0; i < array.length; i++) {
            iterations++;
            if (array[i] == target) {
                System.out.println("Linear search iterations: " + iterations);
                return i; // Returns index of found element
            }
        }
        System.out.println("Linear search iterations: " + iterations);
        return -1; // Target not found
    }

    // Binary Search Method
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int iterations = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            iterations++;

            if (array[mid] == target) {
                System.out.println("Binary search iterations: " + iterations);
                return mid;
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("Binary search iterations: " + iterations);
        return -1; // Target not found
    }

    // Recursive Search Method
    public static int recursiveSearch(int[] array, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] < target) {
                return recursiveSearch(array, target, mid + 1, right);
            } else {
                return recursiveSearch(array, target, left, mid - 1);
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements in array:");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Array size should be greater than 0.");
            scanner.close();
            return;
        }
        int[] array = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Enter target number to search:");
        int target = scanner.nextInt();

        // Linear Search
        int linearResult = linearSearch(array, target);
        System.out.println((linearResult == -1) ? "Target not found by linear search."
                : "Target found by linear search at index: " + linearResult);

        // Binary Search (Array must be sorted)
        Arrays.sort(array);
        int binaryResult = binarySearch(array, target);
        System.out.println((binaryResult == -1) ? "Target not found by binary search."
                : "Target found by binary search at index: " + binaryResult);

        // Recursive Binary Search (Array must be sorted)
        int recursiveResult = recursiveSearch(array, target, 0, array.length - 1);
        System.out.println((recursiveResult == -1) ? "Target not found by recursive search."
                : "Target found by recursive search at index: " + recursiveResult);

        scanner.close();

        // Timer function
        long startTime = System.nanoTime();
        linearSearch(array, 1); // Search for first element
        long linearTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        recursiveSearch(array, 15, 0, array.length - 1); // Search for last element
        long recursiveTime = System.nanoTime() - startTime;

        System.out.println("Linear Search Time: " + linearTime + " nanoseconds");
        System.out.println("Binary Search Time: " + recursiveTime + " nanoseconds");

    }
}