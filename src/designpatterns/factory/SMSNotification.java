package designpatterns.factory;

public class SMSNotification implements Notification
{

    @Override
    public String notifyUser()
    {
        return "Sending an SMS notification";
    }
}
