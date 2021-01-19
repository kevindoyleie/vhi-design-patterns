package designpatterns.facade;

public class FuelPump
{
    public void pump()
    {
        System.out.println("Pumping in fuel...");
    }

    public void on()
    {
        System.out.println("Turning on fuel pump...");
    }

    public void off()
    {
        System.out.println("Turning off fuel pump...");
    }
}
