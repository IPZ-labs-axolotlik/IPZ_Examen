package notifications.decorator;

import notifications.NotificationType;
import notifications.observer.Observer;
import notifications.observer.Subject;

import java.util.List;

public interface INotification extends Subject {
    void send();
    void deliver();
    void handleError();
    String getMessage();
    NotificationType getType();
    void setMessage(String message);
}
