import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Percolation {
    WeightedQuickUnionUF union;
    int[] sites;
    int sideSize;
    int virtualSites;
    int virtualSiteA;
    int virtualSiteB;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        sideSize = n;
        sites = new int[n * n];
        virtualSites = 2;
        virtualSiteA = n * n;
        virtualSiteB = n * n + 1;

        union = new WeightedQuickUnionUF(n * n + virtualSites);

        System.out.println(union);
        System.out.println(virtualSiteA);
        System.out.println(virtualSiteB);

        // connect with virtualSites

        for (int i = 0; i < n; i++) {
            union.union(i, virtualSiteA);
            union.union(n * (n - 1) + i, virtualSiteB);
        }

        System.out.println(union.count());
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        System.out.println();

        if (isOpen(row, col)) {
            union.union(row, col);
            int i = unionIndex(row, col);
            sites[i] = 1;
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        int i = unionIndex(row, col);
        return sites[i] == 1;
    }

    private int unionIndex(int row, int col) {
        return (row - 1) * sideSize + col - 1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        int i = unionIndex(row, col);
        return sites[i] == 0;
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

    public void print() {
        for (int s : sites) System.out.print(s);
        System.out.println("");
    }

    public static void main(String[] args) {
        Percolation percolation = new Percolation(5);
        percolation.print();

        percolation.open(1, 2);
        percolation.open(2, 2);
        percolation.open(3, 2);
        percolation.open(4, 2);
        percolation.print();

        percolation.open(5, 2);
        percolation.print();

        System.out.println(percolation.percolates());
    }
}
