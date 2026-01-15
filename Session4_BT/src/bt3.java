import java.util.Scanner;

public class bt3 {
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearchDescending(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


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

        for (int i = 0; i < n; i++) {
            int maxValue = arr[i];
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (maxValue < arr[j]) {
                    maxValue = arr[j];
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                arr[maxIndex] = arr[i];
                arr[i] = maxValue;

            }
        }

        System.out.println("Mảng đã được sắp xếp giảm dần: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("\nNhập số cần tìm: ");
        int key = input.nextInt();
        int linearSearch = linearSearch(arr, key);
        int binarySearch = binarySearchDescending(arr, key);
        if (linearSearch != -1) {
            System.out.println("Tìm kiếm tuyến tính: tìm thấy tại vị trí " + linearSearch + ".");
        } else {
            System.out.println("Tìm kiếm tuyến tính: không tìm thấy");
        }if (binarySearch != -1) {
            System.out.println("Tìm kiếm nhị phân: tìm thấy tại vị trí " + binarySearch + ".");
        } else {
            System.out.println("Tìm kiếm nhị phân: không tìm thấy");
        }
    }
}
