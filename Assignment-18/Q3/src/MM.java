public class MM {
    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // Example implementation of the isBadVersion API
    private static boolean isBadVersion(int version) {
        // Implementation details not provided in the example
        return false;
    }

    public static void main(String[] args) {
        int n = 10;
        int firstBad = firstBadVersion(n);
        System.out.println("First bad version: " + firstBad);
    }
}
