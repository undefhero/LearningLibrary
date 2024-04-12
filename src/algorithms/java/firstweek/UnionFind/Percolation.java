import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    WeightedQuickUnionUF union;
    int[] sites;
    int sideSize;
    int virtualSiteA;
    int virtualSiteB;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("Out of range!");

        int virtualSites = 2;
        sideSize = n;
        sites = new int[n * n];
        virtualSiteA = n * n;
        virtualSiteB = n * n + 1;

        union = new WeightedQuickUnionUF(n * n + virtualSites);

        // connect with virtualSites
        for (int i = 0; i < n; i++) {
            union.union(virtualSiteA, i);
            union.union(virtualSiteB, n * (n - 1) + i);
            sites[i] = 1;
            sites[n * (n - 1) + i] = 1;
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!isOpen(row, col)) {
            int element = unionIndex(row, col);
            int aboveElement = element - sideSize;
            int belowElement = element + sideSize;
            int leftElement = element - 1;
            int rightElement = element + 1;

            boolean aboveElementNegative = aboveElement < 0;
            boolean belowElementOutOfRange = belowElement > sideSize * sideSize - 1;
            boolean leftStayed = leftElement > 0  && (leftElement % sideSize != leftElement);
            boolean rightStayed = (rightElement < sideSize * sideSize - 1) && rightElement % sideSize != 1;

            if (aboveElementNegative) {
                unionIfOpen(element, virtualSiteA);
            } else {
                unionIfOpen(element, aboveElement);
            }

            if (belowElementOutOfRange) {
                unionIfOpen(element, virtualSiteB);
            } else {
                unionIfOpen(element, belowElement);
            }

            if (leftStayed) {
                unionIfOpen(element, leftElement);
            }

            if (rightStayed) {
                unionIfOpen(element, rightElement);
            }

            sites[element] = 1;
        }
    }

    private void unionIfOpen(int element, int target) {
        if (sites[target] == 1) {
            union.union(element, target);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row <= 0 || col <= 0 || row > sideSize || col > sideSize) {
            throw new IllegalArgumentException("Out of range!");
        }
        int i = unionIndex(row, col);
        return sites[i] == 1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        return !isOpen(row, col);
    }

    private int unionIndex(int row, int col) {
        return (row - 1) * sideSize + col - 1;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        int number = 0;
        for (int s : sites) {
            if (s == 1) {
                number++;
            }
        }

        return number;
    }

    // does the system percolate?
    public boolean percolates() {
        return union.find(virtualSiteA) == union.find(virtualSiteB);
    }


    public static void main(String[] args) {
        Percolation test = new Percolation(5);

        test.open(2, 1);
        test.open(3, 1);
        test.open(3, 2);
        test.open(4, 2);
        System.out.println("persolates? " + test.percolates());
    }
}
