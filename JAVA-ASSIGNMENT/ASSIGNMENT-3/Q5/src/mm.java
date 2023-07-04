// Interface defining the shape behavior
interface Shape {
    double calculateArea();
    void display();
}

// Rectangle class implementing the Shape interface
class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public void display() {
        System.out.println("Rectangle");
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
        System.out.println("Area: " + calculateArea());
    }
}

// Circle class implementing the Shape interface
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void display() {
        System.out.println("Circle");
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
    }
}

// Client class using the Shape interface for loose coupling
class Client {
    private Shape shape;

    public Client(Shape shape) {
        this.shape = shape;
    }

    public void displayShapeDetails() {
        shape.display();
    }
}

public class mm {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(4, 6);
        Circle circle = new Circle(3.5);

        Client client1 = new Client(rectangle);
        client1.displayShapeDetails();

        Client client2 = new Client(circle);
        client2.displayShapeDetails();
    }
}
