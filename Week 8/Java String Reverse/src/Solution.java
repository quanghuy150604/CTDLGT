import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        int left = 0;
        int right = a.length() - 1;

        while (left != right && left < right) {
            if (a.charAt(left) != a.charAt(right)) {
                System.out.println("No");
                return;
            }
            left++;
            right--;
        }
        System.out.println("Yes");
    }
}