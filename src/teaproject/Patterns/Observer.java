package teaproject.Patterns;

import teaproject.StateMachine.State;

public interface Observer {
    void onMessageReceived(String msg, State state);
    }
