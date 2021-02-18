package designpatterns.factory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class FactoryPatternTest
{
    private final NotificationFactory notificationFactory = new NotificationFactory();
    private Notification notification;

    @Test
    public void whenNull()
    {
        notification = notificationFactory.createNotification(null);

        assertNull(notification);
    }

    @Test
    public void whenEmptyString()
    {
        notification = notificationFactory.createNotification("");

        assertNull(notification);
    }

    @Test
    public void whenSMS()
    {
        notification = notificationFactory.createNotification("SMS");

        assertEquals("Sending an SMS notification", notification.notifyUser());
    }

    @Test
    public void whenEmail()
    {
        notification = notificationFactory.createNotification("EMAIL");

        assertEquals("Sending an e-mail notification", notification.notifyUser());
    }

    @Test
    public void whenPush()
    {
        notification = notificationFactory.createNotification("PUSH");

        assertEquals("Sending a push notification", notification.notifyUser());
    }

    @Test
    public void whenNotDefined()
    {
        notification = notificationFactory.createNotification("TEST");

        assertNull(notification);
    }
}