package teaproject.Patterns.NotificationDecorator;

public abstract class NotificationDecorator extends Notification {
    protected Notification notification;

    public NotificationDecorator(Notification notification) {
        super(notification.getMessage(), notification.getState());
        this.notification = notification;
    }

    @Override
    public abstract String getFormattedMessage();
}