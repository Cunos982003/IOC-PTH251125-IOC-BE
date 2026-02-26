import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event {
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Event(String name, LocalDateTime startDate, LocalDateTime endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getStatus() {
        LocalDateTime now = LocalDateTime.now();

        if (now.isBefore(startDate)) {
            return "Upcoming";
        } else if (now.isAfter(endDate)) {
            return "Finished";
        } else {
            return "Ongoing";
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        return "Event: " + name +
                "\nStart: " + startDate.format(formatter) +
                "\nEnd: " + endDate.format(formatter) +
                "\nStatus: " + getStatus() +
                "\n----------------------------";
    }
}