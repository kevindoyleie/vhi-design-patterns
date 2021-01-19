package designpatterns.facade;

public class FuelInjector
{
    FuelPump fuelPump = new FuelPump();

    public void on()
    {
        System.out.println("Turning on fuel injector.");
        fuelPump.on();
    }

    public void inject()
    {
        System.out.println("Injecting fuel");
        fuelPump.pump();
    }

    public void off()
    {
        System.out.println("Turning off fuel injector.");
        fuelPump.off();
    }
}
