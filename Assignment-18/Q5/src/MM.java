import java.util.HashSet;

public class MM {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        boolean containsDuplicates = containsDuplicate(nums);
        System.out.println("Contains Duplicates: " + containsDuplicates);
    }
}
