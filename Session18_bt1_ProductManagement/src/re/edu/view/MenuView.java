package re.edu.view;

import re.edu.business.IProductService;
import re.edu.business.impl.ProductServiceImpl;
import re.edu.model.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuView {

    private static final IProductService productService = new ProductServiceImpl();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            try {
                showMenu();
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> displayAll();
                    case 2 -> addProduct();
                    case 3 -> updateProduct();
                    case 4 -> deleteProduct();
                    case 5 -> searchProduct();
                    case 6 -> sortByPrice();
                    case 7 -> statistic();
                    case 0 -> {
                        System.out.println("Thoát chương trình!");
                        return;
                    }
                    default -> System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n**************** PRODUCT MANAGEMENT ****************");
        System.out.println("1. Danh sách sản phẩm");
        System.out.println("2. Thêm mới sản phẩm");
        System.out.println("3. Cập nhật sản phẩm");
        System.out.println("4. Xóa sản phẩm");
        System.out.println("5. Tìm kiếm sản phẩm theo tên");
        System.out.println("6. Sắp xếp sản phẩm theo giá tăng dần");
        System.out.println("7. Thống kê số lượng sản phẩm theo danh mục");
        System.out.println("0. Thoát");
        System.out.print("Chọn: ");
    }

    private static void displayAll() {
        List<Product> list = productService.findAll();
        if (list.isEmpty()) {
            System.out.println("Không có sản phẩm nào!");
            return;
        }
        list.forEach(MenuView::printProduct);
    }

    private static void addProduct() {
        try {
            Product p = inputProduct(false);
            productService.save(p);
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private static void updateProduct() {
        try {
            System.out.print("Nhập ID cần cập nhật: ");
            int id = Integer.parseInt(sc.nextLine());

            Product old = productService.findById(id);
            if (old == null) {
                System.out.println("Không tìm thấy sản phẩm!");
                return;
            }

            System.out.println("Nhập thông tin mới:");
            Product p = inputProduct(true);
            p.setId(id);

            productService.update(p);
            System.out.println("Cập nhật thành công!");

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private static void deleteProduct() {
        try {
            System.out.print("Nhập ID cần xóa: ");
            int id = Integer.parseInt(sc.nextLine());
            productService.delete(id);
            System.out.println("Xóa thành công!");
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private static void searchProduct() {
        System.out.print("Nhập tên cần tìm: ");
        String name = sc.nextLine();

        List<Product> list = productService.searchByName(name);
        if (list.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm!");
            return;
        }
        list.forEach(MenuView::printProduct);
    }

    private static void sortByPrice() {
        List<Product> list = productService.findAll();
        if (list.isEmpty()) {
            System.out.println("Không có dữ liệu để sắp xếp!");
            return;
        }

        list.stream()
                .sorted((a, b) -> Double.compare(a.getPrice(), b.getPrice()))
                .forEach(MenuView::printProduct);
    }

    private static void statistic() {
        Map<String, Integer> map = productService.countByCatalog();
        if (map.isEmpty()) {
            System.out.println("Không có dữ liệu thống kê!");
            return;
        }
        map.forEach((catalog, total) ->
                System.out.println(catalog + " : " + total));
    }

    private static Product inputProduct(boolean isUpdate) {

        System.out.print("Tên sản phẩm: ");
        String name = sc.nextLine();

        System.out.print("Giá: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.print("Tiêu đề: ");
        String title = sc.nextLine();

        System.out.print("Ngày tạo (yyyy-MM-dd): ");
        LocalDate created = LocalDate.parse(sc.nextLine());

        System.out.print("Danh mục: ");
        String catalog = sc.nextLine();

        boolean status = true;
        if (isUpdate) {
            System.out.print("Trạng thái (true/false): ");
            status = Boolean.parseBoolean(sc.nextLine());
        }

        return new Product(0, name, price, title, created, catalog, status);
    }

    private static void printProduct(Product p) {
        System.out.printf(
                "%-5d | %-20s | %-10.2f | %-20s | %-12s | %-15s | %-5s\n",
                p.getId(),
                p.getName(),
                p.getPrice(),
                p.getTitle(),
                p.getCreated(),
                p.getCatalog(),
                p.isStatus()
        );
    }
}