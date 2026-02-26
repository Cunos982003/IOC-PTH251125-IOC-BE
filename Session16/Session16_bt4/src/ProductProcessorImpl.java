import java.util.List;

public class ProductProcessorImpl implements ProductProcessor {

    @Override
    public double calculateTotalValue(List<Product> products) {

        double total = 0;

        for (Product p : products) {
            total += p.getPrice();
        }

        return total;
    }
}