package O_BinarySearchTrees.Part1;

import java.util.ArrayList;
import java.util.List;

import N_BinaryTrees.Part1.TreeNode;

// Given the root of a binary tree, return all root-to-leaf paths in any order.
public class paths {
    public static void paths2(TreeNode root, ArrayList<String> paths, ArrayList<Integer> path) {
        path.add(root.value);
        if (root.left == null && root.right == null) {// if the current node is a leaf node
            StringBuilder newPath = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {// creating the path (string) cur path
                newPath.append(path.get(i));
                newPath.append("->");
            }
            newPath.append(path.get(path.size() - 1));
            paths.add(newPath.toString());// add the path to the paths (collection of paths)
            path.remove(path.size() - 1);// remove the current node from the cur path to move to next node
            return;
        }
        if (root.left == null) {// if only right side path exists
            paths2(root.right, paths, path);
            path.remove(path.size() - 1);
            return;
        }
        if (root.right == null) {// if only left side path exists
            paths2(root.left, paths, path);
            path.remove(path.size() - 1);
            return;
        }
        // if both left and right paths exist
        paths2(root.left, paths, path);
        paths2(root.right, paths, path);
        path.remove(path.size() - 1);// after completing the left and right subtrees remove the current node from the
                                     // cur path to move to next node
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> arr = new ArrayList<>();// to store the paths
        paths2(root, arr, new ArrayList<>());// new ArrayList<>() to store the current path
        return arr;
    }
}
