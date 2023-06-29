package designpatterns.mediator;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;


public class MediatorTest
{
    @Test
    public void runMediator()
    {
        Mediator<Integer> mediator = new Mediator<>();
        mediator.setValue("bob", 20);
        mediator.setValue("alice", 24);
        mediator.getValue("alice").ifPresent(age -> System.out.println("age for alice: " + age));

        assertEquals(Optional.of(20), mediator.getValue("bob"));
        assertEquals(Optional.of(24), mediator.getValue("alice"));

        mediator.addObserver("bob", () -> System.out.println("new age for bob: " + mediator.getValue("bob").orElseThrow(RuntimeException::new)));
        mediator.setValue("bob", 21);

        assertEquals(Optional.of(21), mediator.getValue("bob"));
        assertEquals(Optional.of(24), mediator.getValue("alice"));
    }
}