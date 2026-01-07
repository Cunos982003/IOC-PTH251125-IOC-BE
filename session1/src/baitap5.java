import java.util.Scanner;

public class baitap5 {
    public static void main(String[] args) {
        double canNang, chieuCao;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap can nang: ");
        canNang = sc.nextDouble();
        System.out.print("Nhap chieu cao: ");
        chieuCao = sc.nextDouble();
        double bmi = canNang/(chieuCao*chieuCao);
        System.out.printf("Chi so BMI: %.2f%n", bmi);
    }
}
