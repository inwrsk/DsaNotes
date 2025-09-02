package O_BinarySearchTrees.Part2;

import N_BinaryTrees.Part1.TreeNode;

public class printTree {
    static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        print(root.left);
        System.out.print(root.value + " ");
        print(root.right);
    }
}
