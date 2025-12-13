package teaproject.Teapot;

import teaproject.StateMachine.State;
import teaproject.StateMachine.StateMachine;
import teaproject.StateMachine.States;

import java.util.Timer;
import java.util.TimerTask;

public final class TeaState extends State {
    private TeapotStateMachine stateMachine;
    private Timer timer;
    private boolean timerExpired;
    private static final int TEA_BREWING_TIME = 5000;
    
    public TeaState(StateMachine stateMachine) {
        this.stateMachine = (TeapotStateMachine) stateMachine;
        this.timerExpired = false;
    }
    
    @Override
    public void OnEnter() {
        System.out.println("State: TEA - Making tea... Timer started");
        timerExpired = false;
        
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timerExpired = true;
                System.out.println("TEA Timer expired! Tea is ready.");
            }
        }, TEA_BREWING_TIME);
    }

    @Override
    public void OnExit() {
        System.out.println("TeaState OnExit");
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
            stateMachine.transitionTo(States.DONE);
            return stateMachine.get_currentState();
        }
        
        return this;
    }
}
