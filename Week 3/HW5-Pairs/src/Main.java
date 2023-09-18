import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Main {
    public static int binarySearch(List<Integer> arr, int number) {
        int left = 0;
        int right = arr.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (number == arr.get(mid))
                return mid;
            else if (number < arr.get(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.size(); i++)
        {
            int ans = binarySearch(arr, arr.get(i) + k);
            if (ans != -1) count++;
        }
        return count;

    }
    public static void main(String[] args) {
        int k = 2;
        List<Integer> arr = Arrays.asList(1, 5, 3, 4, 2);
        int result = pairs(k, arr);
        System.out.print(result);

    }
}