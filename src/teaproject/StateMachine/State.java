package teaproject.StateMachine;

public abstract class State {
    public abstract void OnEnter();
    public abstract void OnExit();

    // will check
    public abstract void Execute();

    //
    public abstract State CheckState();
}
