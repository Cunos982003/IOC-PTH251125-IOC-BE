public class Dog extends Animal{

    public Dog(String name, int age) {
        super(name, age);
    }
    private String color;
    public String getColor() {
        return color;
    }
    public Dog(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }
    public void meow() {
        System.out.println("Dog is meowing...");
    }
}
