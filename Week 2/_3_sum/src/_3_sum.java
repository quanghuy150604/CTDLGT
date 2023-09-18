import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class _3_sum {
    public static void main(String[] args) {
        In in = new In("D:\\Codeeeee\\algs4-data\\1Kints.txt");
        int[] a = in.readAllInts();

        Arrays.sort(a);

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                for (int k = j + 1; k < a.length; k++) {
                    if (a[j] + a[i] + a[k] == 0) {
                        StdOut.println(a[i] + " " + a[j] + " " + a[k]);
                    }
                }
            }
        }
    }
}
