import java.util.Scanner;

public class baitap4 {
    public static void main(String[] args) {
        float width, height;
        float area,perimeter;
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhap chieu dai va chieu rong hinh chu nhat: ");
        width = sc.nextFloat();
        height = sc.nextFloat();
        perimeter = width*height;
        area = (width+height)*2;
        System.out.println("---Ket qua---");
        System.out.printf("Chu vi = %.2f%n", area);
        System.out.printf("Dien tich = %.2f%n", perimeter);
    }
}
