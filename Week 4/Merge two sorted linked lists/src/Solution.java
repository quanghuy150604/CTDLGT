import java.util.Scanner;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}

public class Solution {
    public static ListNode mergeSortedLists(ListNode headA, ListNode headB) {
        if (headA == null) {
            return headB;
        }
        if (headB == null) {
            return headA;
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (headA != null && headB != null) {
            if (headA.data < headB.data) {
                current.next = headA;
                headA = headA.next;
            } else {
                current.next = headB;
                headB = headB.next;
            }
            current = current.next;
        }

        if (headA != null) {
            current.next = headA;
        } else {
            current.next = headB;
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
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
            ListNode mergedList = mergeSortedLists(headA, headB);
            printList(mergedList);
            System.out.println();
        }

        scanner.close();
    }
}
