class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class mm {
    public static void main(String[] args) {
        MathOperations math = new MathOperations();

        int sum1 = math.add(2, 3);
        System.out.println("Sum 1: " + sum1); // Output: 5

        double sum2 = math.add(2.5, 3.7);
        System.out.println("Sum 2: " + sum2); // Output: 6.2

        int sum3 = math.add(2, 3, 4);
        System.out.println("Sum 3: " + sum3); // Output: 9
    }
}
