import java.util.*;

class Node {
    int data;
    int horizontalDistance;
    Node left, right;
    
    Node(int value) {
        data = value;
        horizontalDistance = 0;
        left = right = null;
    }
}

class BinaryTreeBottomView {
    Node root;
    
    void bottomView() {
        if (root == null)
            return;
        
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int horizontalDistance = current.horizontalDistance;
            
            // Update the value for each horizontal distance
            map.put(horizontalDistance, current.data);
            
            if (current.left != null) {
                current.left.horizontalDistance = horizontalDistance - 1;
                queue.add(current.left);
            }
            
            if (current.right != null) {
                current.right.horizontalDistance = horizontalDistance + 1;
                queue.add(current.right);
            }
        }
        
        // Print the bottom view nodes
        for (int value : map.values()) {
            System.out.print(value + " ");
        }
    }
    
    public static void main(String[] args) {
        BinaryTreeBottomView tree = new BinaryTreeBottomView();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(3);
        tree.root.right.right = new Node(25);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        
        System.out.print("Bottom View: ");
        tree.bottomView();
    }
}
