import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int binarySearch(int[] a, int number) {
        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (number == a[mid])
                return mid;
            else if (number < a[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = input.nextInt();
        System.out.println("Enter the elements of the array: ");
        int[] a = new int[1000];
        for (int i = 0; i < n; i++)
            a[i] = input.nextInt();

        System.out.println("Enter the number you want to search: ");
        int number = input.nextInt();

        Arrays.sort(a);

        int output = binarySearch(a, number);
        if (output == -1) {
            System.out.println("Number's location: Can not find");
        } else {
            System.out.println("Number's location: " + output);
        }
    }
}