abstract class Payment {
    protected double amount;
    public Payment(double amount) {
        this.amount = amount;
    }

    abstract public void pay();
    public void printAmount(){
        System.out.println("Amount : " + amount);
    }

}
