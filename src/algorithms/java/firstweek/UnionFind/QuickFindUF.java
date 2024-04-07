package java.firstweek.unionfind;

import java.util.Arrays;
import java.util.stream.IntStream;

public class QuickFindUF {
    int[] unions;

    QuickFindUF(int N) {
        unions = IntStream.range(0, N - 1).toArray();
    }

    void union(int p, int q) {
        int pid = this.unions[p];
        int qid = this.unions[q];

        for (int i = 0; i < this.unions.length; i++) {
            if (this.unions[i] == pid) {
                this.unions[i] = qid;
            }
        }
    }
    boolean connected(int p, int q) {
        return this.unions[p] == this.unions[q];
    }

    void print() {
        Arrays.stream(this.unions).forEach(e -> System.out.println(e));
    }
}
