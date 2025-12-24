package teaproject.Teapot;

import teaproject.Database.TeaDatabaseLogger;
import teaproject.Patterns.NotificationDecorator.NotifHelper;
import teaproject.StateMachine.State;
import teaproject.StateMachine.StateMachine;
import teaproject.StateMachine.TeapotStates;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DoneState extends teaproject.StateMachine.TeapotState {
    private TeapotStateMachine stateMachine;

    public DoneState(StateMachine stateMachine) {
        super(stateMachine, TeapotStates.DONE);
        this.stateMachine = (TeapotStateMachine) stateMachine;
    }
    
    @Override
    public void OnEnter() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        
        System.out.println("State: DONE - Process complete!");
        System.out.println("Cups: " + stateMachine.getNumberOfCups() + ", Date: " + formattedDateTime);
        
        TeaDatabaseLogger.logTeaMade(stateMachine.getNumberOfCups());
        int todayTotalCups = TeaDatabaseLogger.getDailyLogs();
        final int DAILY_THRESHOLD = 10;

        if(todayTotalCups >= DAILY_THRESHOLD){
            NotifHelper.SendBaseNotification(stateMachine, "The number of total cups today has reached to " + todayTotalCups + "!", teaproject.Patterns.NotificationDecorator.SeverityDecorator.Severity.WARNING);
        }
        else{
        NotifHelper.SendBaseNotification(stateMachine, "Teapot is now filled. Please Reset the machine for future use.", teaproject.Patterns.NotificationDecorator.SeverityDecorator.Severity.INFO);
    }
}

    @Override
    public void OnExit() {
        System.out.println("DoneState OnExit");
    }

    @Override
    public void Execute() {
    }

    @Override
    public State CheckState() {
        if (stateMachine.resetQueued()) {
            stateMachine.transitionTo(TeapotStates.EMPTY);
            return stateMachine.get_currentState();
        }
        
        return this;
    }
}
