package N_BinaryTrees.Part3;

import java.util.Stack;

import N_BinaryTrees.Part1.TreeNode;
// Given a binary tree, find the lowest common ancestor of two given nodes in the tree.
// it is the junction point of the two nodes in their journey to root

public class B_LowestCommonAncestor {
    static void path(TreeNode root, TreeNode node, Stack<Integer> path) {
        if (root == null) {
            return;
        }
        if (root.value == node.value) {
            path.push(root.value);
            return;
        }
        path(root.left, node, path);
        if (!path.isEmpty()) {
            path.push(root.value);
            return;
        }
        path(root.right, node, path);
        if (!path.isEmpty()) {
            path.push(root.value);
            return;
        }
    }

    // first approach
    // find the individual paths from root to node1 and node2
    // compare the paths and return the junction point
    static int lcf(TreeNode root, TreeNode node1, TreeNode node2) {
        Stack<Integer> path1 = new Stack<>();
        path(root, node1, path1);
        Stack<Integer> path2 = new Stack<>();
        path(root, node2, path2);
        int track = -1;
        while (!path1.isEmpty() && !path2.isEmpty()) {
            if (path1.peek() == path2.peek()) {
                track = path1.pop();
                path2.pop();
                continue;
            }
            return track;
        }
        return track;
    }

    // given that node1 and node2 exists in the tree
    // second approach
    // checking if node belongs to the left or right subtree
    // if both belongs to different subtrees then root is the lca
    // if both belongs to the same subtree then the lca is in that subtree
    public static TreeNode lca2(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || root.value == node1.value || root.value == node2.value) {
            return root;
        }
        TreeNode left = lca2(root.left, node1, node2);
        TreeNode right = lca2(root.right, node1, node2);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
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
        TreeNode node1 = root.left.left.left;
        TreeNode node2 = root.left.right;
        System.out.println(lcf(root, node1, node2));// 2
        System.out.println(lcf(root, node1, root.right.right));// 1
        TreeNode temp = new TreeNode(0);
        System.out.println(lcf(root, node1, temp));// -1
        System.out.println("lca2 : " + lca2(root, node1, node2).value);// 2
    }
}