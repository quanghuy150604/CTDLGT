package Query;

import java.util.Scanner;

public class SegmentTree {
    static int[] arr;
    static int[] tree;

    public SegmentTree(int[] arr) {
        this.arr = arr;
        this.tree = new int[4 * arr.length];
        build(1, 1, arr.length - 1);
    }

    private void build(int node, int left, int right) {
        if (left == right) {
            tree[node] = arr[left];
        } else {
            int mid = (left + right) / 2;
            build(2 * node, left, mid);
            build(2 * node + 1, mid + 1, right);
            tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
        }
    }

    public static int get(int node, int left, int right, int l, int r) {
        if (r < left || l > right) {
            return Integer.MIN_VALUE;
        }
        if (l <= left && r >= right) {
            return tree[node];
        }

        int mid = (left + right) / 2;
        int leftMax = get(2 * node, left, mid, l, r);
        int rightMax = get(2 * node + 1, mid + 1, right, l, r);
        return Math.max(leftMax, rightMax);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        SegmentTree segmentTree = new SegmentTree(a);
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(get(1, 1, n, l, r));
        }
    }
}
