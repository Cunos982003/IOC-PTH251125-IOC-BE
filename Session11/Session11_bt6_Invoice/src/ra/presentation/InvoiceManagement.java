package ra.presentation;

import ra.entity.Invoice;
import ra.entity.InvoiceDetail;
import ra.entity.Product;

import java.util.Date;
import java.util.Scanner;

public class InvoiceManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product[] arrProd = new Product[100];
        Invoice[] arrInvoice = new Invoice[50];
        int invoiceIndex = 0;
        int prodIndex = 0;

        while (true) {
            System.out.println("""
                    ===== QUẢN LÝ HÓA ĐƠN =====
                    1. Quản lý sản phẩm
                    2. Quản lý hóa đơn
                    3. Báo cáo doanh thu
                    4. Thoát
                    =========================
                    """);
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("""
                            === Quản lý sản phẩm ===
                             1. Thêm sản phẩm
                             2. Hiển thị danh sách sản phẩm
                             3. Cập nhật thông tin sản phẩm
                             4. Xóa sản phẩm (nếu chưa có trong hóa đơn nào)
                             5. Tìm kiếm sản phẩm theo tên
                             6. Thoát
                             ========================
                            """);
                    System.out.print("Lựa chọn của bạn: ");
                    int prodChoice = Integer.parseInt(scanner.nextLine());

                    switch (prodChoice) {
                        case 1:
                            Product prod = new Product();
                            prod.inputData(scanner, arrProd, prodIndex);
                            arrProd[prodIndex++] = prod;
                            break;

                        case 2:
                            for (int i = 0; i < prodIndex; i++) {
                                arrProd[i].displayData();
                            }
                            break;

                        case 3:
                            System.out.print("Nhập mã sản phẩm cần cập nhật: ");
                            String idUpdate = scanner.nextLine();
                            for (int i = 0; i < prodIndex; i++) {
                                if (arrProd[i].getProductId().equals(idUpdate)) {
                                    arrProd[i].inputData(scanner, arrProd, i);
                                    System.out.println("Đã cập nhật sản phẩm.");
                                    break;
                                }
                            }
                            break;

                        case 4:
                            System.out.print("Nhập mã sản phẩm cần xóa: ");
                            String idDelete = scanner.nextLine();
                            boolean inInvoice = false;
                            for (int i = 0; i < invoiceIndex; i++) {
                                for (InvoiceDetail d : arrInvoice[i].getInvoiceDetails()) {
                                    if (d.getProduct().getProductId().equals(idDelete)) {
                                        inInvoice = true;
                                        break;
                                    }
                                }
                            }
                            if (!inInvoice) {
                                for (int i = 0; i < prodIndex; i++) {
                                    if (arrProd[i].getProductId().equals(idDelete)) {
                                        for (int j = i; j < prodIndex - 1; j++) {
                                            arrProd[j] = arrProd[j + 1];
                                        }
                                        prodIndex--;
                                        System.out.println("Đã xóa sản phẩm.");
                                        break;
                                    }
                                }
                            } else {
                                System.out.println("Không thể xóa vì sản phẩm đã có trong hóa đơn.");
                            }
                            break;

                        case 5:
                            System.out.print("Nhập tên sản phẩm cần tìm: ");
                            String nameSearch = scanner.nextLine();
                            for (int i = 0; i < prodIndex; i++) {
                                if (arrProd[i].getProductName().toLowerCase().contains(nameSearch.toLowerCase())) {
                                    arrProd[i].displayData();
                                }
                            }
                            break;

                        case 6:
                            System.out.println("Thoát menu sản phẩm.");
                            break;

                        default:
                            System.out.println("Lựa chọn không hợp lệ!");
                    }
                    break;

                case 2:
                    System.out.println("""
                            ===== Quản lý hóa đơn =====
                            1. Thêm hóa đơn
                            2. Hiển thị danh sách hóa đơn
                            3. Cập nhật thông tin hóa đơn
                            4. Xóa hóa đơn
                            5. Tìm kiếm hóa đơn theo mã
                            6. Tìm kiếm hóa đơn theo tên khách hàng
                            7. Thoát
                            ==========================
                            """);
                    System.out.print("Lựa chọn của bạn: ");
                    int invoiceChoice = Integer.parseInt(scanner.nextLine());

                    switch (invoiceChoice) {
                        case 1:
                            Invoice inv = new Invoice();
                            inv.inputData(scanner, arrProd, prodIndex);
                            arrInvoice[invoiceIndex++] = inv;
                            break;

                        case 2:
                            for (int i = 0; i < invoiceIndex; i++) {
                                arrInvoice[i].displayData();
                            }
                            break;

                        case 3:
                            System.out.print("Nhập mã hóa đơn cần cập nhật: ");
                            String idUpdate = scanner.nextLine();
                            for (int i = 0; i < invoiceIndex; i++) {
                                if (arrInvoice[i].getInvoiceId().equals(idUpdate)) {
                                    arrInvoice[i].inputData(scanner, arrProd, prodIndex);
                                    System.out.println("Đã cập nhật hóa đơn.");
                                    break;
                                }
                            }
                            break;

                        case 4:
                            System.out.print("Nhập mã hóa đơn cần xóa: ");
                            String idDelete = scanner.nextLine();
                            for (int i = 0; i < invoiceIndex; i++) {
                                if (arrInvoice[i].getInvoiceId().equals(idDelete)) {
                                    for (int j = i; j < invoiceIndex - 1; j++) {
                                        arrInvoice[j] = arrInvoice[j + 1];
                                    }
                                    invoiceIndex--;
                                    System.out.println("Đã xóa hóa đơn.");
                                    break;
                                }
                            }
                            break;

                        case 5:
                            System.out.print("Nhập mã hóa đơn cần tìm: ");
                            String idSearch = scanner.nextLine();
                            for (int i = 0; i < invoiceIndex; i++) {
                                if (arrInvoice[i].getInvoiceId().equals(idSearch)) {
                                    arrInvoice[i].displayData();
                                }
                            }
                            break;

                        case 6:
                            System.out.print("Nhập tên khách hàng cần tìm: ");
                            String nameSearch = scanner.nextLine();
                            for (int i = 0; i < invoiceIndex; i++) {
                                if (arrInvoice[i].getCustomerName().toLowerCase().contains(nameSearch.toLowerCase())) {
                                    arrInvoice[i].displayData();
                                }
                            }
                            break;

                        case 7:
                            System.out.println("Thoát menu hóa đơn.");
                            break;

                        default:
                            System.out.println("Lựa chọn không hợp lệ!");
                    }
                    break;

                case 3:
                    System.out.println("""
                            ===== Quản lý doanh thu =====
                            1. Tính tổng doanh thu các hóa đơn
                            2. Tìm hóa đơn có giá trị lớn nhất
                            3. Thống kê số hóa đơn theo khoảng ngày (nhập từ - đến)
                            4. Thống kê tổng doanh thu theo khoảng ngày
                            5. Thoát
                            ==========================
                            """);
                    System.out.print("Lựa chọn của bạn: ");
                    int revChoice = Integer.parseInt(scanner.nextLine());

                    switch (revChoice) {
                        case 1:
                            double totalRevenue = 0;
                            for (int i = 0; i < invoiceIndex; i++) {
                                totalRevenue += arrInvoice[i].getTotalAmount();
                            }
                            System.out.printf("Tổng doanh thu: %.2f\n", totalRevenue);
                            break;

                        case 2:
                            if (invoiceIndex > 0) {
                                Invoice maxInvoice = arrInvoice[0];
                                for (int i = 1; i < invoiceIndex; i++) {
                                    if (arrInvoice[i].getTotalAmount() > maxInvoice.getTotalAmount()) {
                                        maxInvoice = arrInvoice[i];
                                    }
                                }
                                System.out.println("Hóa đơn có giá trị lớn nhất:");
                                maxInvoice.displayData();
                            } else {
                                System.out.println("Chưa có hóa đơn nào.");
                            }
                            break;

                        case 3:
                            try {
                                System.out.print("Nhập ngày bắt đầu (yyyy-MM-dd): ");
                                Date fromDate = java.sql.Date.valueOf(scanner.nextLine());
                                System.out.print("Nhập ngày kết thúc (yyyy-MM-dd): ");
                                Date toDate = java.sql.Date.valueOf(scanner.nextLine());

                                int count = 0;
                                for (int i = 0; i < invoiceIndex; i++) {
                                    Date invDate = arrInvoice[i].getInvoiceDate();
                                    if (!invDate.before(fromDate) && !invDate.after(toDate)) {
                                        count++;
                                    }
                                }
                                System.out.println("Số hóa đơn trong khoảng ngày: " + count);
                            } catch (Exception e) {
                                System.out.println("Ngày nhập không hợp lệ.");
                            }
                            break;

                        case 4:
                            try {
                                System.out.print("Nhập ngày bắt đầu (yyyy-MM-dd): ");
                                Date fromDate = java.sql.Date.valueOf(scanner.nextLine());
                                System.out.print("Nhập ngày kết thúc (yyyy-MM-dd): ");
                                Date toDate = java.sql.Date.valueOf(scanner.nextLine());

                                double sumRevenue = 0;
                                for (int i = 0; i < invoiceIndex; i++) {
                                    Date invDate = arrInvoice[i].getInvoiceDate();
                                    if (!invDate.before(fromDate) && !invDate.after(toDate)) {
                                        sumRevenue += arrInvoice[i].getTotalAmount();
                                    }
                                }
                                System.out.printf("Tổng doanh thu trong khoảng ngày: %.2f\n", sumRevenue);
                            } catch (Exception e) {
                                System.out.println("Ngày nhập không hợp lệ.");
                            }
                            break;

                        case 5:
                            System.out.println("Thoát menu doanh thu.");
                            break;

                        default:
                            System.out.println("Lựa chọn không hợp lệ!");
                    }
                    break;

                case 4:
                    System.out.println("Thoát chương trình.");
                    return;
            }
        }
    }
}


