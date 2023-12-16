import edu.princeton.cs.algs4.*;

public class UFClient2 {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        int count = 0;

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            count++;

            if (!uf.connected(p, q)) {
                uf.union(p, q);
            }

            boolean isConnected = true;
            int root = uf.find(p);
            for (int i = 0; i < N; i++) {
                if (uf.find(i) != root) {
                    isConnected = false;
                    break;
                }
            }

            if (isConnected) {
                StdOut.println(count);
                return;
            }
        }
        StdOut.println("FAILED");
    }
}