import java.util.ArrayDeque;
import java.util.Deque;

public class MM {
    public static int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> studentQueue = new ArrayDeque<>();
        Deque<Integer> sandwichStack = new ArrayDeque<>();

        // Add students to the queue
        for (int student : students) {
            studentQueue.addLast(student);
        }

        // Add sandwiches to the stack
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            sandwichStack.push(sandwiches[i]);
        }

        int unableToEatCount = 0;

        // Iterate until there are no more students or sandwiches
        while (!studentQueue.isEmpty() && !sandwichStack.isEmpty()) {
            int currentStudent = studentQueue.pollFirst();
            int currentSandwich = sandwichStack.peek();

            // If the current student prefers the current sandwich, they will take it
            if (currentStudent == currentSandwich) {
                sandwichStack.pop();
                unableToEatCount = 0; // Reset the count since a student took a sandwich
            } else {
                studentQueue.addLast(currentStudent);
                unableToEatCount++; // Increment the count of students unable to eat
            }

            // If all remaining students are unable to eat, break the loop
            if (unableToEatCount == studentQueue.size()) {
                break;
            }
        }

        return unableToEatCount;
    }

    public static void main(String[] args) {
        int[] students = {1, 1, 0, 0};
        int[] sandwiches = {0, 1, 0, 1};
        int unableToEat = countStudents(students, sandwiches);
        System.out.println("Number of students unable to eat: " + unableToEat);
    }
}
