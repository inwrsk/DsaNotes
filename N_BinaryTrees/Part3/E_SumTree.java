package N_BinaryTrees.Part3;

import N_BinaryTrees.Part1.TreeNode;
import java.util.*;

// Given a binary tree, convert it to a sum tree
// where the value of a node is the sum of the left and right subtree
public class E_SumTree {
    // level order traversal to print the tree
    static void printLevel(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            if (q.peek() == null) {
                break;
            }
            while (q.peek() != null) {
                TreeNode cur = q.remove();
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
                System.out.print(cur.value + " ");
            }
            q.remove();
            System.out.println();
            q.add(null);
        }
    }

    static int sumTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftsum = sumTree(root.left);
        int rightsum = sumTree(root.right);
        int nodeValue = root.value;
        root.value = leftsum + rightsum;
        return nodeValue + root.value;
    }

    public static void main(String[] args) {
        // 1
        // 2 3
        // 4 5 6 7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        sumTree(root);
        printLevel(root);
        // 27
        // 9 13
        // 0 0 0 0
    }
}
