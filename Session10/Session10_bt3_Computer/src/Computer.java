public class Computer {
    public double calculatePrice(double basePrice) {
        System.out.println("Using base price ");
        return basePrice;
    }
    public double calculatePrice(double basePrice, double tax) {
        System.out.println("Using base price + tax" );
        return basePrice + tax;
    }
    public double calculatePrice(double basePrice, double tax, double discount) {
        System.out.println("Using base price + tax - discount" );
        return basePrice + tax - discount;
    }
}
