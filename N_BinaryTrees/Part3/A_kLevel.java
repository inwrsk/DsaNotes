package N_BinaryTrees.Part3;

import N_BinaryTrees.Part1.TreeNode;

// Given a binary tree, print the nodes at k level
// keep in track of level
// if level == k print the node
// we are using dfs 
public class A_kLevel {
    static void print(TreeNode node, int level, int k) {
        if (node == null) {
            return;
        }
        if (level == k) {
            System.out.print(node.value + " ");
            return;
        }
        print(node.left, level + 1, k);
        print(node.right, level + 1, k);
    }

    static void printkLevel(TreeNode root, int k) {
        print(root, 1, k);
    }

    public static void main(String[] args) {
        // 1
        // 2 3
        // 4 5 6 7
        // 8
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        printkLevel(root, 3);// 4 5 6 7
    }
}