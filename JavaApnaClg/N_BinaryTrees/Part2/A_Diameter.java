package N_BinaryTrees.Part2;

import N_BinaryTrees.Part1.TreeNode;

//Diameter is the longest path between two nodes in a tree (which may or may not pass through the root)
//those two nodes can be any two nodes in the tree but they will be the leaf nodes
//Height of a node is the longest path from that node to any leaf node
//path is the total number of nodes in the path
//Diameter can be calculated as max(leftDiameter, rightDiameter, leftHeight+rightHeight+1)
public class A_Diameter {
    static int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(calculateHeight(root.left), calculateHeight(root.right));
    }

    // O(n^2) as we are calculating height for each node every time
    static int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int childDiameter = Math.max(diameter(root.left), diameter(root.right));
        int selfDiameter = 1 + calculateHeight(root.left) + calculateHeight(root.right);
        int finalDiameter = Math.max(childDiameter, selfDiameter);
        return finalDiameter;
    }

    static class Info {
        int diameter;
        int height;
    }

    // O(n) as we are calculating height and diameter for each node only once
    static Info diameter2(TreeNode root) {
        Info i = new Info();
        if (root == null) {
            return i;
        }
        Info childLi = diameter2(root.left);
        Info childRi = diameter2(root.right);
        i.height = Math.max(childLi.height, childRi.height) + 1;
        int curDiameter = childLi.height + childRi.height + 1;
        int childDiameter = Math.max(childLi.diameter, childRi.diameter);
        i.diameter = Math.max(curDiameter, childDiameter);
        return i;

    }

    public static void main(String[] args) {
        // 1
        // 2 3
        // 4 5 6 7
        // 8
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        System.out.println(diameter(root));// 6
        System.out.println(diameter2(root).diameter);// 6
        System.out.println(diameter2(root).height);// 4
    }
}
