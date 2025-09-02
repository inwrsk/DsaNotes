package O_BinarySearchTrees.Part1;

import N_BinaryTrees.Part1.TreeNode;

// deleteing a node from a BST
public class deleteNode {
    // inorderSuccessor function finds the smallest value in the right subtree of
    // the node
    public static int inorderSuccessor(TreeNode root, TreeNode rootP) {
        if (root.left == null) {
            int value = root.value;
            if (root.right == null) {
                if (rootP.right == root) {
                    rootP.right = null;
                } else {
                    rootP.left = null;
                }
                return value;
            }
            root.value = root.right.value;
            root.left = root.right.left;
            root.right = root.right.right;
            return value;
        }
        int res = inorderSuccessor(root.left, root);
        return res;
    }

    // taking the current node and the value to be deleted and the parent of the
    // current node (for disconnecting)
    public static TreeNode deleteNode2(TreeNode root, int value, TreeNode rootP) {
        // we reached the end of the tree
        if (root == null) {
            return root;
        }
        // if the value is found
        if (root.value == value) {
            // if the node has right child only
            if (root.left == null && root.right != null) {
                root.value = root.right.value;
                root.left = root.right.left;
                root.right = root.right.right;
                return root;
            }
            // if the node has left child only
            if (root.right == null && root.left != null) {
                root.value = root.left.value;
                root.right = root.left.right;
                root.left = root.left.left;
                return root;
            }
            // if the node has no children
            if (root.right == null && root.left == null) {
                if (rootP == null) {
                    return null;
                }
                if (rootP.right == root) {
                    rootP.right = null;
                } else {
                    rootP.left = null;
                }
                return root;
            }
            // if the node has both children
            // find the inorder successor of the node (next greater element)
            int iS = inorderSuccessor(root.right, root);
            root.value = iS;
        } else if (root.value > value) {// if the value is in the left subtree
            deleteNode2(root.left, value, root);
        } else {// if the value is in the right subtree
            deleteNode2(root.right, value, root);
        }
        return root;
    }
}
