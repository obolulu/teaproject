package teaproject.Teapot;

import teaproject.Patterns.NotificationDecorator.Notification;
import teaproject.Patterns.NotificationDecorator.SeverityDecorator;
import teaproject.Patterns.NotificationDecorator.TimeDecorator;
import teaproject.StateMachine.State;
import teaproject.StateMachine.StateMachine;
import teaproject.StateMachine.TeapotState;
import teaproject.StateMachine.TeapotStates;

public final class EmptyState extends TeapotState {
    private TeapotStateMachine stateMachine;
    

    public EmptyState(StateMachine stateMachine) {
        super(stateMachine, TeapotStates.EMPTY);
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
            // would do this in a single line to reduce multiple variables being created but changed it so it's easier to read ^^
            /*
            Notification notif = new Notification("Cannot start! Teapot is empty. Please fill it first.", this);
            SeverityDecorator highSeverityNotif = new SeverityDecorator(notif, SeverityDecorator.Severity.ERROR);
            TimeDecorator timeStampedNotif = new TimeDecorator(highSeverityNotif);
            stateMachine.Notify(timeStampedNotif);
             */
            // started off as that, then realized I should just write a helper static method for it which you can find here used -- just thought would work best for most cases
            teaproject.Patterns.NotificationDecorator.NotifHelper.SendBaseNotification(stateMachine, "Cannot start! Teapot is empty. Please fill it first.", SeverityDecorator.Severity.ERROR);
        }
    }
    
    @Override
    public State CheckState() {
        if (stateMachine.isFilledPressed() && stateMachine.getNumberOfCups() > 0) {
            stateMachine.transitionTo(TeapotStates.IDLE);
            return stateMachine.get_currentState();
        }
        
        return this;
    }
}
