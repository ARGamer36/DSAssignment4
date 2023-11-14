import java.util.Arrays;

public class Sorting {
    public static void SelectionSort(int[] input) {
        int comparison = 0;
        int min;
        for (int i = 0; i < input.length; i++) {
            min = i;
            for (int j = i + 1; j < input.length; j++) {
                comparison += 1;
                if (input[j] < input[min]) {
                    min = j;
                }
            }
            int temp = input[i];
            input[i] = input[min];
            input[min] = temp;
        }
        PrintList(input);
        System.out.println("#Selection-sort comparisons: " + comparison);
    }
    private static int MergeSortComparison;
    public static void MergeSort(int[] input) {
        MergeSortComparison = 0;
        PrintList(MergeSortRecursive(input));
        System.out.println("#Merge-sort comparisons: " + MergeSortComparison);
    }
    private static int[] MergeSortRecursive(int[] input) {
        if (input.length > 1) {
            MergeSortComparison += 1;
            int midpoint = input.length / 2;
            int[] first = Arrays.copyOfRange(input, 0, midpoint);
            int[] second = Arrays.copyOfRange(input, midpoint, input.length);
            first = Sorting.MergeSortRecursive(first);
            second = Sorting.MergeSortRecursive(second);
            return merge(first, second);
        } else {
            return input;
        }
    }
    private static int[] merge(int[] first, int[] second) {
        int[] combined = new int[first.length + second.length];
        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < combined.length; i++) {
            if (p1 < first.length && p2 < second.length) {
                MergeSortComparison += 1;
                if (first[p1] < second[p2]) {
                    combined[i] = first[p1];
                    p1++;
                } else {
                    combined[i] = second[p2];
                    p2++;
                }
            } else if (p1 < first.length) {
                combined[i] = first[p1];
                p1++;
            } else {
                combined[i] = second[p2];
                p2++;
            }
        }
        return combined;
    }
    private static int HeapSortComparisons;
    public static void HeapSort(int[] input) {
        HeapSortComparisons = 0;
        for (int i = input.length/2; i >= 0; i--) {
            ReheapDown(input, i, input.length - 1);
        }
        for (int i = input.length - 1; i >= 1; i--) {
            int temp = input[0];
            input[0] = input[i];
            input[i] = temp;
            ReheapDown(input, 0, i - 1);
        }
        PrintList(input);
        System.out.println("#Heap-sort comparisons: " + HeapSortComparisons);
    }
    public static void ReheapDown(int[] input, int root, int bottom) {
        int max;
        int left = root * 2 + 1;
        int right = root * 2 + 2;
        if (left <= bottom) {
            if (left == bottom) {
                max = left;
            } else {
                HeapSortComparisons += 1;
                if (input[left] <= input[right]) {
                    max = right;
                } else {
                    max = left;
                }
            }
            HeapSortComparisons += 1;
            if (input[root] < input[max]) {
                int temp = input[max];
                input[max] = input[root];
                input[root] = temp;
                ReheapDown(input, max, bottom);
            }
        }

    }
    public static void QuickSortFirst(int[] input) {
        throw new RuntimeException("NYI");
    }
    public static void QuickSortRandom(int[] input) {
        throw new RuntimeException("NYI");
    }
    public static void PrintList(int[] input) {
        for (int k : input) {
            System.out.print(k + " ");
        }
        System.out.print("\n");
    }
}
