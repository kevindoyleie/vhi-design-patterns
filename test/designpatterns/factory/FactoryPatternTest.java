package designpatterns.factory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class FactoryPatternTest
{
    private NotificationFactory notificationFactory = new NotificationFactory();

    @Test
    public void whenNull()
    {
        Notification notification = notificationFactory.createNotification(null);

        assertNull(notification);
    }

    @Test
    public void whenEmptyString()
    {
        Notification notification = notificationFactory.createNotification("");

        assertNull(notification);
    }

    @Test
    public void whenSMS()
    {
        Notification notification = notificationFactory.createNotification("SMS");

        assertEquals("Sending an SMS notification", notification.notifyUser());
    }

    @Test
    public void whenEmail()
    {
        Notification notification = notificationFactory.createNotification("EMAIL");

        assertEquals("Sending an e-mail notification", notification.notifyUser());
    }

    @Test
    public void whenPush()
    {
        Notification notification = notificationFactory.createNotification("PUSH");

        assertEquals("Sending a push notification", notification.notifyUser());
    }

    @Test
    public void whenNotDefined()
    {
        Notification notification = notificationFactory.createNotification("TEST");

        assertNull(notification);
    }
}