// Abstract class
abstract class AbstractExample {
    // Concrete method
    public void concreteMethod1() {
        System.out.println("This is concrete method 1");
    }

    // Concrete method
    public void concreteMethod2() {
        System.out.println("This is concrete method 2");
    }

    // Abstract method 1
    abstract void abstractMethod1();

    // Abstract method 2
    abstract void abstractMethod2();
}

// Concrete subclass
class ConcreteExample extends AbstractExample {
    @Override
    void abstractMethod1() {
        System.out.println("Implementation of abstractMethod1");
    }

    @Override
    void abstractMethod2() {
        System.out.println("Implementation of abstractMethod2");
    }
}

// Main class to test the abstract class and methods
public class mm {
    public static void main(String[] args) {
        ConcreteExample example = new ConcreteExample();
        example.concreteMethod1();
        example.concreteMethod2();
        example.abstractMethod1();
        example.abstractMethod2();
    }
}
