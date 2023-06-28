public class MM {
    
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;

        while (right < n) {
            // Move the non-zero element to the left side
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }

        // Fill the remaining positions with zeroes
        while (left < n) {
            nums[left] = 0;
            left++;
        }
    }

    public static void main(String[] args) {
        // Example usage
        MM mover = new MM();
        int[] nums = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
        mover.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        // Output: 1 9 8 4 2 7 6 0 0 0 0
    }
}
