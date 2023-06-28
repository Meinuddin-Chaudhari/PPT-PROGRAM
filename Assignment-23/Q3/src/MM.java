import java.util.*;

class Node {
    int data;
    Node left, right;
    
    Node(int value) {
        data = value;
        left = right = null;
    }
}

class BinaryTreeRightView {
    Node root;
    
    void rightView() {
        if (root == null)
            return;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                
                // Print the rightmost node of each level
                if (i == size - 1)
                    System.out.print(current.data + " ");
                
                if (current.left != null)
                    queue.add(current.left);
                
                if (current.right != null)
                    queue.add(current.right);
            }
        }
    }
    
    public static void main(String[] args) {
        BinaryTreeRightView tree = new BinaryTreeRightView();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.right.right = new Node(8);
        
        System.out.print("Right View: ");
        tree.rightView();
    }
}
