package notifications.decorator;

public class AdvertisingNotificationDecorator extends NotificationDecorator {

    public AdvertisingNotificationDecorator(INotification notification) {
        super(notification);
    }

    @Override
    public void send() {
        addAdvertising();
        super.send();
    }

    private void addAdvertising() {
        String original = wrappedNotification.getMessage();
        String withAdvertising = original + "\n---\n(Visit our store for more offers!)";
        wrappedNotification.setMessage(withAdvertising);
        System.out.println("[AdvertisingNotificationDecorator] Додано рекламний підпис.");
    }
}
