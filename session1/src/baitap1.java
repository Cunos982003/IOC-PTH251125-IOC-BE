import java.util.Scanner;

public class baitap1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter circle radius: ");
        double radius = sc.nextDouble();
        double A = Math.PI * radius * radius;
        System.out.printf("Dien tich = %.2f%n", A);
    }
}
