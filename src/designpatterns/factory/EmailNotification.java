package designpatterns.factory;

public class EmailNotification implements Notification
{

    @Override
    public String notifyUser()
    {
        return "Sending an e-mail notification";
    }
}
