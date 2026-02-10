package ra.edu.presentation;

import ra.edu.model.*;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SubjectManager<Subject> manager = new SubjectManager<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        while (true) {
            System.out.println("\n===== QUẢN LÝ MÔN HỌC =====");
            System.out.println("1. Hiển thị danh sách môn học");
            System.out.println("2. Thêm môn học");
            System.out.println("3. Xóa môn học theo code");
            System.out.println("4. Tìm kiếm môn học theo tên");
            System.out.println("5. Lọc môn học có tín chỉ > 3");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        manager.displayAll();
                        break;

                    case 2:
                        Subject subject = new Subject();
                        subject.inputData(sc);
                        manager.add(subject);
                        System.out.println("Thêm môn học thành công!");
                        break;

                    case 3:
                        System.out.print("Nhập code cần xóa: ");
                        manager.deleteByCode(sc.nextLine());
                        break;

                    case 4:
                        System.out.print("Nhập tên môn học cần tìm: ");
                        manager.searchByName(sc.nextLine());
                        break;

                    case 5:
                        manager.filterByCredits();
                        break;

                    case 0:
                        System.out.println("Thoát chương trình!");
                        return;

                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            }
        }
    }
}
