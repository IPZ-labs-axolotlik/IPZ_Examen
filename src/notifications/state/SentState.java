package notifications.state;

import notifications.Notification;

public class SentState implements NotificationState {
    private Notification notification;

    public SentState(Notification notification) {
        this.notification = notification;
    }

    @Override
    public void send() {
        System.out.println("[SentState] Повідомлення вже відправлено.");
    }

    @Override
    public void deliver() {
        System.out.println("[SentState] Доставляємо повідомлення: \"" + notification.getMessage() + "\"");
        notification.setState(new DeliveredState(notification));
    }

    @Override
    public void handleError() {
        System.out.println("[SentState] Помилка при відправці, переводимо в ErrorState.");
        notification.setState(new ErrorState(notification));
    }
}
