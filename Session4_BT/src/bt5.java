import java.util.Scanner;

public class bt5 {
    static Scanner scanner = new Scanner(System.in);
    static double[] scores;
    static boolean isSorted = false;

    public static void xemTatCaDiem() {
        System.out.println("Danh sách điểm:");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Sinh viên " + (i + 1) + ": " + scores[i]);
        }
    }


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

    // Tìm kiếm điểm
    public static void timKiemDiem() {
        System.out.print("Nhập điểm cần tìm: ");
        double key = scanner.nextDouble();

        // Tìm kiếm tuyến tính
        int linearIndex = linearSearch(scores, key);
        if (linearIndex != -1) {
            System.out.println("Tìm kiếm tuyến tính: tìm thấy tại vị trí " + linearIndex);
        } else {
            System.out.println("Tìm kiếm tuyến tính: không tìm thấy");
        }

        // Tìm kiếm nhị phân (chỉ khi mảng đã sắp xếp)
        if (isSorted) {
            int binaryIndex = binarySearch(scores, key);
            if (binaryIndex != -1) {
                System.out.println("Tìm kiếm nhị phân: tìm thấy tại vị trí " + binaryIndex);
            } else {
                System.out.println("Tìm kiếm nhị phân: không tìm thấy");
            }
        } else {
            System.out.println("Mảng chưa được sắp xếp, không thể tìm kiếm nhị phân.");
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

    // Thống kê điểm
    public static void thongKeDiem() {
        double sum = 0;
        double max = scores[0];
        double min = scores[0];

        for (double score : scores) {
            sum += score;
            if (score > max) max = score;
            if (score < min) min = score;
        }

        double avg = sum / scores.length;
        int countAboveAvg = 0;
        for (double score : scores) {
            if (score > avg) countAboveAvg++;
        }

        System.out.println("Điểm trung bình: " + avg);
        System.out.println("Điểm cao nhất: " + max);
        System.out.println("Điểm thấp nhất: " + min);
        System.out.println("Số lượng sinh viên đạt điểm trên trung bình: " + countAboveAvg);
    }


    public static void sapXepDiem() {
        System.out.println("Chọn kiểu sắp xếp:");
        System.out.println("1. Tăng dần");
        System.out.println("2. Giảm dần");
        int option = scanner.nextInt();

        if (option == 1) {
            bubbleSortAscending(scores);
            isSorted = true;
            System.out.println("Đã sắp xếp tăng dần !");
        } else if (option == 2) {
            selectionSortDescending(scores);
            isSorted = true;
            System.out.println("Đã sắp xếp giảm dần !");
        } else {
            System.out.println("Lựa chọn không hợp lệ!");
        }
    }
    public static void main(String[] args) {
        System.out.print("Nhập số lượng sinh viên: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Số lượng sinh viên không hợp lệ!");
            return;
        }
        scores = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập điểm sinh viên thứ " + (i + 1) + ": ");
            scores[i] = scanner.nextDouble();
        }

        int choice;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Xem tất cả điểm");
            System.out.println("2. Sắp xếp điểm");
            System.out.println("3. Tìm kiếm điểm");
            System.out.println("4. Thống kê điểm");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    xemTatCaDiem();
                    break;
                case 2:
                    sapXepDiem();
                    break;
                case 3:
                    timKiemDiem();
                    break;
                case 4:
                    thongKeDiem();
                    break;
                case 5:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 5);
    }
}
