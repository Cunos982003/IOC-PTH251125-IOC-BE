import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("""
            ===== MENU QUẢN LÝ SẢN PHẨM =====
            1. Thêm sản phẩm
            2. Hiển thị danh sách sản phẩm
            3. Tìm sản phẩm theo khoảng giá
            4. Thống kê số sản phẩm đã tạo
            0. Thoát
            """);
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    Product p = new Product();
                    p.input();
                    products.add(p);
                    System.out.println("Đã thêm sản phẩm.");
                    break;
                case 2:
                    System.out.println("\n--- Danh sách sản phẩm ---");
                    for (Product pr : products) {
                        pr.print();
                    }
                    break;
                case 3:
                    if (products.isEmpty()) {
                        System.out.println("Chưa có sản phẩm nào.");
                    } else {
                        System.out.print("Nhập giá thấp nhất: ");
                        double minPrice = Double.parseDouble(sc.nextLine());
                        System.out.print("Nhập giá cao nhất: ");
                        double maxPrice = Double.parseDouble(sc.nextLine());

                        System.out.println("\n--- Sản phẩm trong khoảng giá ---");
                        boolean found = false;
                        for (Product pr : products) {
                            if (pr.getPrice() >= minPrice && pr.getPrice() <= maxPrice) {
                                pr.print();
                                found = true;
                            }
                        }
                        if (!found) {
                            System.out.println("Không có sản phẩm nào trong khoảng giá này.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Tổng số sản phẩm đã tạo: " + products.size());
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }
}
