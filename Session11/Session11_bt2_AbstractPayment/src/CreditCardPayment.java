public class CreditCardPayment extends Payment implements Refundable{
    public CreditCardPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("Thanh toan bang the tin dung: "+ amount);
    }
    @Override
    public void refund() {
        System.out.println("Hoan tien vao the tin dung: "+ amount);
    }
}
