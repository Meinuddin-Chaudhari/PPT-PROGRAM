public class MM {
    public static void sortColors(int[] nums) {
        int low = 0;        // Pointer for red color (0)
        int high = nums.length - 1;  // Pointer for blue color (2)
        int current = 0;    // Pointer for current element

        while (current <= high) {
            if (nums[current] == 0) {
                // Swap current element with the element at the low pointer
                swap(nums, current, low);
                current++;
                low++;
            } else if (nums[current] == 2) {
                // Swap current element with the element at the high pointer
                swap(nums, current, high);
                high--;
            } else {
                current++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);

        // Print the sorted array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
