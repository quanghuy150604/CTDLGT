package Tree_Preorder_Traversal;

import java.util.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

/* you only have to complete the function given below.  
Tree_Preorder_Traversal.Node is defined as

class Tree_Preorder_Traversal.Node {
    int data;
    Tree_Preorder_Traversal.Node left;
    Tree_Preorder_Traversal.Node right;
}

*/

    public static void preOrder(Node root) {
        System.out.print(root.data + " ");
        if (root.left == null) {
            if (root.right != null) {
                preOrder(root.right);
            }
        } else {
            preOrder(root.left);
            if (root.right != null) {
                preOrder(root.right);
            }
        }

    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
    }
}