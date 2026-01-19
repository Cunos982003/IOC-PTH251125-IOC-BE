import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class bt3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isActive = false;
        List<String> bienSoList = new ArrayList<>();

        while (true) {
            System.out.println("""
                    ************QUẢN LÝ BIỂN SỐ XE*******************
                    1. Thêm các biển số xe
                    2. Hiển thị danh sách biển số xe
                    3. Tìm kiếm biển số xe
                    4. Tìm kiếm biển số xe theo mã tỉnh
                    5. Sắp xếp biển số xe tăng dần
                    6. Thoát
                    """);
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            if(choice>=2 &&choice<=5){
                if (!isActive){
                    System.err.println("Bạn phải lựa chọn chức năng 1 trước");
                    continue;
                }
            }
            switch (choice) {
                case 1:
                    isActive = true;
                    System.out.print("Nhập số lượng biển số muốn thêm: ");
                    int n = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < n; i++) {
                        System.out.print("Nhập biển số xe " + (i + 1) + ": ");
                        String bienSo = sc.nextLine().trim();
                        bienSoList.add(bienSo);
                    }
                        sc.nextLine();
                        break;

                case 2:
                    System.out.println("Danh sách biển số xe:");
                    bienSoList.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Nhập biển số cần tìm: ");
                    String search = sc.nextLine().trim();
                    if (bienSoList.contains(search)) {
                        System.out.println("Đã tìm thấy biển số: " + search);
                    } else {
                        System.out.println("Không tìm thấy!");
                    }
                    break;

                case 4:
                    System.out.print("Nhập mã tỉnh cần tìm (VD: 29, 30, 51...): ");
                    String maTinh = sc.nextLine().trim();
                    boolean found = false;
                    for (String bs : bienSoList) {
                        if (bs.startsWith(maTinh)) {
                            System.out.println(bs);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Không có biển số nào thuộc mã tỉnh " + maTinh);
                    }
                    break;

                case 5:
                    Collections.sort(bienSoList);
                    System.out.println("Danh sách biển số sau khi sắp xếp tăng dần:");
                    bienSoList.forEach(System.out::println);
                    break;

                case 6:
                    System.out.println("Thoát chương trình! Tạm biệt");
                    sc.close();
                    return;
                default:
                    System.err.println("Lựa chọn không hợp lệ !!!");

            }
        }
    }
}
