package O_BinarySearchTrees;

public class AVLNode {
    int data;
    int height;
    AVLNode left;
    AVLNode right;

    AVLNode(int data) {
        this.data = data;
        height = 1;
    }
}
