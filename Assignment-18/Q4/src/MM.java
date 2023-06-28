import java.util.Arrays;

public class MM {
    public static int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        // Find the minimum and maximum values in the array
        int minNum = nums[0];
        int maxNum = nums[0];
        for (int num : nums) {
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
        }

        // Calculate the size of each bucket
        int bucketSize = Math.max(1, (maxNum - minNum) / (nums.length - 1));

        // Calculate the number of buckets
        int numBuckets = (maxNum - minNum) / bucketSize + 1;

        // Initialize the buckets
        int[][] buckets = new int[numBuckets][2];
        for (int i = 0; i < numBuckets; i++) {
            Arrays.fill(buckets[i], -1);
        }

        // Populate the buckets with minimum and maximum values
        for (int num : nums) {
            int bucketIndex = (num - minNum) / bucketSize;
            if (buckets[bucketIndex][0] == -1) {
                buckets[bucketIndex][0] = num;
                buckets[bucketIndex][1] = num;
            } else {
                buckets[bucketIndex][0] = Math.min(buckets[bucketIndex][0], num);
                buckets[bucketIndex][1] = Math.max(buckets[bucketIndex][1], num);
            }
        }

        // Calculate the maximum difference using adjacent buckets
        int maxDifference = 0;
        int prevMax = minNum;
        for (int i = 0; i < numBuckets; i++) {
            if (buckets[i][0] != -1) {
                maxDifference = Math.max(maxDifference, buckets[i][0] - prevMax);
                prevMax = buckets[i][1];
            }
        }

        return maxDifference;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 1};
        int maxDiff = maximumGap(nums);
        System.out.println("Maximum Difference: " + maxDiff);
    }
}
