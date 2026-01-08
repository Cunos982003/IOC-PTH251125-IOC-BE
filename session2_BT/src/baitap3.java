import java.util.Scanner;

public class baitap3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so nguyen N: ");
        int n = sc.nextInt();
        if (n < 0){
            n = -n;
        }
        int tong = 0;
        while (n > 0){
            int chuSo = n % 10;
            tong += chuSo;
            n/=10;
        }
        System.out.println("Tong cac chu so la: " + tong);
        sc.close();
    }
}
