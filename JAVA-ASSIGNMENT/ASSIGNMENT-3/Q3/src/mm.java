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
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("The cat meows");
    }
}

public class mm {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.sound(); // Output: The animal makes a sound

        Animal dog = new Dog();
        dog.sound(); // Output: The dog barks

        Animal cat = new Cat();
        cat.sound(); // Output: The cat meows
    }
}
