package notifications.decorator;

public class EncryptedNotificationDecorator extends NotificationDecorator {

    public EncryptedNotificationDecorator(INotification notification) {
        super(notification);
    }

    @Override
    public void send() {
        encrypt();
        super.send();
    }

    private void encrypt() {
        String original = wrappedNotification.getMessage();
        // Проста імітація шифрування: реверс рядка
        String encrypted = new StringBuilder(original).reverse().toString();
        wrappedNotification.setMessage("Encrypted: " + encrypted);
        System.out.println("[EncryptedNotificationDecorator] Повідомлення зашифровано.");
    }
}
