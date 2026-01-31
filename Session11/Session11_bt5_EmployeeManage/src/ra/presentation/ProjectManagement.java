package ra.presentation;

import ra.entity.Employee;
import ra.entity.Project;

import java.util.Arrays;
import java.util.Scanner;

import static ra.entity.Status.*;

public class ProjectManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee[] arrEmp = new Employee[100];
        Project[] arrProject = new Project[50];
        int empIndex = 0;
        int projIndex = 0;

        while (true) {
            System.out.println("""
            ===== QUẢN LÝ DỰ ÁN =====
            1. Quản lý Nhân viên
            2. Quản lý Dự án
            3. Thoát
            =========================
            """);
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("""
                    === Quản lý Nhân viên ===
                     1. Thêm nhân viên
                     2. Hiển thị danh sách nhân viên
                     3. Cập nhật thông tin nhân viên
                     4. Xóa nhân viên
                     5. Tìm kiếm nhân viên theo tên
                     6. Sắp xếp nhân viên theo lương giảm dần
                     7. Thoát
                     ========================
                     """);
                    System.out.print("Lựa chọn của bạn: ");
                    int empChoice = Integer.parseInt(scanner.nextLine());
                    switch (empChoice) {
                        case 1:
                            Employee emp = new Employee();
                            emp.inputData(scanner, arrEmp, empIndex);
                            arrEmp[empIndex++] = emp;
                            break;

                        case 2:
                            for (int i = 0; i < empIndex; i++) {
                                arrEmp[i].displayData();
                            }
                            break;

                        case 3:
                            System.out.print("Nhập mã nhân viên cần cập nhật: ");
                            String idUpdate = scanner.nextLine();
                            for (int i = 0; i < empIndex; i++) {
                                if (arrEmp[i].getEmployeeId().equals(idUpdate)) {
                                    arrEmp[i].inputData(scanner, arrEmp, i);
                                    System.out.println("Đã cập nhật thông tin.");
                                    break;
                                }
                            }
                            break;

                        case 4:
                            System.out.print("Nhập mã nhân viên cần xóa: ");
                            String idDelete = scanner.nextLine();
                            for (int i = 0; i < empIndex; i++) {
                                if (arrEmp[i].getEmployeeId().equals(idDelete)) {
                                    for (int j = i; j < empIndex - 1; j++) {
                                        arrEmp[j] = arrEmp[j + 1];
                                    }
                                    empIndex--;
                                    System.out.println("Đã xóa nhân viên.");
                                    break;
                                }
                            }
                            break;

                        case 5:
                            System.out.print("Nhập tên cần tìm: ");
                            String nameSearch = scanner.nextLine();
                            for (int i = 0; i < empIndex; i++) {
                                if (arrEmp[i].getEmployeeName().toLowerCase().contains(nameSearch.toLowerCase())) {
                                    arrEmp[i].displayData();
                                }
                            }
                            break;

                        case 6:
                            Arrays.sort(arrEmp, 0, empIndex, (a, b) -> Double.compare(b.getSalary(), a.getSalary()));
                            System.out.println("Danh sách sau khi sắp xếp:");
                            for (int i = 0; i < empIndex; i++) {
                                arrEmp[i].displayData();
                            }
                            break;

                        case 7:
                            System.out.println("Thoát menu nhân viên.");
                            break;

                        default:
                            System.out.println("Lựa chọn không hợp lệ!");
                    }
                    break;

                case 2:
                    System.out.println("""
    ===== Quản lý Dự án =====
    1. Thêm dự án
    2. Hiển thị danh sách dự án
    3. Cập nhật thông tin dự án
    4. Xóa dự án (chỉ khi chưa có nhân viên tham gia)
    5. Thêm nhân viên vào dự án
    6. Tìm kiếm dự án theo tên
    7. Thống kê số lượng nhân viên theo vai trò trong từng dự án
    8. Tìm dự án đang chạy và kết thúc gần nhất
    9. Thoát
    ==========================
    """);
                    System.out.print("Lựa chọn của bạn: ");
                    int projChoice = Integer.parseInt(scanner.nextLine());

                    switch (projChoice) {
                        case 1: // Thêm dự án
                            Project proj = new Project();
                            proj.inputData(scanner, arrProject, projIndex, arrEmp, empIndex);
                            arrProject[projIndex++] = proj;
                            break;

                        case 2:
                            for (int i = 0; i < projIndex; i++) {
                                arrProject[i].displayData();
                            }
                            break;

                        case 3:
                            System.out.print("Nhập mã dự án cần cập nhật: ");
                            String idUpdate = scanner.nextLine();
                            for (int i = 0; i < projIndex; i++) {
                                if (arrProject[i].getProjectId().equals(idUpdate)) {
                                    arrProject[i].inputData(scanner, arrProject, i, arrEmp, empIndex);
                                    System.out.println("Đã cập nhật dự án.");
                                    break;
                                }
                            }
                            break;

                        case 4:
                            System.out.print("Nhập mã dự án cần xóa: ");
                            String idDelete = scanner.nextLine();
                            for (int i = 0; i < projIndex; i++) {
                                if (arrProject[i].getProjectId().equals(idDelete) &&
                                        (arrProject[i].getEmployees() == null || arrProject[i].getEmployees().length == 0)) {
                                    for (int j = i; j < projIndex - 1; j++) {
                                        arrProject[j] = arrProject[j + 1];
                                    }
                                    projIndex--;
                                    System.out.println("Đã xóa dự án.");
                                    break;
                                }
                            }
                            break;

                        case 5:
                            System.out.print("Nhập mã dự án: ");
                            String projId = scanner.nextLine();
                            for (int i = 0; i < projIndex; i++) {
                                if (arrProject[i].getProjectId().equals(projId)) {
                                    System.out.print("Nhập mã nhân viên cần thêm: ");
                                    String empId = scanner.nextLine();
                                    for (int j = 0; j < empIndex; j++) {
                                        if (arrEmp[j].getEmployeeId().equals(empId)) {
                                            Employee[] oldEmp = arrProject[i].getEmployees();
                                            if (oldEmp == null) {
                                                arrProject[i].setEmployees(new Employee[]{arrEmp[j]});
                                            } else {
                                                Employee[] newEmp = Arrays.copyOf(oldEmp, oldEmp.length + 1);
                                                newEmp[newEmp.length - 1] = arrEmp[j];
                                                arrProject[i].setEmployees(newEmp);
                                            }
                                            System.out.println("Đã thêm nhân viên vào dự án.");
                                            break;
                                        }
                                    }
                                }
                            }
                            break;

                        case 6:
                            System.out.print("Nhập tên dự án cần tìm: ");
                            String nameSearch = scanner.nextLine();
                            for (int i = 0; i < projIndex; i++) {
                                if (arrProject[i].getProjectName().toLowerCase().contains(nameSearch.toLowerCase())) {
                                    arrProject[i].displayData();
                                }
                            }
                            break;

                        case 7:
                            for (int i = 0; i < projIndex; i++) {
                                System.out.println("Dự án: " + arrProject[i].getProjectName());
                                int dev = 0, tester = 0, pm = 0, ba = 0;
                                if (arrProject[i].getEmployees() != null) {
                                    for (Employee e : arrProject[i].getEmployees()) {
                                        switch (e.getRole()) {
                                            case DEV -> dev++;
                                            case TESTER -> tester++;
                                            case PM -> pm++;
                                            case BA -> ba++;
                                        }
                                    }
                                }
                                System.out.printf("DEV: %d | TESTER: %d | PM: %d | BA: %d\n", dev, tester, pm, ba);
                            }
                            break;

                        case 8:
                            Project nearest = null;
                            for (int i = 0; i < projIndex; i++) {
                                if (arrProject[i].getStatus() == RUNNING ||
                                        arrProject[i].getStatus() == FINISHED) {
                                    if (nearest == null || arrProject[i].getEndDate().isBefore(nearest.getEndDate())) {
                                        nearest = arrProject[i];
                                    }
                                }
                            }
                            if (nearest != null) {
                                System.out.println("Dự án gần nhất:");
                                nearest.displayData();
                            } else {
                                System.out.println("Không có dự án nào đang chạy hoặc đã kết thúc.");
                            }
                            break;

                        case 9: // Thoát menu dự án
                            System.out.println("Thoát menu dự án.");
                            break;

                        default:
                            System.out.println("Lựa chọn không hợp lệ!");
                    }
                    break;

                case 3:
                    System.out.println("Thoát chương trình.");
                    return;
            }
        }
    }
}

