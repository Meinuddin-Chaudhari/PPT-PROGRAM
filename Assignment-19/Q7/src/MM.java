import java.util.*;

public class MM {
    
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersectionSet = new HashSet<>();

        // Add elements of nums1 to the set
        for (int num : nums1) {
            set.add(num);
        }

        // Find the common elements between nums1 and nums2
        for (int num : nums2) {
            if (set.contains(num)) {
                intersectionSet.add(num);
            }
        }

        // Convert the intersection set to an array
        int[] intersection = new int[intersectionSet.size()];
        int index = 0;
        for (int num : intersectionSet) {
            intersection[index++] = num;
        }

        return intersection;
    }

    public static void main(String[] args) {
        // Example usage
        MM arrayIntersection = new MM();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] intersection = arrayIntersection.intersection(nums1, nums2);
        for (int num : intersection) {
            System.out.print(num + " ");
        }
        // Output: 2
    }
}
