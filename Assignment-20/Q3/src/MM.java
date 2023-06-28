import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isLevelOrderBST(int[] arr) {
        if (arr == null || arr.length == 0)
            return true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(arr[0]);

        int index = 1;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        while (!queue.isEmpty() && index < arr.length) {
            int current = queue.poll();

            if (arr[index] < min || arr[index] > max)
                return false;

            if (arr[index] < current) {
                queue.offer(arr[index]);
                max = current;
            } else {
                queue.offer(arr[index]);
                min = current;
            }

            index++;
        }

        return true;
    }
}

public class MM {
    public static void main(String[] args) {
        int[] arr = {7, 4, 12, 3, 6, 8, 1, 5, 10};

        Solution solution = new Solution();
        boolean isLevelOrderBST = solution.isLevelOrderBST(arr);

        System.out.println("Is Level Order Traversal a BST: " + isLevelOrderBST);
    }
}
