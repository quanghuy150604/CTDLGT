import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        int[] b = new int[100];
        int size = 1;
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        b[0] = 0;
        for (int i = 0; i < n; i++){
            int old_size = size;
            for (int j = 0; j < old_size; j++){
                b[size] = b[j] + a[i];
                size++;
            }
        }
        for (int i = 1; i < size; i++){
            System.out.print(b[i] + " ");
        }
    }
}