import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private static final double CONFIDENCE_95 = 1.96;
    private double[] trialResults;
    private int totalTrials;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException("Out of range!");

        totalTrials = trials;
        trialResults = new double[totalTrials];

        for (int i = 0; i < totalTrials; i++) {
            Percolation p = new Percolation(n);

            while (!p.percolates()) {
                int row = StdRandom.uniformInt(1, n + 1);
                int col = StdRandom.uniformInt(1, n + 1);

                p.open(row, col);
            }

            double result = p.numberOfOpenSites();
            trialResults[i] = result;
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(trialResults);
    }
    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(trialResults);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - ((CONFIDENCE_95 * stddev()) / Math.sqrt(totalTrials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + ((CONFIDENCE_95 * stddev()) / Math.sqrt(totalTrials));
    }

    // test client (see below)
    public static void main(String[] args) {
        int gridSize = 10;
        int totalTrials = 10;

        if (args.length >= 2) {
            gridSize = Integer.parseInt(args[0]);
            totalTrials = Integer.parseInt(args[1]);
        }

        PercolationStats ps = new PercolationStats(gridSize, totalTrials);

        String confidence = "[" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]";
        System.out.println("mean                    = " + ps.mean());
        System.out.println("stddev                  = " + ps.stddev());
        System.out.println("95% confidence interval = " + confidence);
    }
}
