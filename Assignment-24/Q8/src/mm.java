import java.util.*;

public class mm {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        // Find the index of the closest element or the first element greater than x
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Expand the window around the closest element to find k closest elements
        left--;
        right++;
        while (k > 0) {
            if (left < 0) {
                result.add(arr[right++]);
            } else if (right >= arr.length) {
                result.add(0, arr[left--]);
            } else if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                result.add(0, arr[left--]);
            } else {
                result.add(arr[right++]);
            }
            k--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        List<Integer> closestElements = findClosestElements(arr, k, x);
        System.out.println("Closest elements: " + closestElements);
    }
}
