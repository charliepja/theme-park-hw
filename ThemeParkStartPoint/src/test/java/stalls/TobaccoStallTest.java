package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 3);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void mustBeAdultToSmoke() {
        Visitor visitor = new Visitor(21, 170.00, 30.00);
        assertTrue(tobaccoStall.isAllowedTo(visitor));
    }

    @Test
    public void cannotSmokeAsKid() {
        Visitor visitor = new Visitor(17, 180.00, 30.00);
        assertFalse(tobaccoStall.isAllowedTo(visitor));
    }

    @Test
    public void canSmokeAt18() {
        Visitor visitor = new Visitor(18, 200.00, 30.00);
        assertTrue(tobaccoStall.isAllowedTo(visitor));
    }
}
