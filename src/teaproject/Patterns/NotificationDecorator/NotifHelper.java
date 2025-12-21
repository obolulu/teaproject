package teaproject.Patterns.NotificationDecorator;

import teaproject.StateMachine.StateMachine;

public class NotifHelper {
    public static void SendBaseNotification(StateMachine fsm, String text, SeverityDecorator.Severity severity) {
        Notification notif = new Notification(text, fsm.get_currentState());
        SeverityDecorator highSeverityNotif = new SeverityDecorator(notif, severity);
        TimeDecorator timeStampedNotif = new TimeDecorator(highSeverityNotif);
        fsm.Notify(timeStampedNotif);
    }
}
