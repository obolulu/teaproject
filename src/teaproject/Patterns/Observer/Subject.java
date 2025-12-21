package teaproject.Patterns.Observer;

import teaproject.Patterns.NotificationDecorator.Notification;

public interface Subject {
    void Notify(Notification notification);
    void Subscribe(Observer o);
    void Unsubscribe(Observer o);

}

