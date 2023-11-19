import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
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

        Scanner input = new Scanner(System.in);

        if (!fileFound) {
            System.out.println("Using randomly generated list");
            System.out.print("Size of list: ");
            int size = input.nextInt();
            array = new int[size];
            Random random = new Random();
            for (int i = 0; i < array.length; i++) {
                array[i] = random.ints(1, size).findFirst().getAsInt();
            }
            Sorting.PrintList(array);
        }

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
    }
}
