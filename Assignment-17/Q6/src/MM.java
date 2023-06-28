import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MM {
    public static int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);

        Deque<Integer> indices = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            indices.offer(i);
        }

        int[] result = new int[n];
        for (int card : deck) {
            result[indices.poll()] = card;
            if (!indices.isEmpty()) {
                indices.offer(indices.poll());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] deck = {17, 13, 11, 2, 3, 5, 7};
        int[] result = deckRevealedIncreasing(deck);
        System.out.println("Reordered deck: " + Arrays.toString(result));
    }
}
