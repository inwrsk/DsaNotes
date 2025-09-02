package O_BinarySearchTrees.Part2;

import N_BinaryTrees.Part1.TreeNode;
import N_BinaryTrees.Part1.A_BuildTree;

// sorted array to BST
// for smallest height, we need to take the middle element as root
// then recursively do the same for left and right halves
public class A_SortedArrToBST {
    static TreeNode constructBST(int[] arr, int p, int q) {
        if (p > q) {
            return null;
        }
        int mid = (p + q) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = constructBST(arr, p, mid - 1);
        root.right = constructBST(arr, mid + 1, q);
        return root;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        TreeNode root = constructBST(arr, 0, arr.length - 1);
        A_BuildTree tree = new A_BuildTree();
        tree.inOrder(root);// -1 1 -1 2 -1 3 -1 4 -1 5 -1 6 -1 7 -1
        System.out.println();
        tree.levelOrder(root);
        // 4
        // 2 6
        // 1 3 5 7
    }
}
