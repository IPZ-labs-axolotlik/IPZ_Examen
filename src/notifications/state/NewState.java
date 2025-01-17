package notifications.state;

import notifications.Notification;

public class NewState implements NotificationState {
    private Notification notification;

    public NewState(Notification notification) {
        this.notification = notification;
    }

    @Override
    public void send() {
        System.out.println("[NewState] Відправляємо повідомлення: \"" + notification.getMessage() + "\"");
        notification.setState(new SentState(notification));
    }

    @Override
    public void deliver() {
        System.out.println("[NewState] Не можна доставити повідомлення, яке ще не відправлено.");
    }

    @Override
    public void handleError() {
        System.out.println("[NewState] Повідомлення ще нове, немає помилок.");
    }
}
