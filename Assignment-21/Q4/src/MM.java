class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    TreeNode(int val) {
        this.val = val;
    }
}

public class MM {
    public void connect(TreeNode root) {
        if (root == null)
            return;

        TreeNode levelStart = root; // The leftmost node of the current level

        while (levelStart != null) {
            TreeNode curr = levelStart;
            TreeNode prev = null; // Previous node of the next level

            // Traverse the current level and update the "next" pointers
            while (curr != null) {
                if (curr.left != null) {
                    if (prev != null)
                        prev.next = curr.left;
                    prev = curr.left;
                }

                if (curr.right != null) {
                    if (prev != null)
                        prev.next = curr.right;
                    prev = curr.right;
                }

                curr = curr.next; // Move to the next node in the current level
            }

            levelStart = getNextLevelStart(levelStart); // Move to the next level
        }
    }

    private TreeNode getNextLevelStart(TreeNode node) {
        // Find the leftmost node of the next level
        if (node.left != null)
            return node.left;
        if (node.right != null)
            return node.right;
        if (node.next != null)
            return getNextLevelStart(node.next);

        return null; // No more levels
    }
}
