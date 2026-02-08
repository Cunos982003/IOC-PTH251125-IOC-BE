import java.util.ArrayList;
import java.util.Scanner;

public class StringToIntergerList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> validNumbers = new ArrayList<>();
        int invalidCount = 0;

        System.out.println("Nhập các chuỗi (gõ exit để kết thúc): ");
        while (true){
            String input   = sc.nextLine();
            if(input.equalsIgnoreCase("exit")){
                break;
            }

            try{
                int number = Integer.parseInt(input);
                validNumbers.add(number);
            } catch(NumberFormatException e){
                System.out.println("Chuối \"" + input + "\" không hợp lệ." );
                invalidCount++;
            }
        }

        System.out.println("Số chuỗi hợp lệ: " + validNumbers.size());
        System.out.println("Số chuỗi không hợp lệ: " + invalidCount);
        System.out.println("Danh sách số nguyên hợp lệ: " + validNumbers);


    }
}