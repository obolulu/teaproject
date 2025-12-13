package teaproject.Teapot;

import teaproject.StateMachine.State;
import teaproject.StateMachine.StateMachine;

public final class TeaState extends State {
    private TeapotStateMachine stateMachine;
    public TeaState(StateMachine stateMachine) {
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
