import java.util.stream.IntStream;

public class QuickUnionUF {

    int[] id;

    QuickUnionUF(int N) {
        id = IntStream.range(0, N - 1).toArray();
    }

    private int root(int i) {
        while (i != this.id[i]) {
            i = this.id[i];
        }

        return i;
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);

        this.id[i] = j;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}
