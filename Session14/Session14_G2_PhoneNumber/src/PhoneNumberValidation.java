import re.exception.MyCheckedException;
import re.exception.MyUncheckedException;

public class PhoneNumberValidation {

    public static void validatePhoneNumber(String phone) throws MyCheckedException {
        phone = phone.trim();

        if (phone.length() != 10) {
            throw new MyCheckedException("Sai độ dài (phải gồm đúng 10 chữ số).");
        }

        if (!phone.matches("\\d+")) {
            throw new MyUncheckedException("Chứa ký tự không hợp lệ (chỉ cho phép 0-9).");
        }
    }
}