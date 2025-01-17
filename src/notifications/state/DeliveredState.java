package notifications.state;

import notifications.Notification;

public class DeliveredState implements NotificationState {
    private Notification notification;

    public DeliveredState(Notification notification) {
        this.notification = notification;
    }

    @Override
    public void send() {
        System.out.println("[DeliveredState] Повідомлення вже доставлене, повторна відправка не потрібна.");
    }

    @Override
    public void deliver() {
        System.out.println("[DeliveredState] Повідомлення вже доставлене.");
    }

    @Override
    public void handleError() {
        System.out.println("[DeliveredState] Повідомлення вже доставлене, помилка не може бути оброблена.");
    }
}
