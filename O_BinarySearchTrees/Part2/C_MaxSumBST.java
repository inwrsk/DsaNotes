package O_BinarySearchTrees.Part2;

import N_BinaryTrees.Part1.TreeNode;

// Given a binary tree, find the maximum sum binary search tree in the tree.
// for every node we maintain 4 values:
// 1. sum of the BST till that node
// 2. maximum value in the BST till that node
// 3. minimum value in the BST till that node
// 4. is the tree till that node a BST or not
// all these values are calculated from leaf nodes to root node
// we update the sum if current node is a BST and get best of left and right subtrees if current node is not a BST
public class C_MaxSumBST {
    static class Info {
        int sum;
        int max;
        int min;
        boolean isBST;

        Info(boolean isBST, int sum, int max, int min) {
            this.isBST = isBST;
            this.sum = sum;
            this.max = max;
            this.min = min;
        }
    }

    static Info calculateSum(TreeNode root) {
        if (root == null) {
            Info curInfo = new Info(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
            return curInfo;
        }
        Info lInfo = calculateSum(root.left);
        Info rInfo = calculateSum(root.right);
        boolean curIsBST = lInfo.isBST && rInfo.isBST && (root.value > lInfo.max && root.value < rInfo.min);
        int curSum;
        if (curIsBST) {
            curSum = root.value + lInfo.sum + rInfo.sum;
        } else {
            curSum = Math.max(lInfo.sum, rInfo.sum);
        }
        int curMin = Math.min(lInfo.min, root.value);
        int curMax = Math.max(rInfo.max, root.value);
        Info curInfo = new Info(curIsBST, curSum, curMax, curMin);
        System.out.println(root.value + " " + curInfo.sum + " " + curInfo.isBST);
        return curInfo;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(20);
        root.right = new TreeNode(60);
        root.right.left = new TreeNode(45);
        root.right.right = new TreeNode(70);
        root.right.right.left = new TreeNode(65);
        root.right.right.right = new TreeNode(80);
        System.out.println(calculateSum(root).sum);
    }
}