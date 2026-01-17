import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bt3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mật khẩu: ");
        String password = sc.nextLine();

        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$!%]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        if (matcher.matches()) {
            System.out.println("Mật khẩu hợp lệ!");
        } else {
            System.out.println("Mật khẩu không hợp lệ!");
        }

    }
}
