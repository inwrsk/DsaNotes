package O_BinarySearchTrees.Part2;

import N_BinaryTrees.Part1.TreeNode;

import java.util.ArrayList;
import N_BinaryTrees.Part1.A_BuildTree;

// Given a binary search tree, return a balanced binary search tree with the same node values.
// A binary search tree is balanced if and only if the depth of the two subtrees of every node never differ by more than 1.
// now first we will convert the BST to sorted array
// then we will convert the sorted array to BST
public class B_BSTToBalancedBST {

    static void sortedArr(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        sortedArr(root.left, arr);
        arr.add(root.value);
        sortedArr(root.right, arr);
    }

    public static TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        sortedArr(root, arr);
        int[] a = arr.stream().mapToInt(Integer::intValue).toArray();
        return A_SortedArrToBST.constructBST(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        root.right.right.right.right = new TreeNode(5);
        TreeNode newRoot = balanceBST(root);
        A_BuildTree tree = new A_BuildTree();
        tree.levelOrder(newRoot);
        // 3
        // 1 4
        // 2 5
    }
}
