import re.exception.MyCheckedException;
import re.exception.MyUncheckedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
            Scanner scanner = new Scanner(System.in);

            List<String> validPhones = new ArrayList<>();
            List<String> invalidPhones = new ArrayList<>();
            List<String> reasons = new ArrayList<>();

            System.out.println("Nhập danh sách số điện thoại, cách nhau bằng dấu phẩy (,):");
            String input = scanner.nextLine();

            String[] phones = input.split(",");

            for (String phone : phones) {
                try {
                    PhoneNumberValidation.validatePhoneNumber(phone);
                    validPhones.add(phone.trim());
                } catch (MyCheckedException | MyUncheckedException e) {
                    invalidPhones.add(phone.trim());
                    reasons.add(e.getMessage());
                }
            }

            System.out.println("\n--- Kết quả ---");
            System.out.println("Số điện thoại hợp lệ:");
            for (String p : validPhones) {
                System.out.println("- " + p);
            }

            System.out.println("\nSố điện thoại không hợp lệ:");
            for (int i = 0; i < invalidPhones.size(); i++) {
                System.out.println("- " + invalidPhones.get(i) + " → " + reasons.get(i));
            }
            scanner.close();
        }
    }