package notifications.singleton;

import notifications.Notification;

public class NotificationService {
    private static NotificationService instance;

    private NotificationService() {}

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    public void sendNotification(Notification notification) {
        System.out.println("NotificationService: Sending notification -> " + notification.getMessage());
    }
}

