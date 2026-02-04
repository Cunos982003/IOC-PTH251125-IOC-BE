import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OrderManager manager = new OrderManager();
        int choice;

        do {
            System.out.println("\n********** MENU QUẢN LÝ ĐƠN HÀNG **********");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. Sửa đơn hàng");
            System.out.println("3. Xóa đơn hàng");
            System.out.println("4. Hiển thị danh sách đơn hàng");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    String orderCode;
                    do {
                        System.out.print("Nhập mã đơn hàng: ");
                        orderCode = sc.nextLine();
                        if (orderCode.isEmpty()) {
                            System.out.println("Vui lòng không để trống !");
                        }
                    } while (orderCode.isEmpty());

                    String customerName;
                    do {
                        System.out.print("Nhập tên khách hàng: ");
                        customerName = sc.nextLine();
                        if (customerName.isEmpty()) {
                            System.out.println("Vui lòng không để trống !");
                        }
                    } while (customerName.isEmpty());

                    manager.add(new Order(orderCode, customerName));
                    break;

                case 2:
                    manager.display();
                    System.out.print("Nhập mã đơn hàng cần sửa: ");
                    String oldCode = sc.nextLine();
                    String newCustomer;
                    do {
                        System.out.print("Nhập tên khách hàng mới: ");
                        newCustomer = sc.nextLine();
                        if (newCustomer.isEmpty()) {
                            System.out.println("Vui lòng không để trống!");
                        }
                    } while (newCustomer.isEmpty());

                    manager.update(oldCode, new Order(oldCode, newCustomer));
                    break;


                case 3:
                    manager.display();
                    System.out.print("Nhập mã đơn hàng cần xóa: ");
                    String deleteCode = sc.nextLine();
                    manager.delete(deleteCode);

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
