//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CurrencyConverter.setRate(2500);
        double usd = CurrencyConverter.toUSD(1_000_000);
        System.out.println("Ti gia hien hanh: 1 USD = " + CurrencyConverter.getRate() + " VND");
        System.out.println("1_000_000 VND = " + CurrencyConverter.formatUSD(usd,2) + " USD");
    }
}