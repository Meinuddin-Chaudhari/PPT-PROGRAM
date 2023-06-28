import java.util.Arrays;

class BinaryTreeCheck {
    boolean checkTree(int[] inorder, int[] preorder, int[] postorder) {
        int n = inorder.length;

        // Base cases
        if (n == 0)
            return true;
        if (n == 1)
            return (inorder[0] == preorder[0]) && (preorder[0] == postorder[0]);

        // Find the root index in inorder traversal
        int rootIndex = -1;
        for (int i = 0; i < n; i++) {
            if (inorder[i] == preorder[0]) {
                rootIndex = i;
                break;
            }
        }

        if (rootIndex == -1)
            return false;

        // Recursively check the left and right subtrees
        boolean leftSubtree = checkTree(
                Arrays.copyOfRange(inorder, 0, rootIndex),
                Arrays.copyOfRange(preorder, 1, rootIndex + 1),
                Arrays.copyOfRange(postorder, 0, rootIndex)
        );

        boolean rightSubtree = checkTree(
                Arrays.copyOfRange(inorder, rootIndex + 1, n),
                Arrays.copyOfRange(preorder, rootIndex + 1, n),
                Arrays.copyOfRange(postorder, rootIndex, n - 1)
        );

        // Return true if both subtrees are valid
        return leftSubtree && rightSubtree;
    }

    public static void main(String[] args) {
        BinaryTreeCheck treeCheck = new BinaryTreeCheck();

        int[] inorder1 = {4, 2, 5, 1, 3};
        int[] preorder1 = {1, 2, 4, 5, 3};
        int[] postorder1 = {4, 5, 2, 3, 1};

        System.out.println("Input 1: ");
        System.out.println("Inorder: " + Arrays.toString(inorder1));
        System.out.println("Preorder: " + Arrays.toString(preorder1));
        System.out.println("Postorder: " + Arrays.toString(postorder1));

        boolean result1 = treeCheck.checkTree(inorder1, preorder1, postorder1);
        System.out.println("Output 1: " + (result1 ? "Yes" : "No"));
        System.out.println();

        int[] inorder2 = {4, 2, 5, 1, 3};
        int[] preorder2 = {1, 5, 4, 2, 3};
        int[] postorder2 = {4, 1, 2, 3, 5};

        System.out.println("Input 2: ");
        System.out.println("Inorder: " + Arrays.toString(inorder2));
        System.out.println("Preorder: " + Arrays.toString(preorder2));
        System.out.println("Postorder: " + Arrays.toString(postorder2));

        boolean result2 = treeCheck.checkTree(inorder2, preorder2, postorder2);
        System.out.println("Output 2: " + (result2 ? "Yes" : "No"));
    }
}
