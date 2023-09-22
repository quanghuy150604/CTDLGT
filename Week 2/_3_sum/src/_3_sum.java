import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class _3_sum {
    public static void main(String[] args) {
        In in = new In("D:\\Codeeeee\\algs4-data\\1Kints.txt");
        int[] a = in.readAllInts();

        Arrays.sort(a);

        for (int i = 0; i < a.length - 2; i++) {
            int j = i + 1;
            for (int k = a.length - 1; k >= i + 1; k--){
                while (j < k){
                    if (a[i] + a[j] + a[k] == 0){
                        System.out.println(a[i] + " " + a[j] + " " + a[k]);
                        j++;
                    }
                    else if (a[i] + a[j] + a[k] < 0){
                        j++;
                    }
                    else if (a[i] + a[j] + a[k] > 0){
                        break;
                    }
                }
            }
        }
    }
}
