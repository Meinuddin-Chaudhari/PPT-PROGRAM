import java.util.Stack;

public class MM {
    public static boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] minValues = new int[n];
        Stack<Integer> stack = new Stack<>();

        minValues[0] = nums[0];

        // Find the minimum value so far for each index
        for (int i = 1; i < n; i++) {
            minValues[i] = Math.min(minValues[i - 1], nums[i]);
        }

        // Iterate from the right end of the array
        for (int j = n - 1; j >= 0; j--) {
            // Check if nums[j] is greater than the minimum value on its left
            if (nums[j] > minValues[j]) {
                // Check if there is a value in the stack that is smaller than nums[j]
                while (!stack.isEmpty() && stack.peek() <= minValues[j]) {
                    stack.pop();
                }

                // Check if the value on top of the stack is smaller than nums[j]
                if (!stack.isEmpty() && stack.peek() < nums[j]) {
                    return true;
                }

                // Push nums[j] to the stack
                stack.push(nums[j]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2};
        boolean containsPattern = find132pattern(nums);
        System.out.println("Contains 132 Pattern: " + containsPattern);
    }
}
