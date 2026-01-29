public class Cat extends Mammal{
    public Cat(String name, int age, boolean hasFur) {
        super(name, age, hasFur);
    }
    @Override
    public void showInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Has fur: " + hasFur);
    }
    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow Meow!");
    }

    public void climbTree() {
        System.out.println(name + " is climbing the tree!");
    }

}
