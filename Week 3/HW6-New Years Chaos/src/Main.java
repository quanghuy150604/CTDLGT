import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int count = 0;

        for (int i = 0; i < q.size(); i++) {
            if (q.get(i) - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }

            for (int j = Math.max(0, q.get(i) - 2); j < i; j++) {
                if (q.get(j) > q.get(i)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        for (int testCase = 0; testCase < t; testCase++) {
            int n = scanner.nextInt(); // Number of people in the queue
            List<Integer> q = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                q.add(scanner.nextInt()); // Read the final state of the queue
            }

            minimumBribes(q);
        }

    }
}