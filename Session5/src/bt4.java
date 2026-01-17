import java.util.Random;
import java.util.Scanner;

public class bt4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập độ dài chuỗi (1<=n<=1000): ");
        int n = sc.nextInt();

        if (n<1 || n>1000) {
            System.out.println("Độ dài không hợp lệ. Vui lòng nhập từ 1 đến 1000");
            return;
        }

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random rnd = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            int index = rnd.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }
        System.out.println("Chuỗi ngẫu nhiên: " + sb.toString());
    }
}
