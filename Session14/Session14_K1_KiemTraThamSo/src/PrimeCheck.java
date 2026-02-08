import java.util.Scanner;

public class PrimeCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập một số nguyên: ");
            int number = scanner.nextInt();

            if (number <= 0) {
                System.out.println("Lỗi: Số nhập vào phải lớn hơn 0 để kiểm tra số nguyên tố.");
            } else {
                if (isPrime(number)) {
                    System.out.println(number + " là số nguyên tố.");
                } else {
                    System.out.println(number + " không phải là số nguyên tố.");
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi: Vui lòng nhập một số nguyên hợp lệ (không phải chữ, ký tự đặc biệt hoặc số thực).");
        } finally {
            scanner.close();
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}