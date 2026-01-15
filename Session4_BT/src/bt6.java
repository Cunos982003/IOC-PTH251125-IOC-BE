import java.util.Scanner;

public class bt6 {
    static Scanner scanner = new Scanner(System.in);
    static double[] salaries;
    static boolean isSortedAscending = false;

    public static void xemDanhSachLuong() {
        System.out.println("Danh sách lương:");
        for (int i = 0; i < salaries.length; i++) {
            System.out.println("Nhân viên " + (i + 1) + ": " + salaries[i]);
        }
    }


    public static void sapXepLuong() {
        System.out.println("Chọn kiểu sắp xếp:");
        System.out.println("1. Tăng dần");
        System.out.println("2. Giảm dần");
        int option = scanner.nextInt();

        if (option == 1) {
            bubbleSortAscending(salaries);
            isSortedAscending = true;
        } else if (option == 2) {
            selectionSortDescending(salaries);
            isSortedAscending = false;
            System.out.println("Mảng sau khi sắp xếp giảm đần!");
        } else {
            System.out.println("Mảng sau khi sắp xếp tăng dần:");
        }
    }


    // Bubble Sort tăng dần
    public static void bubbleSortAscending(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort giảm dần
    public static void selectionSortDescending(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            double temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void timKiemLuong() {
        System.out.print("Nhập lương cần tìm: ");
        double key = scanner.nextDouble();

        // Linear Search
        int linearIndex = linearSearch(salaries, key);
        if (linearIndex != -1) {
            System.out.println("Tìm kiếm tuyến tính: tìm thấy tại vị trí nhân viên " + (linearIndex + 1));
        } else {
            System.out.println("Tìm kiếm tuyến tính: không tìm thấy");
        }

        // Binary Search (chỉ khi mảng đã sắp xếp tăng dần)
        if (isSortedAscending) {
            int binaryIndex = binarySearch(salaries, key);
            if (binaryIndex != -1) {
                System.out.println("Tìm kiếm nhị phân: tìm thấy tại vị trí nhân viên " + (binaryIndex + 1));
            } else {
                System.out.println("Tìm kiếm nhị phân: không tìm thấy");
            }
        } else {
            System.out.println("Mảng chưa được sắp xếp tăng dần, không thể tìm kiếm nhị phân.");
        }
    }

    // Linear Search
    public static int linearSearch(double[] arr, double key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search (mảng tăng dần)
    public static int binarySearch(double[] arr, double key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Thống kê lương
    public static void thongKeLuong() {
        double sum = 0;
        double max = salaries[0];
        double min = salaries[0];

        for (double salary : salaries) {
            sum += salary;
            if (salary > max) max = salary;
            if (salary < min) min = salary;
        }

        double avg = sum / salaries.length;
        int countAboveAvg = 0;
        for (double salary : salaries) {
            if (salary > avg) countAboveAvg++;
        }

        System.out.println("Tổng lương: " + sum);
        System.out.println("Lương trung bình: " + avg);
        System.out.println("Lương cao nhất: " + max);
        System.out.println("Lương thấp nhất: " + min);
        System.out.println("Số nhân viên có lương trên trung bình: " + countAboveAvg);
    }

    public static void main(String[] args) {
        System.out.print("Nhập số lượng nhân viên: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Số lượng nhân viên không hợp lệ!");
            return;
        }

        salaries = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập lương nhân viên " + (i + 1) + ": ");
            salaries[i] = scanner.nextDouble();
        }


        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Xem danh sách lương");
            System.out.println("2. Sắp xếp lương");
            System.out.println("3. Tìm kiếm lương cụ thể");
            System.out.println("4. Thống kê lương");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    xemDanhSachLuong();
                    break;
                case 2:
                    sapXepLuong();
                    break;
                case 3:
                    timKiemLuong();
                    break;
                case 4:
                    thongKeLuong();
                    break;
                case 5:
                    System.out.println("Kết thúc chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
