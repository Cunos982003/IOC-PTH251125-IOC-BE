
import java.util.Scanner;

public class bt1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        System.out.print("Nhập kich thước của mảng: ");
        n = input.nextInt();
        int [] arr = new int[n];

        System.out.println("Nhập các phần tử của mảng.");
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i+1) +" : " );
            arr[i] = input.nextInt();
        }

        for (int i = 0; i < n - 1  ; i++) {
            for (int j = 0; j < n - i - 1 ; j++) {
                if (arr[j] < arr[j+1]){
                    // đổi chỗ
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.println("Mảng đã được sắp xếp giảm dần: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

    }
}
