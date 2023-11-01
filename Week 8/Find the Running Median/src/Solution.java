import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N;
        N = scanner.nextInt();
        Queue<Integer> maxPQ = new PriorityQueue(N / 2 + 1, Collections.reverseOrder());
        Queue<Integer> minPQ = new PriorityQueue(N / 2 + 1);

        for (int i = 0; i < N; i++) {
            int q = scanner.nextInt();
            if (maxPQ.isEmpty() || maxPQ.peek() >= q) {
                maxPQ.add(q);
            } else {
                minPQ.add(q);
            }

            if (maxPQ.size() > minPQ.size() + 1) {
                minPQ.add(maxPQ.poll());
            } else if (maxPQ.size() < minPQ.size()) {
                maxPQ.add(minPQ.poll());
            }

            if (maxPQ.size() == minPQ.size()) {
                System.out.println(maxPQ.peek() / 2.0 + minPQ.peek() / 2.0);
            } else System.out.println(maxPQ.peek());
        }
    }
}
