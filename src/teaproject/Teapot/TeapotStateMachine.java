package teaproject.Teapot;

import teaproject.StateMachine.State;
import teaproject.StateMachine.StateMachine;
import teaproject.StateMachine.States;

import java.util.Hashtable;

public final class TeapotStateMachine extends StateMachine {
    private int numberOfCups;
    private boolean startPressed;
    private boolean boilWaterPressed;
    private boolean filledPressed;
    private boolean resetPressed;
    
    public TeapotStateMachine() {
        stateDictionary = new Hashtable<>();
        stateDictionary.put(States.EMPTY, new EmptyState(this));
        stateDictionary.put(States.IDLE, new IdleState(this));
        stateDictionary.put(States.BOILING_WATER, new BoilingWaterState(this));
        stateDictionary.put(States.TEA, new TeaState(this));
        stateDictionary.put(States.DONE, new DoneState(this));

        super.ChangeState(stateDictionary.get(States.EMPTY));
        this.numberOfCups = 0;
        this.startPressed = false;
        this.boilWaterPressed = false;
        this.filledPressed = false;
        this.resetPressed = false;
    }
    
    public void onFilledButtonPressed(int cups) {
        this.numberOfCups = cups;
        this.filledPressed = true;
        Tick();
        this.filledPressed = false;
    }
    
    public void onStartButtonPressed() {
        this.startPressed = true;
        Tick();
        this.startPressed = false;
    }
    
    public void onBoilWaterButtonPressed() {
        this.boilWaterPressed = true;
        Tick();
        this.boilWaterPressed = false;
    }
    
    public void onResetButtonPressed() {
        this.resetPressed = true;
        Tick();
        this.resetPressed = false;
    }
    
    public boolean isStartPressed() { return startPressed; }
    public boolean isBoilWaterPressed() { return boilWaterPressed; }
    public boolean isFilledPressed() { return filledPressed; }
    public boolean isResetPressed() { return resetPressed; }
    
    public int getNumberOfCups() { return numberOfCups; }
    public void setNumberOfCups(int cups) { this.numberOfCups = cups; }
    
    public void transitionTo(States state) {
        super.ChangeState(stateDictionary.get(state));
    }
    
    public States getCurrentStateType() {
        State current = get_currentState();
        if (current instanceof EmptyState) return States.EMPTY;
        if (current instanceof IdleState) return States.IDLE;
        if (current instanceof TeaState) return States.TEA;
        if (current instanceof BoilingWaterState) return States.BOILING_WATER;
        if (current instanceof DoneState) return States.DONE;
        return States.EMPTY;
    }
}
