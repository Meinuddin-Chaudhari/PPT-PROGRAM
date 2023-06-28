public class MM {
    public static int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        
        // Case 1: Maximum subarray sum using Kadane's algorithm
        int maxSum = nums[0];
        int currentMax = nums[0];
        for (int i = 1; i < n; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSum = Math.max(maxSum, currentMax);
        }
        
        // Case 2: Maximum subarray sum with wrapping
        int totalSum = 0;
        int minSum = nums[0];
        int currentMin = nums[0];
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
            currentMin = Math.min(nums[i], currentMin + nums[i]);
            minSum = Math.min(minSum, currentMin);
        }
        
        // If the maximum subarray sum is negative (all elements are negative), return it
        if (maxSum < 0) {
            return maxSum;
        }
        
        // Case 2: Maximum sum = Total sum - Minimum subarray sum
        int maxCircularSum = totalSum - minSum;
        
        // Return the maximum of the two cases
        return Math.max(maxSum, maxCircularSum);
    }
    
    public static void main(String[] args) {
        int[] nums = {1, -2, 3, -2};
        int maxSum = maxSubarraySumCircular(nums);
        System.out.println("Maximum possible sum of a non-empty subarray: " + maxSum);
    }
}
