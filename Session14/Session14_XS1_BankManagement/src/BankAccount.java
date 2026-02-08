public class BankAccount {
    private String accountId;
    private double balance;

    public BankAccount() {}

    public BankAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Lỗi: Số tiền gửi phải lớn hơn 0!");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Lỗi: Số tiền rút phải lớn hơn 0!");
        }
        if (amount > balance) {
            throw new Exception("Lỗi: Số tiền rút vượt quá số dư!");
        }
        balance -= amount;
    }

    public void transfer(BankAccount target, double amount) throws Exception {
        if (target == null) {
            throw new Exception("Lỗi: Tài khoản đích không tồn tại!");
        }
        if (amount <= 0) {
            throw new Exception("Lỗi: Số tiền chuyển phải lớn hơn 0!");
        }
        if (amount > balance) {
            throw new Exception("Lỗi: Số tiền chuyển vượt quá số dư!");
        }
        this.balance -= amount;
        target.balance += amount;
    }

    @Override
    public String toString() {
        return "Tài khoản: " + accountId + ", Số dư: " + balance;
    }
}