package Queries2;

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
            tree[node] = Math.min(tree[2 * node], tree[2 * node + 1]);
        }
    }

    public static int get(int node, int left, int right, int l, int r) {
        if (r < left || l > right) {
            return Integer.MAX_VALUE;
        }
        if (l <= left && r >= right) {
            return tree[node];
        }

        int mid = (left + right) / 2;
        int leftMin = get(2 * node, left, mid, l, r);
        int rightMin = get(2 * node + 1, mid + 1, right, l, r);
        return Math.min(leftMin, rightMin);
    }
    public static void update(int node, int left, int right, int id, int value) {
        if (left == right) {
            arr[id] = value;
            tree[node] = value;
        } else {
            int mid = (left + right) / 2;
            if (id <= mid) {
                update(2 * node, left, mid, id, value);
            } else {
                update(2 * node + 1, mid + 1, right, id, value);
            }
            tree[node] = Math.min(tree[2 * node], tree[2 * node + 1]);
        }
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
            int type = scanner.nextInt();
            if (type == 1) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                System.out.println(get(1, 1, n, l, r));
            } else if (type == 2) {
                int id = scanner.nextInt();
                int x = scanner.nextInt();
                update(1, 1, n, id, x);
            }
        }
    }
}

