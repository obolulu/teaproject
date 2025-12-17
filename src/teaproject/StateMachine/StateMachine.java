package teaproject.StateMachine;

import teaproject.Patterns.Observer;
import teaproject.Patterns.Subject;

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
        if (_currentState != null) {
            _currentState.OnExit();
        }
        _currentState = state;
        _currentState.OnEnter();

        Notify(null);
    }

    //added for state custom messages
    public void notifyObservers(String message) {
        Notify(message);
    }

    @Override
    public void Notify(String msg) {
        for (Observer o : observers) {
            o.onMessageReceived(msg, get_currentState());
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
