import java.util.Scanner;

public class baitap2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap thang: ");
        int n = sc.nextInt();
        switch(n){
            case 1, 3, 5, 7, 8, 10, 12:
                System.out.println("Thang " + n + " co 31 ngay !" );
                break;
            case 4, 6, 9, 11:
                System.out.println("Thang " + n + " co 30 ngay !" );
                break;
            case 2:
                System.out.println("Thang " + n + " co 28 hoac 29 ngay !" );
                break;
            default:
                System.out.println("Tháng không hợp lệ ! ");
        }
    }
}
