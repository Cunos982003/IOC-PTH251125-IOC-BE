import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChatApplication {

    private static List<Message> messages = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    private static DateTimeFormatter dateFormatter =
            DateTimeFormatter.ofPattern("d-M-yyyy");

    public static void main(String[] args) {

        while (true) {

            System.out.print("Nhập tên người gửi (hoặc 'exit' để thoát): ");
            String sender = sc.nextLine();

            if (sender.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Nhập nội dung tin nhắn: ");
            String content = sc.nextLine();

            messages.add(new Message(sender, content));

            System.out.println("Nhập 'history' để xem lịch sử, "
                    + "hoặc 'filter' để lọc tin nhắn theo người gửi, "
                    + "hoặc 'date' để lọc theo ngày:");

            String command = sc.nextLine();

            switch (command.toLowerCase()) {

                case "history":
                    showHistory();
                    break;

                case "filter":
                    filterBySender();
                    break;

                case "date":
                    filterByDate();
                    break;

                default:
                    System.out.println("Tiếp tục chat...");
            }
        }

        System.out.println("Thoát chương trình.");
    }


    private static void showHistory() {
        if (messages.isEmpty()) {
            System.out.println("Chưa có tin nhắn.");
            return;
        }

        System.out.println("Lịch sử chat:");
        messages.forEach(System.out::println);
    }

    private static void filterBySender() {

        System.out.print("Nhập tên người gửi để lọc: ");
        String name = sc.nextLine();

        List<Message> filtered = messages.stream()
                .filter(m -> m.getSender().equalsIgnoreCase(name))
                .collect(Collectors.toList());

        if (filtered.isEmpty()) {
            System.out.println("Không tìm thấy tin nhắn.");
        } else {
            System.out.println("Tin nhắn từ " + name + ":");
            filtered.forEach(System.out::println);
        }
    }

    private static void filterByDate() {

        try {
            System.out.print("Nhập ngày (dd-MM-yyyy): ");
            String input = sc.nextLine();

            LocalDate date = LocalDate.parse(input, dateFormatter);

            List<Message> filtered = messages.stream()
                    .filter(m -> m.getTimestamp().toLocalDate().equals(date))
                    .collect(Collectors.toList());

            if (filtered.isEmpty()) {
                System.out.println("Không có tin nhắn trong ngày này.");
            } else {
                System.out.println("Tin nhắn trong ngày " + date + ":");
                filtered.forEach(System.out::println);
            }

        } catch (DateTimeParseException e) {
            System.out.println("Sai định dạng ngày! Vui lòng nhập dd-MM-yyyy");
            System.out.println("Ví dụ: 21-05-2025");
        }
    }
}