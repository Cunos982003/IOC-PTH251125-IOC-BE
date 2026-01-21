public class Cat extends Animal {

    private String breed;

    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Cat(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }
    public void bark() {
        System.out.println("Cat is barking...");
    }

}
