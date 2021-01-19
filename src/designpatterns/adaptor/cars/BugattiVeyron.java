package designpatterns.adaptor.cars;

import designpatterns.adaptor.cars.Movable;

public class BugattiVeyron implements Movable
{
    @Override
    public double getSpeed()
    {
        return 268;
    }
}