package designpatterns.facade;

public class FuelInjector
{
    FuelPump fuelPump = new FuelPump();

    public void on()
    {
        // TODO add functionality
        System.out.println("Turning on fuel injector.");
    }

    public void inject()
    {
        // TODO add functionality
        System.out.println("Injecting fuel");
    }

    public void off()
    {
        // TODO add functionality
        System.out.println("Turning off fuel injector.");
    }
}
