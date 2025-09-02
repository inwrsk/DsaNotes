package N_BinaryTrees.Part1;

import java.util.*;

public class A_BuildTree {
    TreeNode root = null;
    int height;
    int count;
    int sum;

    A_BuildTree(int[] nodes) {
        root = buildTree(nodes);
        height = calculateHeight(root);
        count = calculateCount(root);
        sum = calculateSum(root);
    }

    public A_BuildTree() {

    }

    // tracks the current value in the nodes[]
    int trackNodes = -1;

    // we are using preorder compatable array nodes
    TreeNode buildTree(int[] nodes) {
        trackNodes++;
        if (nodes[trackNodes] == -1) {
            return null;
        }
        TreeNode node = new TreeNode(nodes[trackNodes]);
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }

    // height(root) = max(leftheight, rightHeight)+1
    static int calculateHeight(TreeNode curNode) {// O(n) as every element touched once
        if (curNode == null) {
            return 0;
        }
        return Math.max(calculateHeight(curNode.left), calculateHeight(curNode.right)) + 1;
    }

    // sum(root) = sum(left)+sum(right)+rootvalue
    static int calculateSum(TreeNode curNode) {// O(n) as every element touched once
        if (curNode == null) {
            return 0;
        }
        return calculateSum(curNode.left) + calculateSum(curNode.right) + curNode.value;
    }

    // count(left)+count(right)+1
    static int calculateCount(TreeNode curNode) {
        if (curNode == null) {
            return 0;
        }
        return calculateCount(curNode.left) + calculateCount(curNode.right) + 1;
    }

    // root, left, right
    void preOrder(TreeNode curNode) {// dfs (we go deep first)//O(n)
        if (curNode == null) {
            System.out.print(-1 + " ");
            return;
        }
        System.out.print(curNode.value + " ");
        preOrder(curNode.left);
        preOrder(curNode.right);
        if (curNode == root) {
            System.out.println();
        }
    }

    // left, root, right
    public void inOrder(TreeNode curNode) {// dfs (we go deep first)//O(n)
        if (curNode == null) {
            System.out.print(-1 + " ");
            return;
        }
        inOrder(curNode.left);
        System.out.print(curNode.value + " ");
        inOrder(curNode.right);
        if (curNode == root) {
            System.out.println();
        }
    }

    // left, right,root
    void postOrder(TreeNode curNode) {// dfs,(O(n))
        if (curNode == null) {
            System.out.print(-1 + " ");
            return;
        }
        postOrder(curNode.left);
        postOrder(curNode.right);
        System.out.print(curNode.value + " ");
        if (curNode == root) {
            System.out.println();
        }
    }

    // level 1, 2, 3, ...
    // add elements at every level to queue
    // after add seperation null
    // add immediate children of every element
    // remove current level elements
    public void levelOrder(TreeNode curNode) {// bfs (going through breadth first) (O(n))
        if (curNode == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(curNode);
        q.add(null);
        while (!q.isEmpty()) {
            if (q.peek() == null) {
                break;
            }
            while (q.peek() != null) {
                TreeNode node = q.remove();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                System.out.print(node.value + " ");
            }
            System.out.println();
            q.remove();
            q.add(null);
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        A_BuildTree tree = new A_BuildTree(nodes);
        System.out.println(tree.root.left.right.value);// 5
        tree.preOrder(tree.root);// 1 2 4 -1 -1 5 -1 -1 3 -1 6 -1 -1
        tree.inOrder(tree.root);// -1 4 -1 2 -1 5 -1 1 -1 3 -1 6 -1
        tree.postOrder(tree.root);// -1 -1 4 -1 -1 5 2 -1 -1 -1 6 3 1
        tree.levelOrder(tree.root);
        // 1
        // 2 3
        // 4 5 6
        System.out.println(tree.height);// 3
        System.out.println(tree.count);// 6
        System.out.println(tree.sum);// 21
    }
}
