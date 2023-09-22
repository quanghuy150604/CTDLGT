import java.util.Arrays;
import edu.princeton.cs.algs4.*;

public class Main {
    public static int binarySearch(int[] a, int left, int right, int number) {

//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//
//            if (number == a[mid])
//                return mid;
//            else if (number < a[mid]) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return -1;
        while (right - left > 1){
            int mid = left + (right -left) / 2;

            if (a[mid] >= number){
                right = mid;
            }
            else{
                left = mid;
            }
            if( a[right] == number){
                return right;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        In in = new In("D:\\Codeeeee\\algs4-data\\1Kints.txt");
        int[] a = in.readAllInts();

        Arrays.sort(a);

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int check = binarySearch(a, j + 1, a.length - 1, -(a[i] + a[j]));
                if (check != -1)
                    System.out.println(a[i] + " " + a[j] + " " + a[check]);
            }
        }

    }
}