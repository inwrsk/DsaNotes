package N_BinaryTrees.Part3;

import N_BinaryTrees.Part1.TreeNode;

// Given a binary tree, find the minimum distance between two nodes
// find the least common ancestor of the two nodes
// calculate the distance of the two nodes from the common ancestor
public class C_minDistance {
    static int CalculateDistance(TreeNode root, TreeNode node) {
        if (root == null) {
            return 0;
        }
        if (root.value == node.value) {
            return 1;
        }
        int n = Math.max(CalculateDistance(root.left, node), CalculateDistance(root.right, node));
        return n == 0 ? 0 : n + 1;
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
        TreeNode node2 = root.left.right;// 2+1
        // TreeNode node2 = root.right.right;// 3+2
        TreeNode lca = B_LowestCommonAncestor.lca2(root, node1, node2);
        int dNode1 = CalculateDistance(lca, node1) - 1;
        int dNode2 = CalculateDistance(lca, node2) - 1;
        System.out.println(dNode1 + "+" + dNode2);
    }
}