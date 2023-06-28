import java.util.LinkedList;
import java.util.Queue;

public class MM {
    private Queue<Integer> requests;

    public MM() {
        requests = new LinkedList<>();
    }

    public int ping(int t) {
        requests.add(t); // Add the new request to the queue

        // Remove the requests that are outside the time frame [t - 3000, t]
        while (!requests.isEmpty() && requests.peek() < t - 3000) {
            requests.poll();
        }

        return requests.size();
    }

    public static void main(String[] args) {
        MM recentCounter = new MM();
        System.out.println(recentCounter.ping(1));    // Output: 1
        System.out.println(recentCounter.ping(100));  // Output: 2
        System.out.println(recentCounter.ping(3001)); // Output: 3
        System.out.println(recentCounter.ping(3002)); // Output: 3
    }
}
