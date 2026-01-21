//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Animal animal = new Animal("Dogo", 3);
    animal.makeSound();
    Cat cat = new Cat("Tom",4,"Orange");
        cat.makeSound();
        cat.bark();

    Dog dog = new Dog("Donna",5, "Black");
    dog.makeSound();
    dog.meow();

    }
}