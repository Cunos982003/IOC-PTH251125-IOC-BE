import java.util.Scanner;

public class bt2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        int m;

        System.out.print("Nhập số hàng của mảng: ");
        n = input.nextInt();
        System.out.print("Nhập số cột của mảng: ");
        m = input.nextInt();
        int [][] arr = new int[n][m];

        System.out.println("Nhập các phần tử của mảng.");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("Phần tử [" + i + "] [" +j + "]  : " );
                arr[i][j] = input.nextInt();
            }
        }

        int sumEven = 0;
        int sumOdd = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] % 2 == 0) {
                    sumEven += arr[i][j];
                } else {
                    sumOdd += arr[i][j];
                }
            }
        }

        System.out.println("Tổng các số chẵn: " + sumEven);
        System.out.println("Tổng các số lẻ: " + sumOdd);


    }
}
