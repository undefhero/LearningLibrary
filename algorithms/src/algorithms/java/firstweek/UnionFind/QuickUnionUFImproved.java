package java.firstweek.UnionFind;

import java.util.stream.IntStream;

public class QuickUnionUFImproved {

    int[] id;
    int[] sz;

    QuickUnionUFImproved(int N) {
        id = IntStream.range(0, N - 1).toArray();
        sz = new int[N];
    }

    private int root(int i) {
        while (i != this.id[i]) {
            i = this.id[i];
        }

        return i;
    }

    // id smaller tree to id of larger
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);

        if (i == j) return;

        if (sz[i] < sz[j]) {
            this.id[i] = j;
            sz[j] += sz[i];
        } else {
            this.id[j] = i;
            sz[i] += sz[j];
        }
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}
