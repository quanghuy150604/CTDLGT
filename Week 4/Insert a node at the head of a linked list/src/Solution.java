import java.util.LinkedList;
import java.util.Scanner;

public class Solution{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < n; i++)
        {
            int input = sc.nextInt();
            list.addFirst(input);
        }
        for(int i = 0; i < n; i++)
        {
            System.out.println(list.get(i));
        }
    }
}
