package ra.edu.presentation;

import ra.edu.business.impl.StudentManager;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==========MENU==========");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo tên");
            System.out.println("4. Phân loại sinh viên theo GPA");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        manager.add();
                        break;
                    case 2:
                        manager.display();
                        break;
                    case 3:
                        manager.searchByName();
                        break;
                    case 4:
                        manager.classifyByGpa();
                        break;
                    case 0:
                        System.out.println("👋 Kết thúc chương trình!");
                        return;
                    default:
                        System.out.println("❌ Lựa chọn không hợp lệ!");
                }
        }
    }
}

