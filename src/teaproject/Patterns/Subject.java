package teaproject.Patterns;

public interface Subject {
    void Notify(String msg);
    void Subscribe(Observer o);
    void Unsubscribe(Observer o);

}

