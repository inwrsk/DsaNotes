package O_BinarySearchTrees;

public class AVLImplementation {
    public static void main(String[] args) {
        int[] arr = { 40, 20, 10, 25, 30, 22, 50 };
        AVLTree tree = new AVLTree();
        for (int i : arr) {
            tree.root = tree.insert(tree.root, i);
            tree.levelOrder();
            System.out.println("-------------");
        }
        // 40_1
        // -------------
        // 40_2
        // 20_1
        // -------------
        // 20_2
        // 10_1 40_1
        // -------------
        // 20_3
        // 10_1 40_2
        // 25_1
        // -------------
        // 20_3
        // 10_1 30_2
        // 25_1 40_1
        // -------------
        // 25_3
        // 20_2 30_2
        // 10_1 22_1 40_1
        // -------------
        // 25_3
        // 20_2 40_2
        // 10_1 22_1 30_1 50_1
    }
}
