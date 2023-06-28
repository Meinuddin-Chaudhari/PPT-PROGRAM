import java.util.LinkedList;
import java.util.Queue;

public class MM {
    private int value;
    private int k;
    private Queue<Integer> stream;

    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
        this.stream = new LinkedList<>();
    }

    public boolean consec(int num) {
        stream.offer(num);
        if (stream.size() < k) {
            return false;
        }
        if (stream.size() > k) {
            stream.poll();
        }
        for (int n : stream) {
            if (n != value) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MM ds = new MM(4, 3);
        System.out.println(ds.consec(4)); // Output: false
        System.out.println(ds.consec(4)); // Output: false
        System.out.println(ds.consec(4)); // Output: true
        System.out.println(ds.consec(3)); // Output: false
    }
}
