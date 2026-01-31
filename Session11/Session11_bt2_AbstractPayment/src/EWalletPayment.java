public class EWalletPayment extends Payment implements Refundable{
    public EWalletPayment(double amount) {
        super(amount);
    }
    public void pay() {
        System.out.println("Hoan tien vao E-Wallet: "+ amount);
    }
    public void refund() {
        System.out.println("Hoan tien vao E-Wallet: "+ amount);
    }
}
