package N_BinaryTrees.Part3;

import N_BinaryTrees.Part1.TreeNode;

// Given a binary tree, find the kth ancestor of a given node
// find the path from root to the node
// and find the node at kth position from the node
// approch 2
// first traverse to the node
// while backtracking increment the distance and keep comparing with k
public class D_KthAncestor {
    static int KthAncestor(TreeNode root, TreeNode node, int k, TreeNode res) {
        if (root == null) {
            return -1;
        }
        if (root.value == node.value) {
            if (k == 0) {
                res.value = node.value;
            }
            return 0;
        }
        int left = KthAncestor(root.left, node, k, res);
        if (left != -1) {
            left++;
            if (res.value == -1) {
                if (left == k) {
                    res.value = root.value;
                }
            }
            return left;
        }
        int right = KthAncestor(root.right, node, k, res);
        if (right != -1) {
            right++;
            if (res.value == -1) {
                if (right == k) {
                    res.value = root.value;
                }
            }
            return right;
        }
        return -1;
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
        TreeNode node = root.left.left;
        TreeNode res = new TreeNode(-1);
        KthAncestor(root, node, 2, res);
        System.out.println(res.value);
    }
}
