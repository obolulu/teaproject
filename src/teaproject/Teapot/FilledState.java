package teaproject.Teapot;

import teaproject.StateMachine.State;
import teaproject.StateMachine.StateMachine;
import teaproject.StateMachine.TeapotState;
import teaproject.StateMachine.TeapotStates;

public class FilledState extends TeapotState {
    public FilledState(StateMachine stateMachine, TeapotStates stateEnum) {
        super(stateMachine, stateEnum);
    }

    @Override
    public void OnEnter() {

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
