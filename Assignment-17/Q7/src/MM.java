import java.util.Deque;
import java.util.LinkedList;

public class MM {
    Deque<Integer> frontDeque;  // Deque for elements before the middle element
    Deque<Integer> backDeque;   // Deque for elements after the middle element

    public MM() {
        frontDeque = new LinkedList<>();
        backDeque = new LinkedList<>();
    }

    public void pushFront(int val) {
        frontDeque.offerFirst(val);
        balance();
    }

    public void pushMiddle(int val) {
        if (frontDeque.size() > backDeque.size()) {
            backDeque.offerFirst(frontDeque.pollLast());
        }
        frontDeque.offerLast(val);
    }

    public void pushBack(int val) {
        backDeque.offerLast(val);
        balance();
    }

    public int popFront() {
        if (frontDeque.isEmpty() && backDeque.isEmpty()) {
            return -1; // Queue is empty
        }
        if (frontDeque.isEmpty()) {
            return backDeque.pollFirst(); // Only backDeque has elements
        }
        return frontDeque.pollFirst();
    }

    public int popMiddle() {
        if (frontDeque.isEmpty() && backDeque.isEmpty()) {
            return -1; // Queue is empty
        }
        if (frontDeque.size() == backDeque.size()) {
            return frontDeque.pollLast(); // Choose frontmost middle element
        }
        return backDeque.pollFirst();
    }

    public int popBack() {
        if (frontDeque.isEmpty() && backDeque.isEmpty()) {
            return -1; // Queue is empty
        }
        if (backDeque.isEmpty()) {
            return frontDeque.pollLast(); // Only frontDeque has elements
        }
        return backDeque.pollLast();
    }

    private void balance() {
        if (frontDeque.size() > backDeque.size() + 1) {
            backDeque.offerFirst(frontDeque.pollLast());
        } else if (frontDeque.size() < backDeque.size()) {
            frontDeque.offerLast(backDeque.pollFirst());
        }
    }

    public static void main(String[] args) {
        MM queue = new MM();
        queue.pushFront(1);
        queue.pushBack(2);
        queue.pushMiddle(3);
        queue.pushMiddle(4);
        System.out.println(queue.popFront());  // Output: 1
        System.out.println(queue.popMiddle()); // Output: 3
        System.out.println(queue.popMiddle()); // Output: 4
        System.out.println(queue.popBack());   // Output: 2
        System.out.println(queue.popFront());  // Output: -1
    }
}
