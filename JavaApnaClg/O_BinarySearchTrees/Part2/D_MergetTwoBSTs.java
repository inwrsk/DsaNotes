package O_BinarySearchTrees.Part2;

import java.util.ArrayList;

import N_BinaryTrees.Part1.TreeNode;

// Given two binary search trees root1 and root2.
// first we will convert the BSTs to sorted arrays
// then we will merge the two sorted arrays
// then we will convert the merged sorted array to BST
public class D_MergetTwoBSTs {
    static void Traverse(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        Traverse(root.left, arr);
        arr.add(root.value);
        Traverse(root.right, arr);
    }

    public static ArrayList<Integer> merge(TreeNode root1, TreeNode root2) {
        // Write your code here
        ArrayList<Integer> arr1 = new ArrayList<>(), arr2 = new ArrayList<>();
        Traverse(root1, arr1);
        Traverse(root2, arr2);
        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0, j = 0;
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) < arr2.get(j)) {
                arr.add(arr1.get(i));
                i++;
                continue;
            }
            arr.add(arr2.get(j));
            j++;
        }
        while (i < arr1.size()) {
            arr.add(arr1.get(i));
            i++;
        }
        while (j < arr2.size()) {
            arr.add(arr2.get(j));
            j++;
        }
        return arr;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(6);
        ArrayList<Integer> sortedArr = merge(root1, root2);
        int[] arr = sortedArr.stream().mapToInt(Integer::intValue).toArray();
        TreeNode root = A_SortedArrToBST.constructBST(arr, 0, arr.length - 1);
        printTree.print(root);// 1 2 3 4 5 6
    }
}
