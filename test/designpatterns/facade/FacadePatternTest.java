package designpatterns.facade;

import org.junit.Before;
import org.junit.Test;

public class FacadePatternTest
{
    CarEngineFacade carEngine;

    @Before
    public void setUp()
    {
        carEngine = new CarEngineFacade();
    }

    @Test
    public void testName()
    {
        carEngine.startEngine();
        carEngine.stopEngine();
    }
}
