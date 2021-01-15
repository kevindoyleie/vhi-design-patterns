package designpatterns.factory;

public class PushNotification implements Notification
{

    @Override
    public String notifyUser()
    {
        return "Sending a push notification";
    }
}
