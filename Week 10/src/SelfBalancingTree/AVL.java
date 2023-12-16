package SelfBalancingTree;

public class AVL {
    public static Node rotateRight(Node node) {
        Node x = node.left;
        Node T2 = x.right;
        x.right = node;
        node.left = T2;
        node.ht = Math.max(height(node.left), height(node.right)) + 1;
        x.ht = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    public static Node rotateLeft(Node node) {
        Node y = node.right;
        Node T2 = y.left;
        y.left = node;
        node.right = T2;
        node.ht = Math.max(height(node.left), height(node.right)) + 1;
        y.ht = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    public static int height(Node node) {
        if (node == null)
            return -1;
        else {
            return node.ht;
        }
    }

    public static int getBalance(Node node) {
        if (node == null) {
            return 0;
        } else {
            return (height(node.left) - height(node.right));
        }
    }
    public static Node insert(Node root, int val) {
        if (root == null) {
            Node node = new Node();
            node.ht = 0;
            node.val = val;
            return node;
        }
        if (val > root.val) {
            root.right = insert(root.right, val);
        } else if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            return root;
        }
        root.ht = Math.max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root);

        if (balance > 1 && val < root.left.val) {
            root = rotateRight(root);
        } else if (balance < -1 && val > root.right.val) {
            root = rotateLeft(root);
        } else if (balance < -1 && val < root.right.val) {
            root.right = rotateRight(root.right);
            root = rotateLeft(root);
        } else if (balance > 1 && val > root.left.val) {
            root.left = rotateLeft(root.left);
            root = rotateRight(root);
        }
        return root;
    }
}
