//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Payment[] payments = new Payment[3];
        payments[0] = new CashPayment(1000);
        payments[1] = new CreditCardPayment(200);
        payments[2] = new EWalletPayment(300);

        for (Payment payment : payments) {
            payment.printAmount();
            payment.pay();

            if (payment instanceof Refundable) {
                ((Refundable) payment).refund();
        }
            System.out.println("-------------------------");



        }
    }
}