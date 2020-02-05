package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void canGetDefaultPrice() {
        Visitor visitor = new Visitor(20, 175.00, 20.00);
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0.01);
    }

    @Test
    public void canGetPriceForNotTallPeople() {
        Visitor visitor = new Visitor(20, 175.00, 20.00);
        assertEquals(8.40, rollerCoaster.priceFor(visitor), 0.01);
    }

    @Test
    public void canGetPriceForTallPeople() {
        Visitor visitor = new Visitor(20, 205.00, 20.00);
        assertEquals(16.80, rollerCoaster.priceFor(visitor), 0.01);
    }

    @Test
    public void mustBeTallAndOld() {
        Visitor visitor = new Visitor(20, 150.00, 25.00);
        assertTrue(rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void cannotRideWhenTallAndYoung() {
        Visitor visitor = new Visitor(2, 150.00, 25.00);
        assertFalse(rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void cannotRideWhenSmallAndOld() {
        Visitor visitor = new Visitor(20, 130.00, 25.00);
        assertFalse(rollerCoaster.isAllowedTo(visitor));
    }
}
