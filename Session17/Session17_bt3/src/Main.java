import ra.edu.business.BookManager;
import ra.edu.model.Book;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final BookManager manager = new BookManager();

    public static void main(String[] args) {

        while (true) {
            showMenu();
            int choice = inputInt("Chọn chức năng: ");

            switch (choice) {
                case 1:
                    addBookUI();
                    break;
                case 2:
                    updateBookUI();
                    break;
                case 3:
                    deleteBookUI();
                    break;
                case 4:
                    findByAuthorUI();
                    break;
                case 5:
                    manager.listAllBooks();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n===== QUẢN LÝ SÁCH =====");
        System.out.println("1. Thêm sách");
        System.out.println("2. Cập nhật sách");
        System.out.println("3. Xóa sách");
        System.out.println("4. Tìm theo tác giả");
        System.out.println("5. Hiển thị tất cả");
        System.out.println("0. Thoát");
    }

    private static void addBookUI() {
        System.out.println("\n--- Thêm sách ---");

        String title = inputString("Nhập tiêu đề: ");
        String author = inputString("Nhập tác giả: ");
        int year = inputInt("Nhập năm xuất bản: ");
        double price = inputDouble("Nhập giá: ");

        Book book = new Book(title, author, year, price);
        manager.addBook(book);
    }

    private static void updateBookUI() {
        System.out.println("\n--- Cập nhật sách ---");

        int id = inputInt("Nhập ID sách: ");
        String title = inputString("Nhập tiêu đề mới: ");
        String author = inputString("Nhập tác giả mới: ");
        int year = inputInt("Nhập năm xuất bản mới: ");
        double price = inputDouble("Nhập giá mới: ");

        Book book = new Book(title, author, year, price);
        manager.updateBook(id, book);
    }

    private static void deleteBookUI() {
        System.out.println("\n--- Xóa sách ---");
        int id = inputInt("Nhập ID cần xóa: ");
        manager.deleteBook(id);
    }

    private static void findByAuthorUI() {
        System.out.println("\n--- Tìm theo tác giả ---");
        String author = inputString("Nhập tên tác giả: ");

        List<Book> list = manager.findBooksByAuthor(author);

        if (list.isEmpty()) {
            System.out.println("Không tìm thấy sách!");
        } else {
            list.forEach(book ->
                    System.out.println(
                            book.getId() + " | " +
                                    book.getTitle() + " | " +
                                    book.getAuthor() + " | " +
                                    book.getPublishedYear() + " | " +
                                    book.getPrice()
                    )
            );
        }
    }

    private static String inputString(String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println("Không được để trống!");
        }
    }

    private static int inputInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ!");
            }
        }
    }

    private static double inputDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }
    }
}