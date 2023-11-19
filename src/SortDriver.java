import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SortDriver {
    public static void main(String[] args) {
        boolean fileFound = false;
        int[] array = new int[1];
        try {
            File file = new File(args[0]);
            Scanner fileInput = new Scanner(file);
            array = new int[10000];
            int num = 0;
            while (fileInput.hasNextInt()) {
                array[num] = fileInput.nextInt();
                num++;
            }
            fileFound = true;
        } catch (FileNotFoundException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Input File Not Provided");
        }
        if (fileFound) {
            // array = new int[]{5, 10, 8, 2, 3, 4, 6, 9, 1, 7};
            // array = new int[]{75, 42, 3, 91, 11, 64, 17, 49, 28, 85, 5, 0, 36, 54, 96, 20, 68, 32, 77, 13, 60, 48, 81, 26, 72, 8, 59, 23, 87, 41, 16, 99, 50, 6, 34, 67, 21, 73, 1, 45, 95, 38, 82, 29, 53, 12, 70, 24, 63, 10, 79, 31, 92, 55, 7, 46, 18, 66, 35, 89, 14, 97, 37, 78, 19, 51, 25, 74, 43, 84, 58, 9, 69, 30, 80, 56, 22, 94, 40, 76, 15, 62, 47, 86, 4, 93, 65, 33, 98, 52, 27, 88, 71, 2, 61, 44, 83, 57, 39, 90};
            // array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};
            // Sorting.PrintList(array);
            Scanner input = new Scanner(System.in);
            System.out.println("selection-sort (s) merge-sort (m) heap-sort (h) quick-sort-fp (q) quick-sort-rp (r)");
            System.out.print("Enter the algorithm: ");
            String alg = input.next();
            switch (alg.toLowerCase()) {
                case "s":
                    Sorting.SelectionSort(array);
                    break;
                case "m":
                    Sorting.MergeSort(array);
                    break;
                case "h":
                    Sorting.HeapSort(array);
                    break;
                case "q":
                    Sorting.QuickSortFirst(array);
                    break;
                case "r":
                    Sorting.QuickSortRandom(array);
                    break;
            }
            // Sorting.PrintList(array);
        }
    }
}
