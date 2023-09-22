import java.util.Scanner;
public class Practice {
    public static int[] root = new int[10000];
    public static int getroot(int x) {
        if (root[x] < 0) return x;
        return root[x] = getroot(root[x]);
    }
    public static void main(String[] args)
    {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int res = n;
        for (int i = 0; i < n; i++) {
            root[i] = -1;
        }

        while(stdin.hasNextInt())
        {
            int x, y;
            x = stdin.nextInt();
            y = stdin.nextInt();
            x = getroot(x);
            y = getroot(y);
            if (x != y) {
                --res;
                if (-root[x] > -root[y]) {
                    root[y] -= root[x];
                    root[x] = y;
                } else {
                    root[x] -= root[y];
                    root[y] = x;
                }
            }
        }
        System.out.println(res);
    }
}
