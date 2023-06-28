class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class MM {
    private TreeNode findLCA(TreeNode root, int node1, int node2) {
        if (root == null)
            return null;

        if (root.val > node1 && root.val > node2)
            return findLCA(root.left, node1, node2);

        if (root.val < node1 && root.val < node2)
            return findLCA(root.right, node1, node2);

        return root;
    }

    private int findDistance(TreeNode root, int node) {
        if (root.val == node)
            return 0;

        if (root.val > node)
            return 1 + findDistance(root.left, node);

        return 1 + findDistance(root.right, node);
    }

    public int distanceBetweenNodes(TreeNode root, int node1, int node2) {
        TreeNode lca = findLCA(root, node1, node2);

        int dist1 = findDistance(lca, node1);
        int dist2 = findDistance(lca, node2);

        return dist1 + dist2;
    }
}
