public class MM {
    
    public int[] mergeArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] merged = new int[n1 + n2];

        int i = 0; // Pointer for arr1
        int j = 0; // Pointer for arr2
        int k = 0; // Pointer for merged

        // Merge the arrays in sorted order
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }

        // Copy the remaining elements from arr1
        while (i < n1) {
            merged[k++] = arr1[i++];
        }

        // Copy the remaining elements from arr2
        while (j < n2) {
            merged[k++] = arr2[j++];
        }

        return merged;
    }

    public static void main(String[] args) {
        // Example usage
        MM merger = new MM();
        int[] arr1 = {1, 3, 4, 5};
        int[] arr2 = {2, 4, 6, 8};
        int[] merged = merger.mergeArrays(arr1, arr2);
        for (int num : merged) {
            System.out.print(num + " ");
        }
        // Output: 1 2 3 4 4 5 6 8
    }
}
