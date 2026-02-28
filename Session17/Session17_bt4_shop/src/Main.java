import ra.edu.business.OrderManager;
import ra.edu.model.Customer;
import ra.edu.model.Product;

import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final OrderManager manager = new OrderManager();

    public static void main(String[] args) {

        OrderManager manager = new OrderManager();

        while (true) {
            System.out.println("\n===== SHOP MANAGEMENT =====");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Cập nhật khách hàng");
            System.out.println("3. Tạo đơn hàng");
            System.out.println("4. Hiển thị tất cả đơn");
            System.out.println("5. Tìm đơn theo khách");
            System.out.println("0. Thoát");

            int choice = inputInt("Chọn: ");

            switch (choice) {
                case 1:
                    System.out.print("Tên SP: ");
                    String name = sc.nextLine();
                    double price = inputDouble("Giá: ");
                    manager.addProduct(new Product(name, price));
                    break;

                case 2:
                    int cid = inputInt("ID KH: ");
                    System.out.print("Tên mới: ");
                    String cname = sc.nextLine();
                    System.out.print("Email mới: ");
                    String email = sc.nextLine();
                    manager.updateCustomer(cid, new Customer(cname, email));
                    break;

                case 3:
                    int cusId = inputInt("Customer ID: ");
                    int productId = inputInt("Product ID: ");
                    int qty = inputInt("Số lượng: ");
                    manager.createOrder(cusId, productId, qty);
                    break;

                case 4:
                    manager.listAllOrders();
                    break;

                case 5:
                    int idSearch = inputInt("Customer ID: ");
                    manager.getOrdersByCustomer(idSearch);
                    break;

                case 0:
                    return;
            }
        }
    }

    private static int inputInt(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Nhập số hợp lệ!");
            }
        }
    }

    private static double inputDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Nhập số hợp lệ!");
            }
        }
    }
}