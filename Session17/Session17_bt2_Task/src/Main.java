import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaskManagement manager = new TaskManagement();

        while (true) {
            System.out.println("\n===== TO-DO LIST =====");
            System.out.println("1. Thêm công việc");
            System.out.println("2. Liệt kê");
            System.out.println("3. Cập nhật trạng thái");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Thống kê");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Nhập tên công việc: ");
                        String name = sc.nextLine();
                        if (name.isEmpty()) {
                            System.out.println("❌ Không được để trống!");
                            break;
                        }

                        System.out.print("Trạng thái (chưa hoàn thành / đã hoàn thành): ");
                        String status = sc.nextLine();
                        manager.addTask(name, status);
                        break;

                    case 2:
                        manager.listTasks();
                        break;

                    case 3:
                        System.out.print("Nhập ID: ");
                        int idUpdate = Integer.parseInt(sc.nextLine());
                        System.out.print("Nhập trạng thái mới: ");
                        String newStatus = sc.nextLine();
                        manager.updateTaskStatus(idUpdate, newStatus);
                        break;

                    case 4:
                        System.out.print("Nhập ID cần xóa: ");
                        int idDelete = Integer.parseInt(sc.nextLine());
                        manager.deleteTask(idDelete);
                        break;

                    case 5:
                        System.out.print("Nhập tên cần tìm: ");
                        String search = sc.nextLine();
                        manager.searchTaskByName(search);
                        break;

                    case 6:
                        manager.taskStatistics();
                        break;

                    case 0:
                        System.exit(0);
                }

            } catch (NumberFormatException e) {
                System.out.println("❌ Vui lòng nhập số hợp lệ!");
            }
        }
    }
}