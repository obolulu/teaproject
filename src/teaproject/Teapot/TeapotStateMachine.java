package teaproject.Teapot;

import teaproject.StateMachine.StateMachine;
import teaproject.StateMachine.States;

import java.util.Hashtable;

public final class TeapotStateMachine extends StateMachine {
    public TeapotStateMachine() {
        stateDictionary = new Hashtable<>();
        stateDictionary.put(States.EMPTY, new EmptyState(this));
        stateDictionary.put(States.IDLE, new IdleState(this));
        stateDictionary.put(States.BOILING_WATER, new BoilingWaterState(this));
        stateDictionary.put(States.TEA, new TeaState(this));
        stateDictionary.put(States.DONE, new DoneState(this));

        super.ChangeState(stateDictionary.get(States.EMPTY));
    }

}
