import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserManager manager = new UserManager();
        int choice;
        do {
            System.out.println("********** MENU QUẢN LÝ NGƯỜI DÙNG **********");
            System.out.println("1. Thêm người dùng");
            System.out.println("2. Xóa người dùng");
            System.out.println("3. Hiển thị danh sách người dùng");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên người dùng: ");
                    String name = sc.nextLine();
                    while (name.isEmpty()) {
                        System.out.println("Vui lòng ko để trống !");
                        System.out.print("Nhập tên người dùng: ");
                        name = sc.nextLine();
                    }

                    System.out.print("Nhập email người dùng: ");
                    String email = sc.nextLine();
                    while (email.isEmpty()) {
                        System.out.println("Vui lòng ko để trống !");
                        System.out.print("Nhập email người dùng: ");
                        email = sc.nextLine();
                    }

                    System.out.print("Nhập số điện thoại người dùng: ");
                    String phone = sc.nextLine();
                    while (phone.isEmpty()) {
                        System.out.println("Vui lòng ko để trống !");
                        System.out.print("Nhập số điện thoại người dùng: ");
                        phone = sc.nextLine();
                    }

                    manager.addUser(new Person(name, email, phone));
                    break;

                case 2:
                    System.out.print("Nhập email cần xóa: ");
                    String deleteEmail = sc.nextLine();
                    manager.deleteUserByEmail(deleteEmail);
                    break;

                case 3:
                    manager.displayUsers();
                    break;

                case 4:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 4);

        sc.close();
    }
}