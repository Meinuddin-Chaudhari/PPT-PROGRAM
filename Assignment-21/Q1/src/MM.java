import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class MM {
    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }

    private TreeNode buildBST(List<Integer> values) {
        return buildBST(values, 0, values.size() - 1);
    }

    private TreeNode buildBST(List<Integer> values, int start, int end) {
        if (start > end)
            return null;

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(values.get(mid));
        root.left = buildBST(values, start, mid - 1);
        root.right = buildBST(values, mid + 1, end);
        return root;
    }

    public TreeNode convertToBST(TreeNode root) {
        if (root == null)
            return null;

        List<Integer> values = inorderTraversal(root);
        return buildBST(values);
    }
}
