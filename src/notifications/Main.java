package notifications;

import notifications.decorator.*;
import notifications.observer.*;
import notifications.singleton.NotificationService;

public class Main {
    public static void main(String[] args) {

        Notification notification = new Notification("Buy One, Get One Free!", NotificationType.PROMOTION);
        UserObserver user1 = new UserObserver("Alice");
        UserObserver user2 = new UserObserver("Bob");

        notification.attach(user1);
        notification.attach(user2);

        INotification decoratedNotification = new EncryptedNotificationDecorator(new AdvertisingNotificationDecorator(notification));

        decoratedNotification.send();      // переходить у SentState
        decoratedNotification.deliver();   // переходить у DeliveredState
        decoratedNotification.handleError();

        System.out.println("----------");

        NotificationService service = NotificationService.getInstance();
        service.sendNotification(notification);

        NotificationService service2 = NotificationService.getInstance();
        System.out.println("Is it the same instance? " + (service == service2));
    }
}
