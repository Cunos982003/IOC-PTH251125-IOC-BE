package ra.edu.business.impl;

import ra.edu.business.IStudentService;
import ra.edu.model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager implements IStudentService {

    private final ArrayList<Student> students = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void add() {
        int n;
        do {
            System.out.print("Nhập số lượng sinh viên muốn thêm: ");
            n = Integer.parseInt(scanner.nextLine());
            if (n<5) {
                System.out.println("Cần nhập ít nhất 5 sinh viên");
                System.out.print("Nhập số lượng sinh viên muốn thêm: ");
                n = Integer.parseInt(scanner.nextLine());
            }
        } while (n<5);

        for (int i = 0; i < n; i++) {
            System.out.println("Sinh viên " + (i + 1));

            System.out.print("Nhập tên: ");
            String name = scanner.nextLine();

            System.out.print("Nhập GPA: ");
            double gpa = Double.parseDouble(scanner.nextLine());

            students.add(new Student(name, gpa));
        }
        System.out.println("✅ Thêm sinh viên thành công!");
    }

    @Override
    public void display() {
        if (students.isEmpty()) {
            System.out.println("⚠️ Danh sách sinh viên trống!");
            return;
        }

        System.out.println("===== DANH SÁCH SINH VIÊN =====");
        int index = 1;
        for (Student s : students) {
            System.out.println(index++ + ". " + s);
        }
    }

    @Override
    public void searchByName() {
        System.out.print("Nhập tên sinh viên cần tìm: ");
        String keyword = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(keyword)) {
                System.out.println(s);
                found = true;
            }
        }

        if (!found) {
            System.out.println("❌ Không tìm thấy sinh viên!");
        }
    }

    @Override
    public void classifyByGpa() {
        if (students.isEmpty()) {
            System.out.println("⚠️ Chưa có sinh viên để phân loại!");
            return;
        }

        System.out.println("===== PHÂN LOẠI SINH VIÊN =====");
        for (Student s : students) {
            System.out.println(
                    s.getName() + " → GPA: " + s.getGpa() + " → " + s.getRank()
            );
        }
    }
}
