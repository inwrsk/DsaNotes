package O_BinarySearchTrees;

import java.util.*;

// code for AVL Tree
// AVL Tree is a self-balancing Binary Search Tree where the difference between heights of left and right subtrees cannot be more than one for all nodes.
// if we add 1,2,3,4,5,6,7,8,9 in a BST, it will become a linear tree, which is not good for searching, so we need to balance the tree.
// avl tree balances itself after every insertion or deletion.
// in this code, we are balancing the tree after every insertion.
//refer notes for better understanding
public class AVLTree {
    AVLNode root;

    // useful when we need to get the height of a random node
    int height(AVLNode root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    // get the balance factor of a node (should be -1, 0 or 1)
    int getBalance(AVLNode root) {
        return height(root.left) - height(root.right);
    }

    AVLNode rotateRight(AVLNode Temproot) {
        AVLNode newRoot = Temproot.left;
        Temproot.left = newRoot.right;
        newRoot.right = Temproot;
        Temproot.height = 1 + Math.max(height(Temproot.left), height(Temproot.right));
        newRoot.height = 1 + Math.max(height(newRoot.left), height(newRoot.right));
        return newRoot;
    }

    AVLNode rotateLeft(AVLNode Temproot) {
        AVLNode newRoot = Temproot.right;
        Temproot.right = newRoot.left;
        newRoot.left = Temproot;
        Temproot.height = 1 + Math.max(height(Temproot.left), height(Temproot.right));
        newRoot.height = 1 + Math.max(height(newRoot.left), height(newRoot.right));
        return newRoot;

    }

    // for printing the tree level by level
    void levelOrder() {
        if (root == null) {
            return;
        }
        Queue<AVLNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            if (q.peek() == null) {
                break;
            }
            while (q.peek() != null) {
                AVLNode node = q.remove();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                System.out.print(node.data + "_" + node.height + " ");
            }
            System.out.println();
            q.remove();
            q.add(null);
        }
    }

    // insert a node in the AVL Tree
    AVLNode insert(AVLNode root, int key) {
        // insertion process is same as BST
        if (root == null) {
            return new AVLNode(key);
        }
        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        } else {
            return root;
        }
        // the core logic will start while backtracking
        // after insertion, we are now just above the node where we inserted the new
        // node and we need to balance the tree from here
        // update the height of the current node
        root.height = 1 + Math.max(height(root.left), height(root.right));
        int bf = getBalance(root);
        if (bf > 1) {// left heavy
            if (key > root.left.data) {// left-right case
                root.left = rotateLeft(root.left);
            }
            return rotateRight(root);// left-left case
        }
        if (bf < -1) {// right heavy
            if (key < root.right.data) {// right-left case
                root.right = rotateRight(root.right);
            }
            return rotateLeft(root);// right-right case
        }
        return root;
    }

}