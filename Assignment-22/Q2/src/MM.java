class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTreeFlip {
    Node root;

    // Function to perform the flip operation
    Node flipBinaryTree(Node node) {
        // If the current node is null or a leaf node, return it
        if (node == null || isLeaf(node))
            return node;

        // Flip the left and right subtrees recursively
        Node flippedLeft = flipBinaryTree(node.left);
        Node flippedRight = flipBinaryTree(node.right);

        // Flip the current node by swapping its left and right children
        node.left = flippedRight;
        node.right = flippedLeft;

        return node;
    }

    // Function to check if a node is a leaf node
    boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    // Function to print the flipped binary tree (inorder traversal)
    void printFlippedTree(Node node) {
        if (node == null)
            return;

        printFlippedTree(node.left);
        System.out.print(node.data + " ");
        printFlippedTree(node.right);
    }

    public static void main(String[] args) {
        BinaryTreeFlip tree = new BinaryTreeFlip();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Original Binary Tree (Inorder traversal):");
        tree.printFlippedTree(tree.root);

        tree.flipBinaryTree(tree.root);

        System.out.println("\nFlipped Binary Tree (Inorder traversal):");
        tree.printFlippedTree(tree.root);
    }
}
