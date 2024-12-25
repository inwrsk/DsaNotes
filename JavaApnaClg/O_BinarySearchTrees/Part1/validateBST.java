package O_BinarySearchTrees.Part1;

import N_BinaryTrees.Part1.TreeNode;

// see if every node is following the BST property
// left child should be smaller than the root and right child should be greater than the root
// for root it can be -inf to +inf
// for left child it can be -inf to root
// for right child it can be root to +inf
// similary for each subtree
public class validateBST {
    public static boolean isBst2(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.value <= min.value) {
            return false;
        }
        if (max != null && root.value >= max.value) {
            return false;
        }
        return isBst2(root.left, min, root) && isBst2(root.right, root, max);
    }
}
