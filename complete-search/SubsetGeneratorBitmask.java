import java.util.*;

public class SubsetGeneratorBitmask {
    public static void generateSubsets(int n) {
        // there are 2^n subsets for a set of size n
        for (int b = 0; b < (1 << n); b++) {
            List<Integer> subset = new ArrayList<>();
            
            // inspect each bit of b to determine which elements to include in the subset
            for (int i = 0; i < n; i++) {
                if ((b & (1 << i)) != 0) {
                    subset.add(i);
                }
            }

            System.out.println(subset);
        }
    }

    public static void main(String[] args) {
        int n = 3; // subsets of {0,1,2}
        generateSubsets(n);
    }
}
