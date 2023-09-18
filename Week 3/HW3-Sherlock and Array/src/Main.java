import java.util.Scanner;

public class Main {
    public static int Sum(int[] a, int left, int right)
    {
        int sum = 0;
        for (int i = left; i < right; i++)
        {
            sum += a[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        while(T != 0)
        {
            T--;
            int n = input.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = input.nextInt();

            int right = n - 1;
            int left = 0;
            String ans = "NO";

            while (left <= right)
            {
                int mid = left + (right - left) / 2;
                if(Sum(a, 0, mid) == Sum(a, mid + 1, n))
                {
                    ans = "YES";
                    break;
                }
                else if(Sum(a, 0, mid) > Sum(a, mid + 1, n))
                {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            System.out.println(ans);
        }
    }
}