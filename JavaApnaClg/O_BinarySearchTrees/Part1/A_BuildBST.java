package O_BinarySearchTrees.Part1;

import N_BinaryTrees.Part1.TreeNode;

import N_BinaryTrees.Part1.A_BuildTree;

// a tree is a binary search tree if all the left children are smaller than the root and all the right children are
public class A_BuildBST {
    // putting the value in the correct place (O(logn)) average case
    public static TreeNode buildBST(TreeNode root, int value) {
        TreeNode newNode = new TreeNode(value);
        if (root == null) {
            return newNode;
        }
        if (value < root.value) {
            root.left = buildBST(root.left, value);
        } else {
            root.right = buildBST(root.right, value);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] values = { 5, 1, 3, 4, 2, 7 };
        TreeNode root = null;
        for (int i : values) {
            root = buildBST(root, i);
        }
        A_BuildTree tree = new A_BuildTree();
        tree.levelOrder(root);
        // 5
        // 1 7
        // 3
        // 2 4
        tree.inOrder(root);// -1 1 -1 2 -1 3 -1 4 -1 5 -1 7 -1
        System.out.println();
        // -1 represents null
        // all the elements in sorted order in inorder 1 2 3 4 5 7
        System.out.println(search.search(root, 0));// false
        System.out.println(search.search(root, 2));// true
        root = deleteNode.deleteNode2(root, 1, null);
        tree.levelOrder(root);
        // 5
        // 3 7
        // 2 4
        tree.inOrder(root);
        // -1 2 -1 3 -1 4 -1 5 -1 7 -1
        System.out.println();
        NodesInRange.NodesInRange(root, 3, 6);// 3-4-5-
        System.out.println();
        System.out.println(paths.binaryTreePaths(root));// [5->3->2, 5->3->4, 5->7]
        System.out.println(validateBST.isBst2(root, null, null));// true
    }
}
