package ra.entity;

import java.util.Scanner;

public class Employee {
    private String employeeId;
    private String employeeName;
    private Role role;
    private double salary;

    public Employee() {
    }

    public Employee(String employeeId, String employeeName, Role role, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.role = role;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void inputData(Scanner scanner, Employee[] arrEmp, int index) {
        while (true) {
            System.out.print("Nhập mã nhân viên (Exxxx): ");
            String id = scanner.nextLine();
            if (id.matches("^E\\d{4}$")) {
                boolean exists = false;
                for (int i = 0; i < index; i++) {
                    if (arrEmp[i].getEmployeeId().equals(id)) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    this.employeeId = id;
                    break;
                } else {
                    System.out.println("Mã nhân viên đã tồn tại, nhập lại!");
                }
            } else {
                System.out.println("Mã nhân viên phải bắt đầu bằng E và có 5 ký tự (ví dụ: E0001).");
            }
        }
        while (true) {
            System.out.print("Nhập tên nhân viên (6–30 ký tự): ");
            String name = scanner.nextLine();
            if (name.length() >= 6 && name.length() <= 30) {
                this.employeeName = name;
                break;
            } else {
                System.out.println("Tên nhân viên phải từ 6–30 ký tự.");
            }
        }
        while (true) {
            System.out.print("Chọn vai trò (DEV/TESTER/PM/BA): ");
            try {
                this.role = Role.valueOf(scanner.nextLine().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Vai trò không hợp lệ, nhập lại!");
            }
        }
        while (true) {
            System.out.print("Nhập lương (>0): ");
            try {
                double sal = Double.parseDouble(scanner.nextLine());
                if (sal > 0) {
                    this.salary = sal;
                    break;
                } else {
                    System.out.println("Lương phải > 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lương phải là số.");
            }
        }
    }
    public void displayData() {
        System.out.printf("ID: %s | Tên: %s | Vai trò: %s | Lương: %.2f\n",
                employeeId, employeeName, role, salary);
    }

}
