import java.util.Scanner;
public class baitap1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n nguyen duong : ");
        int n = sc.nextInt();
        if (n < 0) {
            System.out.println("So nhap vao khong hop le");
        } else {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            System.out.printf("Tong cac so tu 1 den " + n + " = " +sum );
        }
    }
}