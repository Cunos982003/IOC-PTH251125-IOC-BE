import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Drink> menu = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("""
            ===== COFFEE SHOP MENU =====
            1. Thêm món vào Menu
            2. Hiển thị Menu
            3. Áp dụng mã giảm giá
            4. Xóa món
            5. Thống kê giá trung bình
            6. Thoát
            =================
            """);
            System.out.print("Chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addDrink();
                    break;
                case 2:
                    showMenu();
                    break;
                case 3:
                    applyDiscount();
                    break;
                case 4:
                    deleteDrink();
                    break;
                case 5:
                    statistics();
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 6);
    }

    public static void addDrink() {
        System.out.println("Thêm (1: Coffee, 2: FruitTea): ");
        int type = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();
        System.out.print("Nhập tên: ");
        String name = sc.nextLine();
        System.out.print("Nhập giá: ");
        double price = sc.nextDouble();

        if (type == 1) {
            menu.add(new Coffee(id, name, price));
        } else {
            menu.add(new FruitTea(id, name, price));
        }
        System.out.println("Thêm thành công!");
    }

    public static void showMenu() {
        System.out.println("===== DANH MỤC ĐỒ UỐNG =====");
        for (Drink d : menu) {
            System.out.println(d.toString());
            d.prepare();
        }
    }

    public static void applyDiscount() {
        System.out.print("Nhập % giảm giá: ");
        double percent = sc.nextDouble();
        for (Drink d : menu) {
            d.applyDiscount(percent);
        }
        System.out.println("Đã áp dụng giảm giá " + percent + "% cho toàn bộ menu.");
    }

    public static void deleteDrink() {
        System.out.print("Nhập ID món cần xóa: ");
        String id = sc.nextLine();
        menu.removeIf(d -> d.getId().equalsIgnoreCase(id));
        System.out.println("Xóa thành công!");
    }

    public static void statistics() {
        if (menu.isEmpty()) {
            System.out.println("Menu trống!");
            return;
        }
        double sum = 0;
        for (Drink d : menu) {
            sum += d.getPrice();
        }
        double avg = sum / menu.size();
        System.out.println("Giá trung bình của menu: " + avg);
    }

}