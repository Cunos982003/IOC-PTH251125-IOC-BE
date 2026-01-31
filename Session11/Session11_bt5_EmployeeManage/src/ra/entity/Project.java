package ra.entity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Project {
    private String projectId;
    private String projectName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Employee[] employees;
    private Status status;

    public Project() {
    }

    public Project(String projectId, String projectName, LocalDate startDate, LocalDate endDate, Employee[] employees, Status status) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employees = employees;
        this.status = status;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void inputData(Scanner scanner, Project[] arrProject, int index,
                          Employee[] arrEmp, int empIndex) {
        while (true) {
            System.out.print("Nhập mã dự án (Pxxxx): ");
            String id = scanner.nextLine();
            if (id.matches("^P\\d{4}$")) {
                boolean exists = false;
                for (int i = 0; i < index; i++) {
                    if (arrProject[i].getProjectId().equals(id)) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    this.projectId = id;
                    break;
                } else {
                    System.out.println("Mã dự án đã tồn tại, nhập lại!");
                }
            } else {
                System.out.println("Mã dự án phải bắt đầu bằng P và có 5 ký tự (ví dụ: P0001).");
            }
        }
        while (true) {
            System.out.print("Nhập tên dự án (10–50 ký tự): ");
            String name = scanner.nextLine();
            if (name.length() >= 10 && name.length() <= 50) {
                boolean exists = false;
                for (int i = 0; i < index; i++) {
                    if (arrProject[i].getProjectName().equalsIgnoreCase(name)) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    this.projectName = name;
                    break;
                } else {
                    System.out.println("Tên dự án đã tồn tại, nhập lại!");
                }
            } else {
                System.out.println("Tên dự án phải từ 10–50 ký tự.");
            }
        }
        while (true) {
            try {
                System.out.print("Nhập ngày bắt đầu (yyyy-MM-dd): ");
                this.startDate = LocalDate.parse(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Ngày không hợp lệ, nhập lại!");
            }
        }

        while (true) {
            try {
                System.out.print("Nhập ngày kết thúc (yyyy-MM-dd): ");
                LocalDate end = LocalDate.parse(scanner.nextLine());
                if (!end.isBefore(this.startDate)) {
                    this.endDate = end;
                    break;
                } else {
                    System.out.println("Ngày kết thúc phải >= ngày bắt đầu.");
                }
            } catch (Exception e) {
                System.out.println("Ngày không hợp lệ, nhập lại!");
            }
        }

        while (true) {
            System.out.print("Chọn trạng thái (PLANNING/RUNNING/FINISHED): ");
            try {
                this.status = Status.valueOf(scanner.nextLine().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Trạng thái không hợp lệ, nhập lại!");
            }
        }

        this.employees = Arrays.copyOf(arrEmp, empIndex);
    }

    public void displayData() {
        System.out.printf("ID: %s | Tên dự án: %s | Bắt đầu: %s | Kết thúc: %s | Trạng thái: %s\n",
                projectId, projectName, startDate, endDate, status);
        System.out.println("Danh sách nhân viên:");
        if (employees != null) {
            for (Employee emp : employees) {
                emp.displayData();
            }
        }
    }
}
