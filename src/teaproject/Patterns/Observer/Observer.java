package teaproject.Patterns.Observer;

import teaproject.Patterns.NotificationDecorator.Notification;
import teaproject.StateMachine.State;

public interface Observer {
    void onMessageReceived(Notification notification);
    }
