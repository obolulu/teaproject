package teaproject.Teapot;

import teaproject.StateMachine.State;
import teaproject.StateMachine.StateMachine;

public final class EmptyState extends State{
    private TeapotStateMachine stateMachine;
    public EmptyState(StateMachine stateMachine) {
        this.stateMachine = (TeapotStateMachine) stateMachine;
    }
    @Override
    public void OnEnter() {
        System.out.println("EmptyState OnEnter");
    }
    @Override
    public void OnExit() {
        System.out.println("EmptyState OnExit");
    }
    @Override
    public void Execute() {
        System.out.println("EmptyState Execute");
    }
    @Override
    public State CheckState() {
        return this.stateMachine.get_currentState().CheckState();
    }
}
