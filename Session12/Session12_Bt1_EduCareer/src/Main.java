import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Staff> staffList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do{
            System.out.println("""
                    ================EDU CAREER=============
                    1. Thêm mới nhân viên
                    2. Hiển thị danh sách
                    3. Cập nhật thông tin
                    4. Xóa nhân viên
                    5. Thoát
                    ========================================
                    """);
            System.out.print("Chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
            case 1:
                System.out.println("Thêm (1: Giảng viên, 2: Admin): ");
                int type = sc.nextInt();
                sc.nextLine();
                System.out.print("Nhập ID: ");
                String id = sc.nextLine();
                System.out.print("Nhập tên: ");
                String name = sc.nextLine();
                System.out.print("Nhập lương cơ bản: ");
                double baseSalary = sc.nextDouble();

                if (type == 1) {
                    System.out.print("Nhập số giờ giảng: ");
                    int hours = sc.nextInt();
                    staffList.add(new Lecturer(id, name, baseSalary, hours));
                } else {
                    System.out.print("Nhập bonus: ");
                    double bonus = sc.nextDouble();
                    staffList.add(new AdminStaff(id, name, baseSalary, bonus));
                }
                break;
            case 2:
                System.out.println("===== DANH SÁCH NHÂN VIÊN =====");
                for (Staff s : staffList) {
                    System.out.println("ID: " + s.getId() + ", Tên: " + s.getName() +
                            ", Lương thực nhận: " + s.calculateTotalSalary());
                    s.checkPerformance();
                }
                break;
            case 3:
                System.out.print("Nhập ID cần cập nhật: ");
                String updateId = sc.nextLine();
                for (Staff s : staffList) {
                    if (s.getId().equals(updateId)) {
                        System.out.print("Nhập tên mới: ");
                        String newName = sc.nextLine();
                        System.out.print("Nhập lương cơ bản mới: ");
                        double newBase = sc.nextDouble();
                        sc.nextLine();
                        s.name = newName;
                        s.baseSalary = newBase;
                        System.out.println("Cập nhật thành công!");
                    }
                }
                break;
            case 4:
                System.out.print("Nhập ID cần xóa: ");
                String deleteId = sc.nextLine();
                staffList.removeIf(s -> s.getId().equals(deleteId));
                System.out.println("Xóa thành công!");
                break;
            case 5:
                System.out.println("Thoát chương trình.");
                break;
            default:
                    System.out.println("Lựa chọn không hợp lệ!");

            }
        } while (choice != 5);
    }
}