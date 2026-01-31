package ra.entity;

import java.util.Scanner;

public class InvoiceDetail {
    private Product product;
    private int quantity;
    private double subTotal;

    public InvoiceDetail() {}

    public InvoiceDetail(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.subTotal = product.getPrice() * quantity;
    }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getSubTotal() { return subTotal; }
    public void setSubTotal(double subTotal) { this.subTotal = subTotal; }

    public void inputData(Scanner scanner, Product[] arrProd, int prodIndex) {
        System.out.println("Danh sách sản phẩm:");
        for (int i = 0; i < prodIndex; i++) {
            arrProd[i].displayData();
        }
        System.out.print("Nhập mã sản phẩm muốn mua: ");
        String id = scanner.nextLine();
        for (int i = 0; i < prodIndex; i++) {
            if (arrProd[i].getProductId().equals(id)) {
                this.product = arrProd[i];
                break;
            }
        }

        while (true) {
            System.out.print("Nhập số lượng (>0): ");
            try {
                int q = Integer.parseInt(scanner.nextLine());
                if (q > 0) {
                    this.quantity = q;
                    break;
                } else {
                    System.out.println("Số lượng phải > 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Số lượng phải là số.");
            }
        }

        this.subTotal = this.product.getPrice() * this.quantity;
    }

    public void displayData() {
        System.out.printf("Sản phẩm: %s | SL: %d | Thành tiền: %.2f\n",
                product.getProductName(), quantity, subTotal);
    }
}