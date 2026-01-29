public class Mammal extends Animal {
    protected boolean hasFur;

    public Mammal(String name, int age, boolean hasFur) {
        super(name, age);
        this.hasFur = hasFur;
    }

    @Override
    public void showInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Has fur: " + hasFur);
    }
}
