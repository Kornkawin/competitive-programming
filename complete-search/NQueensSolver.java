public class NQueensSolver {
    private int n; // Size of the chessboard (n x n)
    private int count; // Number of valid solutions
    private boolean[] column; // Columns that already have a queen
    private boolean[] diag1; // Diagonals from top-left to bottom-right
    private boolean[] diag2; // Diagonals from top-right to bottom-left

    public NQueensSolver(int n) {
        this.n = n;
        this.count = 0;
        this.column = new boolean[n];
        this.diag1 = new boolean[2 * n - 1];
        this.diag2 = new boolean[2 * n - 1];
    }

    public int solve() {
        search(0);
        return count;
    }

    private void search(int y) {
        if (y == n) {
            count++;
            return;
        }

        for (int x = 0; x < n; x++) {
            if (column[x] || diag1[x + y] || diag2[x - y + n - 1]) continue;

            column[x] = true;
            diag1[x + y] = true;
            diag2[x - y + n - 1] = true;

            search(y + 1);

            column[x] = false;
            diag1[x + y] = false;
            diag2[x - y + n - 1] = false;
        }
    }

    public static void main(String[] args) {
        int n = 8; // Change this to solve for different board sizes
        NQueensSolver solver = new NQueensSolver(n);
        int totalSolutions = solver.solve();
        System.out.println("Number of solutions for " + n + "-Queens: " + totalSolutions);
    }
}
