package teaproject.Teapot;

import teaproject.StateMachine.State;
import teaproject.StateMachine.StateMachine;
public class DoneState extends teaproject.StateMachine.State {
    private TeapotStateMachine stateMachine;
    public DoneState(StateMachine stateMachine) {
        this.stateMachine = (TeapotStateMachine) stateMachine;
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
