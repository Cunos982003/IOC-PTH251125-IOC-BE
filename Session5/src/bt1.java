import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bt1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập địa chỉ email: ");
        String email = input.nextLine().trim();
        String regex = "^[A-Za-z0-9._]+@[A-Za-z0-9.]+\\.[A-Za-z]{2,6}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()){
            System.out.println(" Email hợp lệ! ");
        } else {
            System.out.println(" Email không hợp lệ! ");
        }
    }
}
