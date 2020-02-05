package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class PlaygroundTest {
    Playground playground;

    @Before
    public void setUp() throws Exception {
        playground = new Playground("Fun Zone", 7);
    }

    @Test
    public void hasName() {
        assertEquals("Fun Zone", playground.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(7, playground.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, playground.getVisitCount());
    }

    @Test
    public void mustBeKidToPlay() {
        Visitor visitor = new Visitor(12, 130.00, 5.00);
        assertTrue(playground.isAllowedTo(visitor));
    }

    @Test
    public void canBe15() {
        Visitor visitor = new Visitor(15, 130.00, 5.00);
        assertTrue(playground.isAllowedTo(visitor));
    }

    @Test
    public void cannotBeAdult() {
        Visitor visitor = new Visitor(16, 130.00, 5.00);
        assertFalse(playground.isAllowedTo(visitor));
    }
}
