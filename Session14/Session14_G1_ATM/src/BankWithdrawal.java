import java.util.Scanner;

public class BankWithdrawal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int balance = 1_000_000;
        int minBalance = 50_000;

        System.out.println("Số dư hiện tại: " + balance + " đồng");

        while (true) {
            try {
                System.out.print("Nhập số tiền muốn rút (hoặc gõ 0 để thoát): ");
                int withdrawAmount = scanner.nextInt();

                if (withdrawAmount == 0) {
                    System.out.println("Thoát chương trình. Cảm ơn bạn!");
                    break;
                }

                if (withdrawAmount < 0) {
                    System.out.println("Lỗi: Vui lòng nhập số tiền rút hợp lệ (>0)!");
                } else if (withdrawAmount > balance) {
                    System.out.println("Lỗi: Số tiền rút vượt quá số dư!");
                } else if (balance - withdrawAmount < minBalance) {
                    System.out.println("Lỗi: Tài khoản phải duy trì số dư tối thiểu " + minBalance + " đồng!");
                } else {
                    // Rút tiền thành công
                    balance -= withdrawAmount;
                    System.out.println("✅ Rút tiền thành công!");
                    System.out.println("Số tiền đã rút: " + withdrawAmount + " đồng");
                    System.out.println("Số dư còn lại: " + balance + " đồng");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}