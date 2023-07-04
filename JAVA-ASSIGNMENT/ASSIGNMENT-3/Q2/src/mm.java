class Animal {
    public void sound() {
        System.out.println("The animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("The dog barks");
    }

    public void fetch() {
        System.out.println("The dog fetches the ball");
    }
}

public class mm {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.sound(); // Output: The animal makes a sound

        Dog dog = new Dog();
        dog.sound(); // Output: The dog barks
        dog.fetch(); // Output: The dog fetches the ball

        Animal animalDog = new Dog();
        animalDog.sound(); // Output: The dog barks
        // animalDog.fetch(); // Compilation error - fetch method is not available in the Animal class
    }
}
