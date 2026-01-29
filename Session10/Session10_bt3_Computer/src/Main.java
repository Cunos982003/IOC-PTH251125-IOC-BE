//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Computer comp = new Computer();

        double basePrice = 1000.0;
        double tax = 100.0;
        double discount = 50.0;

        double price1 = comp.calculatePrice(basePrice);
        System.out.println("Final price: " + price1);

        double price2 = comp.calculatePrice(basePrice, tax);
        System.out.println("Final price: " + price2);

        double price3 = comp.calculatePrice(basePrice, tax, discount);
        System.out.println("Final price: " + price3);

    }
}