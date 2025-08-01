import java.util.*;

public class PermutationsRecursive {
    static int n = 3; // Example: {0, 1, 2}
    static boolean[] chosen = new boolean[n];
    static List<Integer> permutation = new ArrayList<>();

    public static void main(String[] args) {
        search();
    }

    static void search() {
        if (permutation.size() == n) {
            System.out.println(permutation);
        } else {
            for (int i = 0; i < n; i++) {
                if (chosen[i]) continue;

                chosen[i] = true;
                permutation.add(i);
                search();
                permutation.remove(permutation.size() - 1);
                chosen[i] = false;
            }
        }
    }
}
