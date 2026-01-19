import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class bt2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isActive = false;
        String hoTen = null;
        String email = null;
        String phone = null;
        String passWord = null;

        int choice;
        while (true) {
            System.out.println("""
                    ************QUẢN LÝ NGƯỜI DÙNG*******************
                    1. Nhập thông tin người dùng
                    2. Chuẩn hóa họ tên
                    3. Kiểm tra email hợp lệ
                    4. Kiểm tra số điện thoại hợp lệ
                    5. Kiểm tra mật khẩu hợp lệ
                    6. Thoát
                    """);
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());
            if(choice>=2 &&choice<=5){
                if (!isActive){
                    System.err.println("Bạn phải lựa chọn chức năng 1 trước");
                    continue;
                }
            }
            switch (choice) {
                case 1:
                    isActive = true;
                    System.out.print("Nhập họ và tên: ");
                    hoTen = sc.nextLine();
                    System.out.print("Nhập email: ");
                    email = sc.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    phone = sc.nextLine();
                    System.out.print("Nhập mật khẩu: ");
                    passWord = sc.nextLine();
                    sc.nextLine();
                    break;

                case 2:
                    hoTen = hoTen.trim().replaceAll("\\s+", " ");
                    String[] words = hoTen.split(" ");
                    StringBuilder sb = new StringBuilder();
                    for (String w : words) {
                        sb.append(Character.toUpperCase(w.charAt(0)))
                                .append(w.substring(1).toLowerCase())
                                .append(" ");
                    }
                    hoTen = sb.toString().trim();
                    System.out.println("Họ tên sau chuẩn hóa: " + hoTen);
                    break;

                case 3:
                    String regexEmail = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
                    if (Pattern.matches(regexEmail, email)) {
                        System.out.println("Email hợp lệ: " + email);
                    } else {
                        System.out.println("Email KHÔNG hợp lệ!");
                    }
                    break;

                case 4:
                    String regexPhone = "^(0[3|5|7|8|9][0-9]{8}|\\+84[3|5|7|8|9][0-9]{8})$";
                    if (Pattern.matches(regexPhone, phone)) {
                        System.out.println("Số điện thoại hợp lệ: " + phone);
                    } else {
                        System.out.println("Số điện thoại KHÔNG hợp lệ!");
                    }
                    break;

                case 5:
                    String regexPass = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
                    if (Pattern.matches(regexPass, passWord)) {
                        System.out.println("Mật khẩu hợp lệ.");
                    } else {
                        System.out.println("Mật khẩu KHÔNG hợp lệ!");
                        System.out.println("Yêu cầu: >=8 ký tự, gồm chữ thường, chữ hoa, số và ký tự đặc biệt.");
                    }
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
