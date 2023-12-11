package WhoIsInTheMiddle;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Queue<Integer> minPQ = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> maxPQ = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int q = scanner.nextInt();
            if (minPQ.isEmpty() || minPQ.peek() >= q) {
                minPQ.add(q);
            } else {
                maxPQ.add(q);
            }
            if (minPQ.size() > maxPQ.size() + 1) {
                maxPQ.add(minPQ.poll());
            } else if (minPQ.size() < maxPQ.size()) {
                minPQ.add(maxPQ.poll());
            }
        }
        for (int i = 0; i < k; i++) {
            int q = scanner.nextInt();
            switch(q) {
                case 1:
                    int number = scanner.nextInt();
                    if (minPQ.isEmpty() || minPQ.peek() >= number) {
                        minPQ.add(number);
                    } else {
                        maxPQ.add(number);
                    }
                    if (minPQ.size() > maxPQ.size() + 1) {
                        maxPQ.add(minPQ.poll());
                    } else if (minPQ.size() < maxPQ.size()) {
                        minPQ.add(maxPQ.poll());
                    }
                    break;
                case 2:
                    minPQ.poll();
                    if (minPQ.size() > maxPQ.size() + 1) {
                        maxPQ.add(minPQ.poll());
                    } else if (minPQ.size() < maxPQ.size()) {
                        minPQ.add(maxPQ.poll());
                    }
                    break;
                case 3:
                    if (!minPQ.isEmpty()) {
                        System.out.println(minPQ.peek());
                    } else {
                        System.out.println(0);
                    }
                    break;
            }
        }
    }
}
