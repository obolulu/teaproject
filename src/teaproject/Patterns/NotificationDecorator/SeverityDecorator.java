package teaproject.Patterns.NotificationDecorator;

public class SeverityDecorator extends NotificationDecorator {
    public enum Severity {
        INFO, WARNING, ERROR, SUCCESS
    }

    private Severity severity;

    public SeverityDecorator(Notification notification, Severity severity) {
        super(notification);
        this.severity = severity;
    }

    @Override
    public String getFormattedMessage() {
        String priorityPrefix = "[" + severity.name() + "] ";
        return priorityPrefix + notification.getFormattedMessage();
    }

    public Severity getPriority() {
        return severity;
    }
}