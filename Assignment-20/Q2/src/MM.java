class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    public TreeNode constructBST(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;

        return constructBSTUtil(arr, 0, arr.length - 1);
    }

    private TreeNode constructBSTUtil(int[] arr, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(arr[mid]);

        root.left = constructBSTUtil(arr, start, mid - 1);
        root.right = constructBSTUtil(arr, mid + 1, end);

        return root;
    }
}

public class MM {
    public static void main(String[] args) {
        int[] arr = {7, 4, 12, 3, 6, 8, 1, 5, 10};

        Solution solution = new Solution();
        TreeNode root = solution.constructBST(arr);

        // Print the constructed BST
        printBST(root);
    }

    public static void printBST(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        printBST(root.left);
        printBST(root.right);
    }
}
