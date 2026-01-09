import java.text.DecimalFormat;
import java.util.Scanner;


public class baitap1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==========NHẬP THÔNG TIN HÓA ĐƠN===========");
        System.out.printf("Nhập tên khách hàng: ");
        String tenKhachHang = sc.nextLine();
        System.out.printf("Nhập tên sản phẩm: ");
        String tenSanPham = sc.nextLine();
        System.out.printf("Giá sản phẩm: ");
        double giaSanPham = sc.nextDouble();
        System.out.printf("Số lượng mua: ");
        int soLuong =  sc.nextInt();
        System.out.printf("Khách hàng có thẻ thành viên hay không (True/False): ");
        boolean laThanhVien = sc.nextBoolean();

        double thanhTien = giaSanPham * soLuong;
        double giamGia = 0;
        if(laThanhVien) {
            giamGia = thanhTien * 0.10;
        }
        double vat = (thanhTien - giamGia)*0.08;
        double tongThanhToan = thanhTien - giamGia + vat;

        DecimalFormat df = new DecimalFormat("#,###");

        System.out.println("\n===== HÓA ĐƠN =====");
        System.out.println("Khách hàng: " + tenKhachHang);
        System.out.println("Sản phẩm: " + tenSanPham);
        System.out.println("Giá sản phẩm: " + df.format(giaSanPham) + " VNĐ");
        System.out.println("Số lượng: " + soLuong);
        System.out.println("Thành tiền: " + df.format(thanhTien) + "VNĐ");
        System.out.println("Giảm giá thành viên (10%): " + df.format(giamGia) + " VNĐ");
        System.out.println("Tiền VAT (8%): " + df.format(vat) + "VNĐ");
        System.out.println("Tổng thanh toán: " + df.format(tongThanhToan) + " VNĐ");
        System.out.println("======================");

        sc.close();
    }
}
