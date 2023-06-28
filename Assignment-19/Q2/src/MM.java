import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    int count; // Number of smaller elements on the left subtree
    int dup; // Number of duplicates of the current element
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.count = 0;
        this.dup = 1;
    }
}

public class MM {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        TreeNode root = null;
        Integer[] counts = new Integer[nums.length];

        // Traverse the input array from right to left
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, counts, i, 0);
        }

        // Convert the array of counts to a list
        for (int count : counts) {
            result.add(count);
        }

        return result;
    }

    private TreeNode insert(int num, TreeNode node, Integer[] counts, int index, int smallerCount) {
        if (node == null) {
            node = new TreeNode(num);
            counts[index] = smallerCount; // Update the count for the current number
        } else if (node.val == num) {
            node.dup++; // Increment the duplicates count
            counts[index] = smallerCount + node.count; // Update the count for the current number
        } else if (node.val > num) {
            node.count++; // Increment the count for smaller elements on the left subtree
            node.left = insert(num, node.left, counts, index, smallerCount);
        } else {
            node.right = insert(num, node.right, counts, index, smallerCount + node.count + node.dup);
        }
        return node;
    }

    public static void main(String[] args) {
        // Example usage
        MM counter = new MM();
        int[] nums = {5, 2, 6, 1};
        List<Integer> counts = counter.countSmaller(nums);
        System.out.println(counts); // Output: [2, 1, 1, 0]
    }
}
