package teaproject.UI;

import teaproject.Patterns.NotificationDecorator.Notification;
import teaproject.Patterns.Observer.Observer;
import teaproject.Teapot.TeapotStateMachine;

import javax.swing.Timer;

public class TeaController implements Observer {
    private TeapotStateMachine model;
    private TeaMakerUI view;
    private Timer updateTimer;

    public TeaController(TeaMakerUI view) {
        this.view = view;
        this.model = new TeapotStateMachine();

        model.Subscribe(this);

        updateTimer = new Timer(100, e -> model.update());
        updateTimer.start();
    }
    public void handleFilledButton(int cups) {
        model.fillCups(cups);
    }

    public void handleStartButton() {
        model.Start();
    }

    public void handleBoilWaterButton() {
        model.BoilWater();
    }

    public void handleResetButton() {
        model.ResetTeapot();
    }
    public TeapotStateMachine getModel() {
        return model;
    }

    public int getNumberOfCups(){
        return model.getNumberOfCups();
    }

    @Override
    public void onMessageReceived(Notification notification) {
        view.TakeNotification(notification);
    }
}
