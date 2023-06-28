import java.util.*;

class Node {
    int data;
    Node left, right;
    
    Node(int value) {
        data = value;
        left = right = null;
    }
}

class BinaryTreeLeftView {
    Node root;
    
    void leftView() {
        if (root == null)
            return;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                
                // Print the leftmost node of each level
                if (i == 0)
                    System.out.print(current.data + " ");
                
                if (current.left != null)
                    queue.add(current.left);
                
                if (current.right != null)
                    queue.add(current.right);
            }
        }
    }
    
    public static void main(String[] args) {
        BinaryTreeLeftView tree = new BinaryTreeLeftView();
        tree.root = new Node(4);
        tree.root.left = new Node(5);
        tree.root.right = new Node(2);
        tree.root.right.left = new Node(3);
        tree.root.right.right = new Node(1);
        tree.root.right.left.left = new Node(6);
        tree.root.right.left.right = new Node(7);
        
        System.out.print("Left View: ");
        tree.leftView();
    }
}
