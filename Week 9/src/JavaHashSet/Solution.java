package JavaHashSet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String firstString = scanner.next();
            String secondString = scanner.next();
            String pair = firstString + "," + secondString;
            set.add(pair);
            System.out.println(set.size());
        }

        scanner.close();
    }
}
