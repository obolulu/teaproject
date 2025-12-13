package teaproject.StateMachine;

import java.util.Dictionary;

public abstract class StateMachine {
    protected Dictionary<States,State> stateDictionary;
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
        _currentState.OnExit();
        _currentState = state;
        _currentState.OnEnter();
    }
}
