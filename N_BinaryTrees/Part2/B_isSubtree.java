package N_BinaryTrees.Part2;

import N_BinaryTrees.Part1.TreeNode;

// Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s.
// corresponding nodes should have same value, left and right child
// first we find the matching root node of t in s
// then we verify every corresponding node of t in s
public class B_isSubtree {
    static boolean verify(TreeNode node1, TreeNode node2) {
        if (node1 == node2) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.value == node2.value && verify(node1.left, node2.left) && verify(node1.right, node2.right);
    }

    static boolean isSubtree(TreeNode node1, TreeNode node2) {
        // find the matching of node2]
        if (node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        return verify(node1, node2) || isSubtree(node1.left, node2) || isSubtree(node1.right, node2);
        // evaluate both trees
    }

    public static void main(String[] args) {
        // 1
        // 2 3
        // 4 5 6 7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);// true
        // root.left.left.left = new TreeNode(8);//false
        root.left.left.left = null;// true

        // 2
        // 4 5
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);
        System.out.println(isSubtree(root, root2));
    }
}
