import java.util.ArrayList;
import java.util.Scanner;

public class bt4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        System.out.print("Nhập kích thước của mảng: ");
        n = input.nextInt();
        if (n == 0) {
            System.out.println("Mảng không có phần tử!");
            return;
        }

        int[] arr = new int[n];

        System.out.println("Nhập các phần tử của mảng.");
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i+1) +" : " );
            arr[i] = input.nextInt();
        }
        ArrayList<Integer> evenlist = new ArrayList<>();
        ArrayList<Integer> oddlist = new ArrayList<>();

        for (int num : arr) {
            if (num % 2 == 0) {
                evenlist.add(num);
            } else {
                oddlist.add(num);
            }
        }

        int index = 0;
        for (int num : evenlist) {
            arr[index++] = num;
        }
        for (int num : oddlist) {
            arr[index++] = num;
        }

        System.out.println("Mảng sau khi sắp xếp:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
