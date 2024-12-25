package O_BinarySearchTrees.Part1;

import N_BinaryTrees.Part1.TreeNode;

// to mirror the tree we swap the left and right child of each node
public class invertTree {
    public static TreeNode invertTree(TreeNode node) {
        if (node == null) {
            return node;
        }
        TreeNode temp = node.right;
        node.right = node.left;
        node.left = temp;
        invertTree(node.left);
        invertTree(node.right);
        return node;
    }
}
