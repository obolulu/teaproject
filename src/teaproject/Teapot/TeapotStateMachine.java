package teaproject.Teapot;

import teaproject.Database.TeaDatabaseLogger;
import teaproject.Patterns.Observer.Observer;
import teaproject.StateMachine.State;
import teaproject.StateMachine.StateMachine;
import teaproject.StateMachine.TeapotStates;

import java.util.Hashtable;
import java.util.List;

public final class TeapotStateMachine extends StateMachine{

    private int numberOfCups;
    private boolean isStartQueued;
    private boolean isBoilQueued;
    private boolean isFillQueued;
    private boolean isResetQueued;
    
    public TeapotStateMachine() {
        stateDictionary = new Hashtable<>();
        stateDictionary.put(TeapotStates.EMPTY, new EmptyState(this));
        stateDictionary.put(TeapotStates.IDLE, new IdleState(this));
        stateDictionary.put(TeapotStates.BOILING_WATER, new BoilingWaterState(this));
        stateDictionary.put(TeapotStates.TEA, new TeaState(this));
        stateDictionary.put(TeapotStates.DONE, new DoneState(this));
        super.ChangeState(stateDictionary.get(TeapotStates.EMPTY));
        this.numberOfCups = 0;
        this.isStartQueued = false;
        this.isBoilQueued = false;
        this.isFillQueued = false;
        this.isResetQueued = false;
    }
    
    public void fillCups(int cups) {
        this.numberOfCups = cups;
        this.isFillQueued = true;
        Tick();
        this.isFillQueued = false;
    }
    
    public void Start() {
        this.isStartQueued = true;
        Tick();
        this.isStartQueued = false;
    }
    
    public void BoilWater() {
        this.isBoilQueued = true;
        Tick();
        this.isBoilQueued = false;
    }
    
    public void ResetTeapot() {
        this.isResetQueued = true;
        Tick();
        this.isResetQueued = false;
    }

    public boolean startQueued() { return isStartQueued; }
    public boolean boilWaterQueued() { return isBoilQueued; }
    public boolean fillQueued() { return isFillQueued; }
    public boolean resetQueued() { return isResetQueued; }

    public int getNumberOfCups() { return TeaDatabaseLogger.getTodayTeaLogs(); }
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
