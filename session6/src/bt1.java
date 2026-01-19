import java.util.Arrays;
import java.util.Scanner;

public class bt1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] diem = null;
        boolean isActive = false;
        int choice;
        while (true) {
            System.out.println("""
                    ************QUẢN LÝ ĐIỂM SV*******************
                    1. Nhập danh sách điểm sinh viên
                    2. In danh sách điểm
                    3. Tính điểm trung bình của các sinh viên
                    4. Tìm điểm cao nhất và thấp nhất
                    5. Đếm số sinh viên đỗ và trượt
                    6. Sắp xếp điểm tăng dần
                    7. Thống kê số lượng sinh viên giỏi và xuất sắc
                    8. Thoát
                    ********************************************
                    """);
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());
            if(choice>=2 &&choice<=7){
                if (!isActive){
                    System.err.println("Bạn phải lựa chọn chức năng 1 trước");
                    continue;
                }
            }
            switch (choice) {
                case 1:
                    isActive = true;
                    System.out.print("Nhập số lượng sinh viên: ");
                    int n = sc.nextInt();
                    diem = new double[n];
                    for (int i = 0; i < n; i++) {
                        System.out.print("Nhập điểm SV " + (i + 1) + ": ");
                        diem[i] = sc.nextDouble();
                    }
                    sc.nextLine();
                break;

                case 2:
                    System.out.println("Danh sách điểm sinh viên:");
                    for (int i = 0; i < diem.length; i++) {
                        System.out.println("SV " + (i + 1) + ": " + diem[i]);
                    }
            break;

                case 3:
                    double sum = 0;
                    for (double d : diem) sum += d;
                    System.out.println("Điểm trung bình: " + (sum / diem.length));
                    break;

                case 4:
                    double max = diem[0], min = diem[0];
                    for (double d : diem) {
                        if (d > max) max = d;
                        if (d < min) min = d;
                    }
                    System.out.println("Điểm cao nhất: " + max);
                    System.out.println("Điểm thấp nhất: " + min);
                    break;

                case 5:
                    int doCount = 0, truotCount = 0;
                    for (double d : diem) {
                        if (d >= 5) doCount++;
                        else truotCount++;
                    }
                    System.out.println("Số SV đỗ: " + doCount);
                    System.out.println("Số SV trượt: " + truotCount);
                    break;
                case 6:
                    Arrays.sort(diem);
                    System.out.println("Danh sách điểm sau khi sắp xếp tăng dần:");
                    for (double d : diem) System.out.print(d + " ");
                    System.out.println();
                    break;
                case 7:
                    int count = 0;
                    for (double d : diem) {
                        if (d >= 8) count++;
                    }
                    System.out.println("Số lượng SV giỏi và xuất sắc: " + count);
                    break;

                case 8:
                    System.out.println("Thoát chương trình! Tạm biệt");
                    sc.close();
                    return;
                default:
                    System.err.println("Lựa chọn không hợp lệ !!!");

            }
        }
    }
}