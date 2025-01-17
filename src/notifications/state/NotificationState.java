package notifications.state;

public interface NotificationState {
    void send();
    void deliver();
    void handleError();
}
