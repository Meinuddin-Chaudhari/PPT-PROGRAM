class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTreeToDLL {
    Node root;
    Node head; // Head of the doubly linked list

    // Helper function to concatenate two doubly linked lists
    Node concatenate(Node leftList, Node rightList) {
        // If either of the lists is empty, return the other list
        if (leftList == null)
            return rightList;
        if (rightList == null)
            return leftList;

        // Store the last nodes of both lists
        Node leftLast = leftList.left;
        Node rightLast = rightList.left;

        // Connect the last node of the left list with the first node of the right list
        leftLast.right = rightList;
        rightList.left = leftLast;

        // Connect the last node of the right list with the head of the left list
        leftList.left = rightLast;
        rightLast.right = leftList;

        return leftList;
    }

    // Function to convert binary tree to doubly linked list
    Node convertToDLL(Node node) {
        if (node == null)
            return null;

        // Convert the left subtree and the right subtree to DLLs
        Node leftList = convertToDLL(node.left);
        Node rightList = convertToDLL(node.right);

        // Make the current node a single node doubly linked list
        node.left = node.right = node;

        // Concatenate the leftList, current node, and rightList
        Node result = concatenate(concatenate(leftList, node), rightList);

        // Update the head of the doubly linked list
        if (head == null)
            head = result;

        return result;
    }

    // Function to print the doubly linked list
    void printList(Node head) {
        Node current = head;

        System.out.println("Doubly Linked List:");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryTreeToDLL tree = new BinaryTreeToDLL();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);

        // Convert the binary tree to doubly linked list
        tree.convertToDLL(tree.root);

        // Print the doubly linked list
        tree.printList(tree.head);
    }
}
