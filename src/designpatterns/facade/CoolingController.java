package designpatterns.facade;

public class CoolingController
{
    Radiator radiator = new Radiator();
    TemperatureSensor temperatureSensor = new TemperatureSensor();

    public void setTemperatureUpperLimit(int defaultCoolingTemp)
    {
        // TODO add functionality
        System.out.println("Setting upper temp limit to " + defaultCoolingTemp);
    }

    public void run()
    {
        // TODO add functionality
        System.out.println("Running cooling controller");
    }

    public void cool(int maxAllowedTemp)
    {
        // TODO add functionality
        System.out.println("Cool down...");
    }

    public void stop()
    {
        // TODO add functionality
        System.out.println("Turning off cooling controller.");
    }
}
