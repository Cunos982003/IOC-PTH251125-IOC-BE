import java.util.Scanner;

public class baitap3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Nhap a: ");
        int a = input.nextInt();
        System.out.printf("Nhap b: ");
        int b = input.nextInt();
        System.out.printf("Nhap c: ");
        int c = input.nextInt();
        System.out.printf("Nhap d: ");
        int d = input.nextInt();
        int tuTong = a*d + b*c;
        int tuMau = b*d;
        System.out.printf("Tong hai phan so = " + tuTong + "/" + tuMau);
    }
}
