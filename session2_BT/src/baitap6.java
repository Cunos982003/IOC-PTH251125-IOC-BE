import java.util.Scanner;

public class baitap6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n ;
        while (true) {
            System.out.print("Nhập một số nguyên dương N: ");
            n = sc.nextInt();
            if (n> 0) {
                break;
            } else {
                System.out.println("Số nhập vào không hợp lệ. Vui lòng nhập lại!");
            }
        }

        System.out.println("Các số Armstrong từ 0 đến " + n + " là:");
        for (int i = 0; i <= n; i++) {
            int temp = i;
            int sum =0;
            while(temp !=0){
                int ch = temp % 10;
                sum += ch*ch*ch;
                temp = temp/10 ;
            }
            if(sum == i){
                System.out.println(i);
            }
        }

    }
}
