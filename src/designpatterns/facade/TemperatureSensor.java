package designpatterns.facade;

public class TemperatureSensor
{
    private final int temperature = 35;
    private int temperatureUpperLimit;

    public int getTemperature()
    {
        return temperature;
    }

    public void setTemperatureUpperLimit(int temperatureUpperLimit)
    {
        this.temperatureUpperLimit = temperatureUpperLimit;
    }

    public int getTemperatureUpperLimit()
    {
        return temperatureUpperLimit;
    }
}
