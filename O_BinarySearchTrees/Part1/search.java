package O_BinarySearchTrees.Part1;

import N_BinaryTrees.Part1.TreeNode;

// searching a value in a BST (similar to binary search)
public class search {
    public static boolean search(TreeNode root, int value) {
        if (root == null) {
            return false;
        }
        if (root.value == value) {
            return true;
        }
        if (root.value > value) {
            return search(root.left, value);
        }
        return search(root.right, value);
    }
}
