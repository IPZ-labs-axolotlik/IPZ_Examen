package notifications.state;

import notifications.Notification;

public class ErrorState implements NotificationState {
    private Notification notification;

    public ErrorState(Notification notification) {
        this.notification = notification;
    }

    @Override
    public void send() {
        System.out.println("[ErrorState] Спроба повторної відправки після помилки: \"" + notification.getMessage() + "\"");
        notification.setState(new SentState(notification));
    }

    @Override
    public void deliver() {
        System.out.println("[ErrorState] Спочатку потрібно повторити відправку (send), "
                + "не можна доставити з помилкою.");
    }

    @Override
    public void handleError() {
        System.out.println("[ErrorState] Повідомлення вже в стані помилки.");
    }
}
