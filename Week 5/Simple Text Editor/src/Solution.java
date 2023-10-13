import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int q = input.nextInt();

        Stack<Integer> first = new Stack<>();
        Stack<Integer> second = new Stack<>();

        for (int i = 0; i < q; i++){
            int type = input.nextInt();

            if (type == 1) {
                int x = input.nextInt();
                first.push(x);
            }
            else if (type == 2) {
                if (second.isEmpty()) {
                    while (!first.isEmpty()) {
                        second.push(first.pop());
                    }
                }
                if (!second.isEmpty()) {
                    second.pop();
                }
            }
            else if (type == 3) {
                if (second.isEmpty()) {
                    while (!first.isEmpty()) {
                        second.push(first.pop());
                    }
                }
                if (!second.isEmpty()) {
                    System.out.println(second.peek());
                }
            }
        }
    }
}
