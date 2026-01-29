//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();

        myCar.accelerate();
        myCar.printStatus();
        System.out.println();

        myCar.accelerate(20);
        myCar.printStatus();
        System.out.println();

        myCar.accelerate(5, 3);
        myCar.printStatus();
        System.out.println();
    }
}
