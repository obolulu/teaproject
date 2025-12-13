package teaproject.Teapot;

import teaproject.StateMachine.State;
import teaproject.StateMachine.StateMachine;

public final class IdleState extends State {
    private TeapotStateMachine stateMachine;
    public IdleState(StateMachine stateMachine) {
        this.stateMachine = (TeapotStateMachine) stateMachine;
    }
    @Override
    public void OnEnter() {
        System.out.println("IdleState OnEnter");
    }
    @Override
    public void OnExit() {
        System.out.println("IdleState OnExit");
    }
    @Override
    public void Execute() {
        System.out.println("IdleState Execute");
    }
    @Override
    public State CheckState() {
        return this;
    }
}
