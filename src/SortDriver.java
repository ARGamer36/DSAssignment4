import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SortDriver {
    public static void main(String[] args) {
        try {
            File file = new File(args[0]);
            Scanner fileInput = new Scanner(file);
            int[] array = new int[10000];
            int num = 0;
            while (fileInput.hasNextInt()) {
                array[num] = fileInput.nextInt();
                num++;
            }
            //xarray = new int[]{2, 10, 8, 5, 3, 4, 6, 9, 1, 7};
            Sorting.PrintList(array);
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
        } catch (FileNotFoundException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Input File Not Provided");
        }
    }
}
