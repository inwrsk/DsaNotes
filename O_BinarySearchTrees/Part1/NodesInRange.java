package O_BinarySearchTrees.Part1;

import N_BinaryTrees.Part1.TreeNode;

// printing the nodes in the range of low and high
public class NodesInRange {
    public static void NodesInRange(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        // code here.
        // if root is in range then nodes can be in left or right subtree
        if (root.value >= low && root.value <= high) {
            NodesInRange(root.left, low, high);
            System.out.print(root.value + "-");
            NodesInRange(root.right, low, high);
        }
        if (root.value > high) {// if root is higher than high then nodes can be in left subtree
            NodesInRange(root.left, low, high);
        }
        if (root.value < low) {// if root is lower than low then nodes can be in right subtree
            NodesInRange(root.right, low, high);
        }
        return;
    }
}
