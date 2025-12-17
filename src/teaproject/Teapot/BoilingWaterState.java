package teaproject.Teapot;

import teaproject.StateMachine.State;
import teaproject.StateMachine.StateMachine;
import teaproject.StateMachine.TeapotState;
import teaproject.StateMachine.TeapotStates;

import java.util.Timer;
import java.util.TimerTask;

public class BoilingWaterState extends TeapotState {
    private TeapotStateMachine stateMachine;
    private Timer timer;
    private boolean timerExpired;
    private static final int BOILING_TIME = 7000;
    
    public BoilingWaterState(StateMachine stateMachine) {
        super(stateMachine, TeapotStates.BOILING_WATER);
        this.stateMachine = (TeapotStateMachine) stateMachine;
        this.timerExpired = false;
    }
    @Override
    public void OnEnter() {
        System.out.println("State: BOILING_WATER - Boiling water... Timer started");
        timerExpired = false;
        
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timerExpired = true;
                System.out.println("BOILING WATER Timer expired! Water is boiled.");
            }
        }, BOILING_TIME);
    }

    @Override
    public void OnExit() {
        System.out.println("BoilingWaterState OnExit");
        if (timer != null) {
            timer.cancel();
        }
    }

    @Override
    public void Execute() {
    }

    @Override
    public State CheckState() {
        if (timerExpired) {
            stateMachine.transitionTo(TeapotStates.DONE);
            return stateMachine.get_currentState();
        }
        
        return this;
    }
}
