package N_BinaryTrees.Part2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import N_BinaryTrees.Part1.TreeNode;

// Given a binary tree, print the top view of it. 
// first we will find the horizontal distance of each node from the root
// simultaneously we will keep track of the nodes at each horizontal distance by using a hashmap
// then we will print the nodes in the hashmap in the order of their horizontal distance
// we will use level order traversal to find the horizontal distance of each node
// if we use dfs we don't know if any node is above or below the current node
public class C_topView {
    static class Info {
        TreeNode node;
        int hd;

        Info(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    static void printTopView(TreeNode root) {
        Info rt = new Info(root, 0);
        HashMap<Integer, Info> map = new HashMap<>();
        map.put(0, rt);
        Queue<Info> q = new LinkedList<>();
        q.add(rt);
        q.add(null);
        int min = 0;
        int max = 0;
        // queue will have elements of each level and one null at the end of each level
        // we will keep track of the horizontal distance of each node from the root
        // if the hd is not present in the map we will add it to the map indicating that
        // it is the first node at that hd
        while (!q.isEmpty()) {
            if (q.peek() == null) {
                break;
            }
            while (q.peek() != null) {
                Info cur = q.remove();

                if (cur.node.left != null) {
                    Info left = new Info(cur.node.left, cur.hd - 1);
                    q.add(left);
                }
                if (cur.node.right != null) {
                    Info right = new Info(cur.node.right, cur.hd + 1);
                    q.add(right);
                }
                if (map.get(cur.hd) == null) {
                    min = Math.min(min, cur.hd);
                    max = Math.max(max, cur.hd);
                    map.put(cur.hd, cur);
                }
            }
            q.remove();
            q.add(null);
        }
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).node.value + " ");
        }
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
        printTopView(root);// 4 2 1 3 7
    }
}
