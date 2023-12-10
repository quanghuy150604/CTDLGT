package IsThisaBinarySearchTree;

public class Solution {
    void inOrderTraversal(Node root, List<Integer> values) {
        if (root != null) {
            inOrderTraversal(root.left, values);
            values.add(root.data);
            inOrderTraversal(root.right, values);
        }
    }

    boolean checkBST(Node root) {
        List<Integer> values = new ArrayList<>();
        inOrderTraversal(root, values);
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) <= values.get(i - 1)) {
                return false;
            }
        }

        return true;
    }
}
