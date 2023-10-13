import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        int temp = arr.get(n - 1);
        for (int i = n - 1; i >= 0; i--) {
            if (i == 0) {
                arr.set(i, temp);
                for (int j = 0; j < n; j++) {
                    System.out.print(arr.get(j) + " ");
                }
                System.out.print("\n");
                break;
            }
            if (arr.get(i - 1) < temp) {
                arr.set(i, temp);
                for (int j = 0; j < n; j++) {
                    System.out.print(arr.get(j) + " ");
                }
                System.out.print("\n");
                break;
            }
            else {
                arr.set(i, arr.get(i - 1));
                for (int j = 0; j < n; j++) {
                    System.out.print(arr.get(j) + " ");
                }
                System.out.print("\n");
            }
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
