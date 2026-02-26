import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventManager {

    private static List<Event> eventList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static void main(String[] args) {

        while (true) {

            System.out.print("Nhập tên sự kiện (hoặc 'exit' để thoát): ");
            String name = sc.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            if (name.trim().isEmpty()) {
                System.out.println("Không được để trống tên sự kiện!");
                continue;
            }

            LocalDateTime start = inputDate("Nhập thời gian bắt đầu (dd/MM/yyyy HH:mm): ");
            LocalDateTime end = inputDate("Nhập thời gian kết thúc (dd/MM/yyyy HH:mm): ");

            if (end.isBefore(start)) {
                System.out.println("Thời gian kết thúc phải sau thời gian bắt đầu!");
                continue;
            }

            eventList.add(new Event(name, start, end));
            System.out.println("Thêm sự kiện thành công!\n");
        }

        // Sau khi exit → tự động in danh sách
        System.out.println("\nDanh sách sự kiện: " );

        if (eventList.isEmpty()) {
            System.out.println("Không có sự kiện nào.");
        } else {
            eventList.forEach(System.out::println);
        }
    }

    // Hàm nhập ngày giờ có xử lý lỗi
    private static LocalDateTime inputDate(String message) {
        while (true) {
            try {
                System.out.print(message);
                return LocalDateTime.parse(sc.nextLine(), formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Sai định dạng! Vui lòng nhập đúng dd/MM/yyyy HH:mm");
            }
        }
    }
}