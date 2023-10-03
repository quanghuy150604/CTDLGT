import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[10000];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }

            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        long end = System.currentTimeMillis();
        System.out.print("\n" + (end - start));
    }
}