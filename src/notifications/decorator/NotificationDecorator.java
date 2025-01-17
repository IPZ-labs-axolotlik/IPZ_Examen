package notifications.decorator;

import notifications.observer.Observer;

import java.util.List;

public abstract class NotificationDecorator implements INotification{
    protected INotification wrappedNotification;

    public NotificationDecorator(INotification notification) {
        this.wrappedNotification = notification;
    }

    @Override
    public void send() {
        wrappedNotification.send();
    }

    @Override
    public void deliver() {
        wrappedNotification.deliver();
    }

    @Override
    public void handleError() {
        wrappedNotification.handleError();
    }

    @Override
    public String getMessage() {
        return wrappedNotification.getMessage();
    }

    @Override
    public void setMessage(String message) {
        wrappedNotification.setMessage(message);
    }

    @Override
    public notifications.NotificationType getType() {
        return wrappedNotification.getType();
    }
    @Override
    public void attach(Observer o) {
        wrappedNotification.attach(o);
    }

    @Override
    public void detach(Observer o) {
        wrappedNotification.detach(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : wrappedNotification.getObservers()) {
            observer.update(message);
        }
    }

    @Override
    public List<Observer> getObservers(){
        return wrappedNotification.getObservers();
    }
}

