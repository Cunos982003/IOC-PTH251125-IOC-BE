import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProductManager {
        private static HashMap<Integer, Product> productMap = new HashMap<>();
        private static Scanner sc =  new Scanner(System.in);
        public static void main(String[] args) {
            while(true){
                System.out.println("\n===== Product Management System =======");
                System.out.println("1. Add Product");
                System.out.println("2. Edit Product");
                System.out.println("3. Delete Product");
                System.out.println("4. Display Products");
                System.out.println("5. Filter Products (price > 100)");
                System.out.println("6. Total Value of Products");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        addProduct();
                        break;
                    case 2:
                        editProduct();
                        break;
                    case 3:
                        deleteProduct();
                        break;
                    case 4:
                        showProducts();
                        break;
                    case 5:
                        filterProducts();
                        break;
                    case 6:
                        calculateTotalPrice();
                        break;
                    case 0:
                        System.out.println("Exit program!");
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
        }
    }

    public static void addProduct() {
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(sc.nextLine());

        if (productMap.containsKey(id)) {
            System.out.println("ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = Double.parseDouble(sc.nextLine());

        productMap.put(id, new Product(id, name, price));
        System.out.println("Product added successfully!");
    }

    // Sửa sản phẩm
    public static void editProduct() {
        System.out.print("Enter ID to update: ");
        int id = Integer.parseInt(sc.nextLine());

        Product product = productMap.get(id);

        if (product == null) {
            System.out.println("Product not found!");
            return;
        }

        System.out.print("Enter new Name: ");
        product.setName(sc.nextLine());

        System.out.print("Enter new Price: ");
        product.setPrice(Double.parseDouble(sc.nextLine()));

        System.out.println("Product updated successfully!");
    }

    // Xóa sản phẩm
    public static void deleteProduct() {
        System.out.print("Enter ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());

        if (productMap.remove(id) != null) {
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    // Hiển thị sản phẩm
    public static void showProducts() {
        if (productMap.isEmpty()) {
            System.out.println("Product list is empty!");
            return;
        }

        productMap.values().forEach(System.out::println);
    }

    // Lọc sản phẩm giá > 100 (Streams)
    public static void filterProducts() {
        List<Product> filtered = productMap.values()
                .stream()
                .filter(p -> p.getPrice() > 100)
                .collect(Collectors.toList());

        if (filtered.isEmpty()) {
            System.out.println("No products with price > 100");
            return;
        }

        filtered.forEach(System.out::println);
    }

    // Tính tổng giá trị sản phẩm (Streams)
    public static void calculateTotalPrice() {
        double total = productMap.values()
                .stream()
                .mapToDouble(Product::getPrice)
                .sum();

        System.out.println("Total price of all products: " + total);
    }
}
