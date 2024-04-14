import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private WeightedQuickUnionUF union;
    private boolean[][] grid;
    private int sideSize;
    private int virtualSiteA;
    private int virtualSiteB;
    private int openSites;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("Out of range!");

        int virtualSites = 2;
        sideSize = n;
        grid = new boolean[n][n];
        virtualSiteA = 0;
        virtualSiteB = n * n + 1;

        union = new WeightedQuickUnionUF(n * n + virtualSites);

        // connect with virtualSites
        for (int i = 1; i <= n; i++) {
            union.union(virtualSiteA, i);
            union.union(virtualSiteB, n * (n - 1) + i);
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (isOpen(row, col)) return;

        int element = unionIndex(row, col);
        int aboveElement = element - sideSize;
        int belowElement = element + sideSize;
        int leftElement = element - 1;
        int rightElement = element + 1;

        boolean leftStayed = leftElement % sideSize != 0;
        boolean rightStayed = rightElement % sideSize != 1;

        unionIfOpen(element, aboveElement);
        unionIfOpen(element, belowElement);

        if (leftStayed) {
            unionIfOpen(element, leftElement);
        }

        if (rightStayed) {
            unionIfOpen(element, rightElement);
        }

        openSites++;
        grid[row - 1][col - 1] = true;
    }

    private int unionIndex(int row, int col) {
        return col + (sideSize * (row - 1));
    }

    private void unionIfOpen(int element, int target) {
        if (target <= 0 || target > sideSize * sideSize) return;

        if (isOpen(target)) {
            union.union(element, target);
        }
    }

    // is the site (row, col) open?
    private boolean isOpen(int element) {
        int col = element % sideSize;
        int row = element / sideSize + 1;

        if (col == 0) {
            row = element / sideSize;
            col = sideSize;
        }

        return grid[row - 1][col - 1];
    }

    public boolean isOpen(int row, int col) {
        if (row <= 0 || col <= 0 || row > sideSize || col > sideSize) {
            throw new IllegalArgumentException("Out of range!");
        }

        return grid[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (!isOpen(row, col)) return false;
        int element = unionIndex(row, col);

        return union.find(virtualSiteA) == union.find(element);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return union.find(virtualSiteA) == union.find(virtualSiteB);
    }


    public static void main(String[] args) {
        Percolation test = new Percolation(5);
//        System.out.println(0 % 5);
        test.open(2, 1);
        test.open(1, 5);
        test.open(2, 5);
        test.open(3, 5);
        test.open(4, 5);
        test.open(5, 5);
        System.out.println("persolates? " + test.percolates());
    }
}
