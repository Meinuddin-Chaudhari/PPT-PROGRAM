import java.util.*;

public class MM {
    
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer> intersectionList = new ArrayList<>();

        // Count the frequency of elements in nums1
        for (int num : nums1) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Find the common elements and update their frequencies
        for (int num : nums2) {
            if (frequencyMap.containsKey(num) && frequencyMap.get(num) > 0) {
                intersectionList.add(num);
                frequencyMap.put(num, frequencyMap.get(num) - 1);
            }
        }

        // Convert the intersection list to an array
        int[] intersection = new int[intersectionList.size()];
        int index = 0;
        for (int num : intersectionList) {
            intersection[index++] = num;
        }

        return intersection;
    }

    public static void main(String[] args) {
        // Example usage
        MM arrayIntersection = new MM();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] intersection = arrayIntersection.intersect(nums1, nums2);
        for (int num : intersection) {
            System.out.print(num + " ");
        }
        // Output: 2 2
    }
}
