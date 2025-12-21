package teaproject.Teapot;

import teaproject.Patterns.Observer.Observer;
import teaproject.StateMachine.State;
import teaproject.StateMachine.StateMachine;
import teaproject.StateMachine.TeapotStates;

import java.util.Hashtable;
import java.util.List;

public final class TeapotStateMachine extends StateMachine{

    // for observers
    private List<Observer> observers;
    //

    private int numberOfCups;
    private boolean startPressed;
    private boolean boilWaterPressed;
    private boolean filledPressed;
    private boolean resetPressed;
    
    public TeapotStateMachine() {
        stateDictionary = new Hashtable<>();
        stateDictionary.put(TeapotStates.EMPTY, new EmptyState(this));
        stateDictionary.put(TeapotStates.IDLE, new IdleState(this));
        stateDictionary.put(TeapotStates.BOILING_WATER, new BoilingWaterState(this));
        stateDictionary.put(TeapotStates.TEA, new TeaState(this));
        stateDictionary.put(TeapotStates.DONE, new DoneState(this));

        observers = new java.util.ArrayList<>();

        super.ChangeState(stateDictionary.get(TeapotStates.EMPTY));
        this.numberOfCups = 0;
        this.startPressed = false;
        this.boilWaterPressed = false;
        this.filledPressed = false;
        this.resetPressed = false;
    }
    
    public void fillCups(int cups) {
        this.numberOfCups = cups;
        this.filledPressed = true;
        Tick();
        this.filledPressed = false;
    }
    
    public void Start() {
        this.startPressed = true;
        Tick();
        this.startPressed = false;
    }
    
    public void BoilWater() {
        this.boilWaterPressed = true;
        Tick();
        this.boilWaterPressed = false;
    }
    
    public void ResetTeapot() {
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
    
    public void transitionTo(TeapotStates state) {
        super.ChangeState(stateDictionary.get(state));
    }
    
    public TeapotStates getCurrentStateType() {
        State current = get_currentState();
        if (current instanceof EmptyState) return TeapotStates.EMPTY;
        if (current instanceof IdleState) return TeapotStates.IDLE;
        if (current instanceof TeaState) return TeapotStates.TEA;
        if (current instanceof BoilingWaterState) return TeapotStates.BOILING_WATER;
        if (current instanceof DoneState) return TeapotStates.DONE;
        return TeapotStates.EMPTY;
    }
}
