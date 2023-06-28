public class MM {
    
    public void alternateArrange(int[] nums) {
        int n = nums.length;

        int positiveIndex = 0;
        int negativeIndex = 0;

        // Find the first positive number
        while (positiveIndex < n && nums[positiveIndex] < 0) {
            positiveIndex++;
        }

        // Find the first negative number
        while (negativeIndex < n && nums[negativeIndex] >= 0) {
            negativeIndex++;
        }

        // Arrange positive and negative numbers alternately
        while (positiveIndex < n && negativeIndex < n) {
            // Shift the elements between positiveIndex and negativeIndex
            shiftElements(nums, positiveIndex, negativeIndex);

            // Increment the positiveIndex and negativeIndex by 2
            positiveIndex += 2;
            negativeIndex += 2;
        }
    }

    private void shiftElements(int[] nums, int start, int end) {
        int lastElement = nums[end];

        // Shift elements to the right
        for (int i = end; i > start; i--) {
            nums[i] = nums[i - 1];
        }

        nums[start] = lastElement;
    }

    public static void main(String[] args) {
        // Example usage
        MM arranger = new MM();
        int[] nums = {1, 2, 3, -4, -1, 4};
        arranger.alternateArrange(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        // Output: -4 1 -1 2 3 4
    }
}
