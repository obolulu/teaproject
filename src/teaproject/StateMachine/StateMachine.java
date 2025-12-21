package teaproject.StateMachine;

import teaproject.Patterns.NotificationDecorator.Notification;
import teaproject.Patterns.Observer.Observer;
import teaproject.Patterns.Observer.Subject;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public abstract class StateMachine implements Subject {
    private List<Observer> observers = new ArrayList<>();
    protected Dictionary<TeapotStates,State> stateDictionary;
    private State _currentState;

        public State get_currentState(){
        return _currentState;
    }

    protected void Tick(){
        _currentState.Execute();
        State state = _currentState.CheckState();
        if(state != _currentState){
            ChangeState(state);
        }
    }
    protected void ChangeState(State state){
            State oldState = _currentState;
        if (_currentState != null) {
            _currentState.OnExit();
        }
        _currentState = state;
        _currentState.OnEnter();

        if(oldState != _currentState){
            Notify(new Notification("", _currentState));
        }

    }

    @Override
    public void Notify(Notification notification) {
        for (Observer o : observers) {
            o.onMessageReceived(notification);
        }
    }

    @Override
    public void Subscribe(Observer o) {
        observers.add(o);
    }

    @Override
    public void Unsubscribe(Observer o) {
        observers.remove(o);
    }

    public void update() {
        Tick();
    }
}
