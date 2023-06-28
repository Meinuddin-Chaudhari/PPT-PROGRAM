class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class DoublyLinkedListNode {
    int val;
    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;

    DoublyLinkedListNode(int val) {
        this.val = val;
    }
}

public class MM {
    private DoublyLinkedListNode prev = null;

    public DoublyLinkedListNode convertToDoublyLinkedList(TreeNode root) {
        if (root == null)
            return null;

        DoublyLinkedListNode head = convertToDoublyLinkedListHelper(root);

        // Find the head of the doubly linked list (leftmost node)
        while (head.prev != null)
            head = head.prev;

        return head;
    }

    private DoublyLinkedListNode convertToDoublyLinkedListHelper(TreeNode root) {
        if (root == null)
            return null;

        // Convert the left subtree
        DoublyLinkedListNode left = convertToDoublyLinkedListHelper(root.left);

        // Create a new doubly linked list node for the current root
        DoublyLinkedListNode current = new DoublyLinkedListNode(root.val);

        // Set the previous pointer of the current node
        current.prev = prev;

        // Set the next pointer of the previous node (if exists)
        if (prev != null)
            prev.next = current;

        // Update the previous node to the current node
        prev = current;

        // Convert the right subtree
        DoublyLinkedListNode right = convertToDoublyLinkedListHelper(root.right);

        // Set the next pointer of the current node
        current.next = right;

        return left != null ? left : current;
    }
}
