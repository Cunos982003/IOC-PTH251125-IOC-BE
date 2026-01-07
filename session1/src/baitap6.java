import java.util.Scanner;

public class baitap6 {
    public static void main(String[] args) {
        double vanToc, thoiGian;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap van toc: ");
        vanToc = sc.nextDouble();
        System.out.print("Nhap thoi gian: ");
        thoiGian = sc.nextDouble();
        double quangDuong = vanToc*thoiGian;
        System.out.printf("Quang duong = %.2f%n", quangDuong);
    }
}
