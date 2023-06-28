import java.util.Arrays;

public class MM {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Initialize each element to 1 (minimum length)

        int maxLen = 1; // Maximum length of the increasing subsequence

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int longestLen = lengthOfLIS(nums);
        System.out.println("Length of Longest Increasing Subsequence: " + longestLen);
    }
}
