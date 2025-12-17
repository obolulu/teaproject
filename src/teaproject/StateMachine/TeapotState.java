package teaproject.StateMachine;

import teaproject.Teapot.TeapotStateMachine;

public abstract class TeapotState extends State {
    protected TeapotStateMachine stateMachine;
    private TeapotStates stateEnum;
    public  TeapotStates getStateEnum(){
        return stateEnum;
    }
    public TeapotState(StateMachine stateMachine, TeapotStates stateEnum) {
        this.stateMachine = (TeapotStateMachine) stateMachine;
        this.stateEnum = stateEnum;
    }


}
