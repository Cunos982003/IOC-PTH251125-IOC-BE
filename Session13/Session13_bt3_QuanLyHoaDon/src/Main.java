import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InvoiceManage manager = new InvoiceManage();
        int choice;

        do {
            System.out.println("\n********** MENU QUẢN LÝ HÓA ĐƠN **********");
            System.out.println("1. Thêm hóa đơn");
            System.out.println("2. Sửa hóa đơn");
            System.out.println("3. Xóa hóa đơn");
            System.out.println("4. Hiển thị danh sách hóa đơn");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã hóa đơn: ");
                    String code = sc.nextLine();
                    while(code.isEmpty()){
                        System.out.println("Vui lòng không để trống ");
                        System.out.print("Nhập mã hóa đơn: ");
                        code = sc.nextLine();
                    }

                    System.out.print("Nhập số tiền: ");
                    double amount = Double.parseDouble(sc.nextLine());
                    while(amount < 0) {
                        System.out.println("Vui lòng nhập số thực >= 0 !");
                        System.out.print("Nhập số tiền: ");
                        amount = Double.parseDouble(sc.nextLine());
                    }
                    manager.add(new Invoice(code, amount));
                    break;

                case 2:
                    manager.display();
                    System.out.print("Nhập vị trí hóa đơn cần sửa: ");
                    int updateIndex = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhập mã hóa đơn mới: ");
                    String newCode = sc.nextLine();
                    while(newCode.isEmpty()){
                        System.out.println("Vui lòng không để trống ");
                        System.out.print("Nhập mã hóa đơn: ");
                        newCode = sc.nextLine();
                    }

                    System.out.print("Nhập số tiền mới: ");
                    double newAmount = Double.parseDouble(sc.nextLine());
                    while(newAmount < 0) {
                        System.out.println("Vui lòng nhập số thực >= 0 !");
                        System.out.print("Nhập số tiền: ");
                        newAmount = Double.parseDouble(sc.nextLine());
                    }

                    manager.update(updateIndex, new Invoice(newCode, newAmount));
                    break;

                case 3:
                    manager.display();
                    System.out.print("Nhập vị trí hóa đơn cần xóa: ");
                    int deleteIndex = Integer.parseInt(sc.nextLine());

                    manager.delete(deleteIndex);
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
