public class Main {

    public static void main(String[] args) {

        int[] numbers = new int[10];

        numbers[0] = 35;
        numbers[1] = 69;
        numbers[2] = 1;
        numbers[3] = 10;
        numbers[4] = -50;
        numbers[5] = 320;
        numbers[6] = 63;
        numbers[7] = 58;
        numbers[8] = 26;
        numbers[9] = 13;

        System.out.println("Original array:");
        printArrayElements(numbers);

        // Bubble sort
        bubbleSort(numbers.clone());

        // Selection sort
        selectionSort(numbers.clone());

        // Selection sort but its smallest value
        selectionSortSmallValue(numbers.clone());
    }


    private static void bubbleSort(int[] arr) {

        for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--) {
            for (int i = 0; i < lastSortedIndex; i++) {

                // Descending → swap if left < right
                if (arr[i] < arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }

        System.out.println("\n\nAfter bubble sort:");
        printArrayElements(arr);
    }

    private static void selectionSort(int[] arr) {

        for (int firstSortedIndex = 0; firstSortedIndex < arr.length - 1; firstSortedIndex++) {

            int largestIndex = firstSortedIndex;

            for (int i = firstSortedIndex + 1; i < arr.length; i++) {
                if (arr[i] > arr[largestIndex]) {
                    largestIndex = i;
                }
            }

            int temp = arr[firstSortedIndex];
            arr[firstSortedIndex] = arr[largestIndex];
            arr[largestIndex] = temp;
        }

        System.out.println("\n\nAfter selection sort:");
        printArrayElements(arr);
    }

    private static void selectionSortSmallValue(int[] arr) {

        for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--) {

            int smallestIndex = 0;

            for (int i = 1; i <= lastSortedIndex; i++) {
                if (arr[i] < arr[smallestIndex]) {
                    smallestIndex = i;
                }
            }

            int temp = arr[lastSortedIndex];
            arr[lastSortedIndex] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }

        System.out.println("\n\nAfter selection sort (Smallest value):");
        printArrayElements(arr);
    }

    private static void printArrayElements(int[] arr) {
        for (int value : arr) {
            System.out.println(value);
        }
    }
}