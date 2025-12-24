package teaproject.Teapot;

import teaproject.Patterns.NotificationDecorator.NotifHelper;
import teaproject.Patterns.NotificationDecorator.SeverityDecorator;
import teaproject.StateMachine.State;
import teaproject.StateMachine.StateMachine;
import teaproject.StateMachine.TeapotState;
import teaproject.StateMachine.TeapotStates;

public class FilledState extends TeapotState {
    private TeapotStateMachine stateMachine;
    public FilledState(StateMachine stateMachine, TeapotStates stateEnum) {
        super(stateMachine, stateEnum);
        this.stateMachine = (TeapotStateMachine) stateMachine;
    }

    @Override
    public void OnEnter() {
        //send notification that teapot is filled
        NotifHelper.SendBaseNotification(stateMachine, "Teapot is filled. Please press 'START' to start making tea.", SeverityDecorator.Severity.INFO);
    }

    @Override
    public void OnExit() {

    }

    @Override
    public void Execute() {

    }

    @Override
    public State CheckState() {
        return null;
    }
}
