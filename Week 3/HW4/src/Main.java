import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Main {
    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        int min = Integer.MAX_VALUE;
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i < arr.size(); i++) {
            int absDiff = Math.abs(arr.get(i) - arr.get(i - 1));
            if (absDiff < min) {
                min = absDiff;
                result.clear();
                result.add(arr.get(i - 1));
                result.add(arr.get(i));
            } else if (absDiff == min) {
                result.add(arr.get(i - 1));
                result.add(arr.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(4, 2, 1, 3);
        List<Integer> result = closestNumbers(arr);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}