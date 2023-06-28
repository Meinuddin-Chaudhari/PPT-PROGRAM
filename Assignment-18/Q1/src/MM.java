
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MM {
    public static int[][] mergeIntervals(int[][] intervals) {
        // Sort intervals based on the start time
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];
        mergedIntervals.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) {
                // Merge the intervals
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // Add the next interval to the list
                currentInterval = interval;
                mergedIntervals.add(currentInterval);
            }
        }

        return mergedIntervals.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merged = mergeIntervals(intervals);

        // Print the merged intervals
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }
}

