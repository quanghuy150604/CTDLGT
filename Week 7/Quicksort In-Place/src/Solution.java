import java.io.*;
import java.util.*;

public class Solution {

    public static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (a[j] < pivot) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
        }
        int temp = a[i];
        a[i] = a[high];
        a[high] = temp;
        return i;
    }

    public static void sort(int[] a, int low, int high) {
        if (high <= low) return;
        int j = partition(a, low, high);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        sort(a, 0, n - 1);
    }
}