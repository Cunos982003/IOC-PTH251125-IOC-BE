package ra.edu.model;

import ra.edu.exception.MyCheckedException;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private List<Product> products = new ArrayList<>();

    public Order(int orderId) {
        this.orderId = orderId;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int productId) throws MyCheckedException {
        boolean removed = products.removeIf(p -> p.getId() == productId);
        if (!removed) {
            throw new MyCheckedException("Không tìm thấy sản phẩm trong đơn");
        }
    }

    public double calculateTotal() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId +
                " | Total: " + calculateTotal();
    }
}
