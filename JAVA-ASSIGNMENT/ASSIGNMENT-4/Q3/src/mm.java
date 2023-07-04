// Functional interface with a single abstract method
@FunctionalInterface
interface Calculation {
    int perform(int a, int b);
}

// Main class to test the functional interface
public class mm {
    public static void main(String[] args) {
        // Using lambda expression to create an instance of the functional interface
        Calculation addition = (a, b) -> a + b;
        System.out.println("Addition: " + addition.perform(5, 3));

        // Using method reference to create an instance of the functional interface
        Calculation subtraction = mm::subtract;
        System.out.println("Subtraction: " + subtraction.perform(8, 4));

        // Using an anonymous class to create an instance of the functional interface
        Calculation multiplication = new Calculation() {
            @Override
            public int perform(int a, int b) {
                return a * b;
            }
        };
        System.out.println("Multiplication: " + multiplication.perform(6, 2));
    }

    // Method to perform subtraction
    public static int subtract(int a, int b) {
        return a - b;
    }
}
