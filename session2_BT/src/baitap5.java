import java.util.Scanner;

public class baitap5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so tu 100-999: ");
        int n = sc.nextInt();
        if (n < 100 || n > 999) {
            System.out.println("Số nhập vào không hợp lệ");
        } else {
            int hundreds = n / 100;
            int tens = (n / 10) % 10;
            int units = n % 10;

            String docHundreds = "";
            String docTens = "";
            String docUnits = "";

            switch (hundreds) {
                case 1: docHundreds = "Một trăm"; break;
                case 2: docHundreds = "Hai trăm"; break;
                case 3: docHundreds = "Ba trăm"; break;
                case 4: docHundreds = "Bốn trăm"; break;
                case 5: docHundreds = "Năm trăm"; break;
                case 6: docHundreds = "Sáu trăm"; break;
                case 7: docHundreds = "Bảy trăm"; break;
                case 8: docHundreds = "Tám trăm"; break;
                case 9: docHundreds = "Chín trăm"; break;
            }
            switch (tens) {
                case 0: docTens = ""; break;
                case 1: docTens = "mười"; break;
                case 2: docTens = "hai mươi"; break;
                case 3: docTens = "ba mươi"; break;
                case 4: docTens = "bốn mươi"; break;
                case 5: docTens = "năm mươi"; break;
                case 6: docTens = "sáu mươi"; break;
                case 7: docTens = "bảy mươi"; break;
                case 8: docTens = "tám mươi"; break;
                case 9: docTens = "chín mươi"; break;
            }
            switch (units) {
                case 0: docUnits = ""; break;
                case 1: docUnits = "một"; break;
                case 2: docUnits = "hai"; break;
                case 3: docUnits = "ba"; break;
                case 4: docUnits = "bốn"; break;
                case 5: docUnits = "năm"; break;
                case 6: docUnits = "sáu"; break;
                case 7: docUnits = "bảy"; break;
                case 8: docUnits = "tám"; break;
                case 9: docUnits = "chín"; break;
            }

            String ketQua = docHundreds;
            if (!docTens.isEmpty()) ketQua += " " + docTens;
            if (!docUnits.isEmpty()) ketQua += " " + docUnits;

            System.out.println("Cach doc: " + ketQua);

        }
        }
}
