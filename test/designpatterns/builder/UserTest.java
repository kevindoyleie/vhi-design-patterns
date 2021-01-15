package designpatterns.builder;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class UserTest
{
    User user;

    @Before
    public void setUp()
    {
        user = new User.UserBuilder("John", "Doe").build();
    }

    @Test
    public void getFirstName()
    {
        assertEquals("John", user.getFirstName());
    }

    @Test
    public void getLastName()
    {
        assertEquals("Doe", user.getLastName());
    }

    @Test
    public void getAge()
    {
        user = new User.UserBuilder("John", "Doe").age(40).build();

        assertEquals(40, user.getAge());
    }

    @Test
    public void getPhone()
    {
        user = new User.UserBuilder("John", "Doe").phone("0861234567").build();

        assertEquals("0861234567", user.getPhone());
    }

    @Test
    public void getAddress()
    {
        user = new User.UserBuilder("John", "Doe").address("123 Main Street, Kilkenny").build();

        assertEquals("123 Main Street, Kilkenny", user.getAddress());
    }

    @Test
    public void whenToString()
    {
        user = new User.UserBuilder("John", "Doe")
                .age(41)
                .phone("0871234567")
                .address("123 Main Street, Kilkenny").build();

        assertEquals("User: John, Doe, 41, 0871234567, 123 Main Street, Kilkenny", user.toString());
    }

    @Test
    public void getEverything()
    {
        user = new User.UserBuilder("John", "Doe")
                .age(41)
                .phone("0871234567")
                .address("123 Main Street, Kilkenny").build();

        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals(41, user.getAge());
        assertEquals("0871234567", user.getPhone());
        assertEquals("123 Main Street, Kilkenny", user.getAddress());
    }
}