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

class Result {
    int maxSum;

    public Result() {
        this.maxSum = Integer.MIN_VALUE;
    }
}

class Solution {
    public int findMaxSubtreeSum(TreeNode root) {
        Result result = new Result();
        findMaxSubtreeSumUtil(root, result);
        return result.maxSum;
    }

    private int findMaxSubtreeSumUtil(TreeNode root, Result result) {
        if (root == null)
            return 0;

        int leftSum = findMaxSubtreeSumUtil(root.left, result);
        int rightSum = findMaxSubtreeSumUtil(root.right, result);

        int currentSum = root.val + leftSum + rightSum;
        result.maxSum = Math.max(result.maxSum, currentSum);

        return currentSum;
    }
}

public class MM {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();
        int maxSubtreeSum = solution.findMaxSubtreeSum(root);
        System.out.println("Maximum Subtree Sum: " + maxSubtreeSum);
    }
}
