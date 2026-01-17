import java.util.Scanner;

public class bt5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        boolean isActive = false;
        while (true) {
            System.out.println("""
                    ********************MENU*******************
                    1. Nhập chuỗi
                    2. Đếm số ký tự thường , hoa, số, ký tự đặc biệt
                    3. Đảo ngược chuỗi
                    4. Kiểm tra Palindrome
                    5. Chuẩn hóa chuỗi (Xóa khoảng trăng dư thừa, viết hoa chữ cái đầu)
                    6. Thoát
                    ********************************************
                    """);
            System.out.println("Lựa chọn của bạn: ");
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
                    System.out.print("Nhập chuỗi: ");
                    input = sc.nextLine();
                    break;

                case 2:
                    int lower = 0, upper = 0, digit = 0, special = 0;
                    for (char c : input.toCharArray()) {
                        if (Character.isLowerCase(c)) lower++;
                        else if (Character.isUpperCase(c)) upper++;
                        else if (Character.isDigit(c)) digit++;
                        else special++;
                    }
                    System.out.println("Chữ thường: " + lower);
                    System.out.println("Chữ hoa: " + upper);
                    System.out.println("Chữ số: " + digit);
                    System.out.println("Ký tự đặc biệt: " + special);
            break;

            case 3:
                String reversed = new StringBuilder(input).reverse().toString();
                System.out.println("Chuỗi đảo ngược: " + reversed);
            break;

            case 4:
                reversed = new StringBuilder(input).reverse().toString();
                if (input.equalsIgnoreCase(reversed)) {
                    System.out.println("Chuỗi là Palindrome");
                } else {
                    System.out.println("Chuỗi không phải Palindrome");
                }
            break;

            case 5:
                String normalized = input.trim().replaceAll("\\s+", " ");
                if (normalized.length() > 0) {
                    normalized = normalized.substring(0, 1).toUpperCase() + normalized.substring(1);
                }
                System.out.println("Chuỗi chuẩn hóa: " + normalized);
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
