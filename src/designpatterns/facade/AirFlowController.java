package designpatterns.facade;

public class AirFlowController
{
    AirFlowMeter airFlowMeter = new AirFlowMeter();

    public void takeAir()
    {
        // TODO add functionality
        System.out.println("Taking in air...");
        airFlowMeter.getMeasurement();
    }

    public void off()
    {
        // TODO add functionality
        System.out.println("Turning off air flow...");
    }
}
