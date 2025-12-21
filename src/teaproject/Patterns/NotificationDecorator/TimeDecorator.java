package teaproject.Patterns.NotificationDecorator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeDecorator extends NotificationDecorator {
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public TimeDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public String getFormattedMessage() {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        return "[" + timestamp + "] " + notification.getFormattedMessage();
    }
}