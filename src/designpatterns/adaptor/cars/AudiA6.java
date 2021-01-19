package designpatterns.adaptor.cars;

import designpatterns.adaptor.cars.Movable;

public class AudiA6 implements Movable
{

    @Override
    public double getSpeed()
    {
        return 210;
    }
}
