import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new BankAccount("ACC001", 1_000_000));
        accounts.add(new BankAccount("ACC002", 500_000));
        accounts.add(new BankAccount("ACC003", 200_000));

        try {
            accounts.get(0).deposit(200_000);
            System.out.println("Sau khi gửi tiền: " + accounts.get(0));


            accounts.get(1).withdraw(100_000);
            System.out.println("Sau khi rút tiền: " + accounts.get(1));

            accounts.get(0).transfer(accounts.get(2), 300_000);
            System.out.println("Sau khi chuyển tiền:");
            System.out.println(accounts.get(0));
            System.out.println(accounts.get(2));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}