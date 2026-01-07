import java.util.Scanner;

public class baitap2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so thu nhat (firstNumber): ");
        int firstNumber = sc.nextInt();
        System.out.print("Nhap so thu hai (secondNumber): ");
        int secondNumber = sc.nextInt();
        int total = firstNumber + secondNumber;
        int minus = firstNumber - secondNumber;
        int mul = firstNumber * secondNumber;
        int div = firstNumber / secondNumber;
        System.out.println("---Ket qua---");
        System.out.printf("firstNumber = %d%n", firstNumber);
        System.out.printf("secondNumber = %d%n", secondNumber);
        System.out.printf("Tong = %d%n", total);
        System.out.printf("Hieu = %d%n", minus);
        System.out.printf("Tich = %d%n", mul);
        System.out.printf("Thuong = %d%n", div);
    }
}
