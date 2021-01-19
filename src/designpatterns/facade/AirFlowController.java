package designpatterns.facade;

public class AirFlowController
{
    AirFlowMeter airFlowMeter = new AirFlowMeter();

    public void takeAir()
    {
        System.out.println("Taking in air...");
        airFlowMeter.getMeasurement();
    }

    public void off()
    {
        System.out.println("Turning off air flow...");
    }
}
