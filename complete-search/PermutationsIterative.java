import java.util.*;

public class PermutationsIterative {
    public static void main(String[] args) {
        int n = 3;
        int[] permutation = new int[n];

        // Initialize permutation as {0, 1, ..., n-1}
        for (int i = 0; i < n; i++) {
            permutation[i] = i;
        }

        // Generate all permutations using lexicographic order
        do {
            System.out.println(Arrays.toString(permutation));
        } while (nextPermutation(permutation));
    }

    // Custom implementation of next_permutation
    static boolean nextPermutation(int[] array) {
        // Find the largest index i such that array[i] < array[i+1]
        int i = array.length - 2;
        while (i >= 0 && array[i] >= array[i + 1]) i--;
        if (i < 0) return false; // Last permutation

        // Find the largest index j such that array[j] > array[i]
        int j = array.length - 1;
        while (array[j] <= array[i]) j--;

        // Swap array[i] and array[j]
        swap(array, i, j);

        // Reverse the sequence from i+1 to the end
        reverse(array, i + 1, array.length - 1);
        return true;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
    }

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
