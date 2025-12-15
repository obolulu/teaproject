package teaproject.Teapot;

import teaproject.StateMachine.State;
import teaproject.StateMachine.StateMachine;
import teaproject.StateMachine.TeapotStates;

public final class IdleState extends State {
    private TeapotStateMachine stateMachine;
    
    public IdleState(StateMachine stateMachine) {
        this.stateMachine = (TeapotStateMachine) stateMachine;
    }
    
    @Override
    public void OnEnter() {
        System.out.println("State: IDLE - Ready to start. Cups: " + stateMachine.getNumberOfCups());
    }
    
    @Override
    public void OnExit() {
        System.out.println("IdleState OnExit");
    }
    
    @Override
    public void Execute() {
    }
    
    @Override
    public State CheckState() {
        if (stateMachine.isStartPressed()) {
            stateMachine.transitionTo(TeapotStates.TEA);
            return stateMachine.get_currentState();
        }
        
        if (stateMachine.isBoilWaterPressed()) {
            stateMachine.transitionTo(TeapotStates.BOILING_WATER);
            return stateMachine.get_currentState();
        }
        
        return this;
    }
}
