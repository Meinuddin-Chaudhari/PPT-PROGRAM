import java.util.Stack;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTreePaths {
    Node root;

    // Function to print all root-to-leaf paths
    void printRootToLeafPaths(Node node) {
        if (node == null)
            return;

        Stack<Node> stack = new Stack<>();
        Stack<String> pathStack = new Stack<>();

        stack.push(node);
        pathStack.push(Integer.toString(node.data));

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            String currentPath = pathStack.pop();

            if (current.left == null && current.right == null) {
                System.out.println(currentPath);
                continue;
            }

            if (current.right != null) {
                stack.push(current.right);
                pathStack.push(currentPath + "->" + current.right.data);
            }

            if (current.left != null) {
                stack.push(current.left);
                pathStack.push(currentPath + "->" + current.left.data);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreePaths tree = new BinaryTreePaths();
        tree.root = new Node(6);
        tree.root.left = new Node(3);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(4);
        tree.root.left.right.left = new Node(7);
        tree.root.left.right.right = new Node(4);

        System.out.println("Root-to-leaf paths:");
        tree.printRootToLeafPaths(tree.root);
    }
}
