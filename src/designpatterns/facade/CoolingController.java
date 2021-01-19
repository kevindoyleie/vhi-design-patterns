package designpatterns.facade;

public class CoolingController
{
    private final Radiator radiator = new Radiator();
    private final TemperatureSensor temperatureSensor = new TemperatureSensor();

    public void setTemperatureUpperLimit(int temperatureUpperLimit)
    {
        System.out.println("Setting upper temp limit to " + temperatureUpperLimit);
        temperatureSensor.setTemperatureUpperLimit(temperatureUpperLimit);
    }

    public void run()
    {
        System.out.println("Running cooling controller");

    }

    public void cool(int maxAllowedTemp)
    {
        if (temperatureSensor.getTemperature() >= maxAllowedTemp) {
            System.out.println("Cool down...");
            radiator.off();
        } else {
            radiator.on();
        }
    }

    public void stop()
    {
        System.out.println("Turning off cooling controller.");
    }
}
