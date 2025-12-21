package teaproject.Patterns.NotificationDecorator;

import teaproject.StateMachine.State;

public class Notification {
    private String message;
    private State state;

    public Notification(String message, State state) {
        this.message = message != null ? message : "";
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public State getState() {
        return state;
    }

    public String getFormattedMessage() {
        return message;
    }



}


