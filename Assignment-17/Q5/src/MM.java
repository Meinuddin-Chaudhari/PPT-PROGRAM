import java.util.ArrayList;
import java.util.List;

public class MM {
    public static int findTheWinner(int n, int k) {
        // Create a list to represent the circle of friends
        List<Integer> friends = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            friends.add(i);
        }

        int index = 0;

        while (friends.size() > 1) {
            // Find the index of the friend to be removed
            index = (index + k - 1) % friends.size();

            // Remove the friend from the circle
            friends.remove(index);
        }

        // The remaining friend is the winner
        return friends.get(0);
    }

    public static void main(String[] args) {
        int n = 6;
        int k = 5;
        int winner = findTheWinner(n, k);
        System.out.println("The winner of the game: " + winner);
    }
}
