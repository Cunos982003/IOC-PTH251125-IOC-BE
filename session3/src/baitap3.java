import java.text.DecimalFormat;
import java.util.Scanner;

public class baitap3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        int tongSoNhanVien = 0;
        double tongLuong = 0;
        double luongCaoNhat = Double.MIN_VALUE;
        double luongThapNhat = Double.MAX_VALUE;
        String xepLoai = "";
        double tongThuong = 0;
        DecimalFormat df = new DecimalFormat("#,###");

        while (true) {
            System.out.println("****************MENU*********************");
            System.out.println("1. Nhập lương nhân viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Tính tổng số tiền thưởng cho nhân viên");
            System.out.println("4. Thoát");
            System.out.printf("Lựa chọn của bạn: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    while (true) {
                        System.out.println("\nNhập lương nhân viên (nhập -1 để kết thúc) ");
                        System.out.printf("Nhập lương: ");
                        double luong = input.nextDouble();
                        if (luong == -1) {
                            break;
                        }
                        if (luong < 0 || luong > 500000000) {
                            System.err.println("Lương không hợp lệ, vui lòng nhập lại! ");
                            continue;
                        }
                        tongSoNhanVien++;
                        tongLuong += luong;
                        if (luong > luongCaoNhat) luongCaoNhat = luong;
                        if (luong < luongThapNhat) luongThapNhat = luong;
                        if (luong < 5000000) {
                            xepLoai = "Thu nhập thấp";
                        } else if (luong < 15000000) {
                            xepLoai = "Thu nhập trung bình";
                        } else if (luong < 500000000) {
                            xepLoai = "Thu nhập khá";
                        } else {
                            xepLoai = "Thu nhập cao";
                        }
                        System.out.println("→ Phân loại: " + xepLoai);

                        double thuong;
                        if (luong <= 5000000) {
                            thuong = luong * 0.05;
                        } else if (luong <= 15000000) {
                            thuong = luong * 0.10;
                        } else if (luong <= 50000000) {
                            thuong = luong * 0.15;
                        } else if (luong <= 100000000) {
                            thuong = luong * 0.20;
                        } else {
                            thuong = luong * 0.25;
                        }
                        tongThuong += thuong;
                    }
                    break;

                case 2:
                    System.out.println("\n===== KẾT QUẢ =====");
                    if (tongSoNhanVien == 0) {
                        System.out.println("Chưa có dữ liệu");
                    } else {
                        double luongTrungBinh = tongLuong / tongSoNhanVien;
                        System.out.println("Số nhân viên đã nhập: " + tongSoNhanVien);
                        System.out.println("Lương trung bình: " + df.format(luongTrungBinh) + " VNĐ");
                        System.out.println("Lương cao nhất: " + df.format(luongCaoNhat) + " VNĐ ");
                        System.out.println("Lương thấp nhất: " + df.format(luongThapNhat) + " VNĐ ");
                    }
                    break;

                case 3:
                    System.out.println("\n===== TÍNH THƯỞNG =====");
                    if (tongSoNhanVien == 0) {
                        System.out.println("Chưa có dữ liệu");
                    } else {
                        System.out.println("Tổng số tiền thưởng cho nhân viên: " + df.format(tongThuong) + " VNĐ");
                    }
                    break;


                case 4:
                    System.out.println("Thoát chương trình! Tạm biệt");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ! Vui lòng thử lại");
                    break;
            }
        }
    }
}