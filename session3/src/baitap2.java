import java.util.Scanner;

public class baitap2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        int tongSoHocVien = 0;
        double tongDiem = 0;
        double diemCaoNhat = Double.MIN_VALUE;
        double diemThapNhat = Double.MAX_VALUE;
        String xepLoai = "";
        while (true) {
            System.out.println("****************MENU*********************");
            System.out.println("1. Nhập điểm học viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Thoát");
            System.out.printf("Lựa chọn của bạn: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    while (true) {
                        System.out.println("\nNhập điểm học viên (0-10, nhập -1 để kết thúc) ");
                        System.out.printf("Nhập điểm: ");
                        double diem = input.nextDouble();
                        if (diem == -1) {
                            break;
                        }
                        if (diem < 0 || diem > 10) {
                            System.err.println("Điểm không hợp lệ, vui lòng nhập lại! ");
                            System.out.printf("Nhập điểm: ");
                            continue;
                        }
                        tongSoHocVien++;
                        tongDiem += diem;
                        if (diem > diemCaoNhat) diemCaoNhat = diem;
                        if (diem < diemThapNhat) diemThapNhat = diem;
                        if (diem < 5) {
                            xepLoai = "Yếu";
                        } else if (diem < 7) {
                            xepLoai = "Trung bình";
                        } else if (diem < 8) {
                            xepLoai = "Khá";
                        } else if (diem < 9) {
                            xepLoai = "Giỏi";
                        } else {
                            xepLoai = "Xuất sắc";
                        }
                        System.out.println("→ Điểm: " + diem + " | Xếp loại: " + xepLoai);
                    }
                    break;

                case 2:
                    System.out.println("\n===== KẾT QUẢ =====");
                    if (tongSoHocVien == 0) {
                        System.out.println("Chưa có dữ liệu");
                    } else {
                        double diemTrungBinh = tongDiem / tongSoHocVien;
                        System.out.println("Số học viên đã nhập: " + tongSoHocVien);
                        System.out.printf("Điểm trung bình: %.2f ", diemTrungBinh);
                        System.out.println("\nĐiểm cao nhất: " + diemCaoNhat);
                        System.out.println("Điểm thấp nhất: " + diemThapNhat);
                    }
                    break;

                case 3:
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
