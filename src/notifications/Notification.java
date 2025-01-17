package notifications;

import notifications.decorator.INotification;
import notifications.observer.Observer;
import notifications.observer.Subject;
import notifications.state.*;

import java.util.ArrayList;
import java.util.List;

public class Notification implements INotification{
    private String message;
    private NotificationType type;
    private NotificationState state; // Для патерну State
    private List<Observer> observers = new ArrayList<>(); // Для патерну Observer

    public Notification(String message, NotificationType type) {
        this.message = message;
        this.type = type;
        this.state = new NewState(this); // Початковий стан — нове повідомлення
    }

    @Override
    public void send() {
        state.send();
    }

    @Override
    public void deliver() {
        state.deliver();
    }

    @Override
    public void handleError() {
        state.handleError();
    }

    public void setState(NotificationState state) {
        this.state = state;
    }

    public NotificationState getState() {
        return state;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public NotificationType getType() {
        return type;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public List<Observer> getObservers(){
        return observers;
    }
}

