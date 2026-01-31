package ra.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Invoice {
    private String invoiceId;
    private String customerName;
    private Date invoiceDate;
    private InvoiceDetail[] invoiceDetails;
    private double totalAmount;

    public Invoice() {
    }

    public Invoice(String invoiceId, String customerName, Date invoiceDate,
                   InvoiceDetail[] invoiceDetails) {
        this.invoiceId = invoiceId;
        this.customerName = customerName;
        this.invoiceDate = invoiceDate;
        this.invoiceDetails = invoiceDetails;
        calculateTotalAmount();
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public InvoiceDetail[] getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(InvoiceDetail[] invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void inputData(Scanner scanner, Product[] arrProd, int prodIndex) {
        while (true) {
            System.out.print("Nhập mã hóa đơn (HDxxxx): ");
            String id = scanner.nextLine();
            if (id.matches("^HD\\d{4}$")) {
                this.invoiceId = id;
                break;
            } else {
                System.out.println("Mã hóa đơn phải bắt đầu bằng HD và có 6 ký tự.");
            }
        }

        System.out.print("Nhập tên khách hàng: ");
        this.customerName = scanner.nextLine();

        this.invoiceDate = new Date();
        System.out.print("Nhập số lượng sản phẩm trong hóa đơn: ");
        int n = Integer.parseInt(scanner.nextLine());
        this.invoiceDetails = new InvoiceDetail[n];
        for (int i = 0; i < n; i++) {
            InvoiceDetail detail = new InvoiceDetail();
            detail.inputData(scanner, arrProd, prodIndex);
            this.invoiceDetails[i] = detail;
        }

        calculateTotalAmount();
    }

    public void calculateTotalAmount() {
        this.totalAmount = 0;
        if (invoiceDetails != null) {
            for (InvoiceDetail d : invoiceDetails) {
                this.totalAmount += d.getSubTotal();
            }
        }
    }

    public void displayData() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("===== THÔNG TIN HÓA ĐƠN =====");
        System.out.println("Mã hóa đơn: " + invoiceId);
        System.out.println("Tên khách hàng: " + customerName);
        System.out.println("Ngày lập: " + sdf.format(invoiceDate));
        System.out.println("Danh sách sản phẩm:");

        if (invoiceDetails != null) {
            for (InvoiceDetail detail : invoiceDetails) {
                detail.displayData();
            }
        }

        System.out.printf("Tổng tiền hóa đơn: %.2f\n", totalAmount);
        System.out.println("==============================");
    }
}