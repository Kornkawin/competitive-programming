import java.util.*;

public class SubsetGeneratorRecursive {
    static int n; // numbers of set members
    static List<Integer> subset = new ArrayList<>();

    public static void generateSubsets(int k) {
        if (k == n) {
            // print each subset
            System.out.println(subset);
        } else {
            // case not including k in the subset
            generateSubsets(k + 1);

            // case including k in the subset
            subset.add(k);
            generateSubsets(k + 1);

            // backtrack to remove k
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        n = 3; // subsets of {0,1,2}
        generateSubsets(0);
    }
}
