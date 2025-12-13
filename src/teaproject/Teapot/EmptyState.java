package teaproject.Teapot;

import teaproject.StateMachine.State;
import teaproject.StateMachine.StateMachine;
import teaproject.StateMachine.States;

public final class EmptyState extends State{
    private TeapotStateMachine stateMachine;
    
    public EmptyState(StateMachine stateMachine) {
        this.stateMachine = (TeapotStateMachine) stateMachine;
    }
    
    @Override
    public void OnEnter() {
        System.out.println("State: EMPTY - Please fill the teapot");
        stateMachine.setNumberOfCups(0);
    }
    
    @Override
    public void OnExit() {
        System.out.println("EmptyState OnExit");
    }
    
    @Override
    public void Execute() {
        if (stateMachine.isStartPressed()) {
            System.out.println("WARNING: Cannot start! Teapot is empty. Please fill it first.");
        }
    }
    
    @Override
    public State CheckState() {
        if (stateMachine.isFilledPressed() && stateMachine.getNumberOfCups() > 0) {
            stateMachine.transitionTo(States.IDLE);
            return stateMachine.get_currentState();
        }
        
        return this;
    }
}
