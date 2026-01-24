import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("""
           ===== MENU SINH VIÊN =====);
           1. Nhập danh sách sinh viên
           2. In danh sách sinh viên
           3. Tìm sinh viên có GPA cao nhất
           4. In tổng số sinh viên đã tạo
           0. Thoát
            """);
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    Student s = new Student();
                    s.input();
                    students.add(s);
                    System.out.println("Đã thêm sinh viên.");
                    break;
                case 2:
                    System.out.println("\n--- Danh sách sinh viên ---");
                    for (Student st : students) {
                        st.print();
                    }
                    break;
                case 3:
                    if (students.isEmpty()) {
                        System.out.println("Chưa có sinh viên nào.");
                    } else {
                        double maxGpa = -1;
                        ArrayList<Student> topStudents = new ArrayList<>();
                        for (Student st : students) {
                            if (st.getGpa() > maxGpa) {
                                maxGpa = st.getGpa();
                                topStudents.clear();
                                topStudents.add(st);
                            } else if (st.getGpa() == maxGpa) {
                                topStudents.add(st);
                            }
                        }
                        System.out.println("Sinh viên có GPA cao nhất:");
                        for (Student st : topStudents) {
                            st.print();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Tổng số sinh viên: " + Student.getTotalStudent());
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

}