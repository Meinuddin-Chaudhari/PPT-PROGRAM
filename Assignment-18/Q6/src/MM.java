import java.util.Arrays;
import java.util.Comparator;

public class MM {
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        // Sort the balloons based on their ending positions
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int shots = 1;  // Number of arrows required
        int prevEnd = points[0][1];  // Ending position of the first balloon

        for (int i = 1; i < points.length; i++) {
            int start = points[i][0];
            int end = points[i][1];

            // If the current balloon starts after the previous balloon's end, a new arrow is required
            if (start > prevEnd) {
                shots++;
                prevEnd = end;
            }
        }

        return shots;
    }

    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int minShots = findMinArrowShots(points);
        System.out.println("Minimum Number of Arrows: " + minShots);
    }
}
