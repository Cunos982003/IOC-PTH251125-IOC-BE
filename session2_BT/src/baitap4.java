import java.util.Scanner;

public class baitap4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhap canh a: ");
        double a = sc.nextDouble();
        System.out.printf("Nhap canh b: ");
        double b = sc.nextDouble();
        System.out.printf("Nhap canh c: ");
        double c = sc.nextDouble();
        if (a + b > c && b + c > a && c + a > b) {
            if (a == b && b == c) {
                System.out.println("Tam giác đều");
            } else if (a == b || b == c || a == c) {
                System.out.println("Tam giác cân");
            } else if (
                    Math.abs(a*a + b*b - c*c) < 1e-9 ||
                            Math.abs(a*a + c*c - b*b) < 1e-9 ||
                            Math.abs(b*b + c*c - a*a) < 1e-9
            ) {
                System.out.println("Tam giác vuông");
            } else {
                System.out.println("Tam giác thường");
            }
        } else {
            System.out.println("Ba canh tam giac khong hop le!");
        }
    }
}
