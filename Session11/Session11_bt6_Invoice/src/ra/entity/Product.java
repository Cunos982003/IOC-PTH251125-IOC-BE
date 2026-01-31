package ra.entity;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private double price;
    private Status status;

    public enum Status { AVAILABLE, OUT_OF_STOCK, STOP_SELLING }

    public Product() {}

    public Product(String productId, String productName, double price, Status status) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.status = status;
    }

    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public void inputData(Scanner scanner, Product[] arrProd, int index) {
        while (true) {
            System.out.print("Nhập mã sản phẩm (Cxxx/Sxxx/Axxx): ");
            String id = scanner.nextLine();
            if (id.matches("^[CSA]\\d{3}$")) {
                boolean exists = false;
                for (int i = 0; i < index; i++) {
                    if (arrProd[i].getProductId().equals(id)) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    this.productId = id;
                    break;
                } else {
                    System.out.println("Mã sản phẩm đã tồn tại!");
                }
            } else {
                System.out.println("Mã sản phẩm phải bắt đầu bằng C/S/A và có 4 ký tự.");
            }
        }

        while (true) {
            System.out.print("Nhập tên sản phẩm (10–50 ký tự): ");
            String name = scanner.nextLine();
            if (name.length() >= 10 && name.length() <= 50) {
                boolean exists = false;
                for (int i = 0; i < index; i++) {
                    if (arrProd[i].getProductName().equalsIgnoreCase(name)) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    this.productName = name;
                    break;
                } else {
                    System.out.println("Tên sản phẩm đã tồn tại!");
                }
            } else {
                System.out.println("Tên sản phẩm phải từ 10–50 ký tự.");
            }
        }

        while (true) {
            System.out.print("Nhập giá bán (>0): ");
            try {
                double p = Double.parseDouble(scanner.nextLine());
                if (p > 0) {
                    this.price = p;
                    break;
                } else {
                    System.out.println("Giá phải > 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Giá phải là số.");
            }
        }

        while (true) {
            System.out.print("Chọn trạng thái (AVAILABLE/OUT_OF_STOCK/STOP_SELLING): ");
            try {
                this.status = Status.valueOf(scanner.nextLine().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Trạng thái không hợp lệ.");
            }
        }
    }
    public void displayData() {
        System.out.printf("ID: %s | Tên: %s | Giá: %.2f | Trạng thái: %s\n",
                productId, productName, price, status);
    }
}
