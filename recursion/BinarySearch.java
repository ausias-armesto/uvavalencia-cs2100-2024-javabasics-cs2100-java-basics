package recursion;

public class BinarySearch {

    public static int binarySearch(int[] array, int left, int right, int target) {
        System.out.println("Searching in the array from index: " + left + " to " + right + " a total elements of " + (right - left + 1));
        if (right >= left) {
            // Keep in mind that integer division in Java rounds down to the nearest integer
            int middle = left + (right - left) / 2;

            if (array[middle] == target) {
                return middle;
            } else if (array[middle] > target) {
                return binarySearch(array, left, middle - 1, target);
            } else {
                return binarySearch(array, middle + 1, right, target);
            }
        }
        throw new IllegalArgumentException("Wrong array input indexes");
    }
    
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int target = 3;
        int index = binarySearch(array, 0, array.length - 1, target);
        System.out.println("The target " + target + " is at index: " + index);
    }
}
