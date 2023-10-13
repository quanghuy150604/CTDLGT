import java.util.Scanner;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}

public class Solution {
    public static int compareLists(ListNode headA, ListNode headB) {
        while (headA != null && headB != null) {
            if (headA.data != headB.data) {
                return 0;
            }
            headA = headA.next;
            headB = headB.next;
        }

        if (headA == null && headB == null) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();

        for (int t = 0; t < numTestCases; t++) {
            int sizeA = scanner.nextInt();
            ListNode headA = null;
            ListNode tailA = null;

            for (int i = 0; i < sizeA; i++) {
                int data = scanner.nextInt();
                ListNode newNode = new ListNode(data);
                if (headA == null) {
                    headA = newNode;
                    tailA = newNode;
                } else {
                    tailA.next = newNode;
                    tailA = newNode;
                }
            }

            int sizeB = scanner.nextInt();
            ListNode headB = null;
            ListNode tailB = null;

            for (int i = 0; i < sizeB; i++) {
                int data = scanner.nextInt();
                ListNode newNode = new ListNode(data);
                if (headB == null) {
                    headB = newNode;
                    tailB = newNode;
                } else {
                    tailB.next = newNode;
                    tailB = newNode;
                }
            }

            int result = compareLists(headA, headB);
            System.out.println(result);
        }

        scanner.close();
    }
}