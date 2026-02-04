import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AttendanceManager manager = new AttendanceManager();
        int choice;

        do {
            System.out.println("************** MENU QUẢN LÝ ĐIỂM DANH **************");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Hiển thị danh sách sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên sinh viên: ");
                    String name = sc.nextLine();
                    while (name.isEmpty()) {
                        System.out.println("Vui lòng ko để trống !");
                        System.out.print("Nhập tên sinh viên: ");
                        name = sc.nextLine();
                    }
                    manager.add(new Student(1, name));
                    break;

                case 2:
                    manager.display();
                    System.out.print("Nhập id sinh viên cần sửa: ");
                    int updateId = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhập tên mới sinh viên: ");
                    String newName = sc.nextLine();
                    while (newName.isEmpty()) {
                        System.out.println("Vui lòng ko để trống !");
                        System.out.print("Nhập tên mới sinh viên: ");
                        newName = sc.nextLine();
                    }

                    manager.update(updateId, newName);
                    break;

                case 3:
                    manager.display();
                    System.out.print("Nhập id sinh viên cần xóa: ");
                    int deleteId = Integer.parseInt(sc.nextLine());

                    manager.delete(deleteId);
                    break;

                case 4:
                    manager.display();
                    break;

                case 5:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 5);

        sc.close();
    }
}
