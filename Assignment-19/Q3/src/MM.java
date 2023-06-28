public class MM {
    
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        for (int m = left; m <= right; m++) {
            nums[m] = temp[m - left];
        }
    }

    public static void main(String[] args) {
        // Example usage
        MM sorter = new MM();
        int[] nums = {5, 2, 6, 1, 3};
        int[] sortedNums = sorter.sortArray(nums);
        for (int num : sortedNums) {
            System.out.print(num + " ");
        }
        // Output: 1 2 3 5 6
    }
}
