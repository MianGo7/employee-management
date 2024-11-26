package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import models.BueroArbeiter;

public class BueroArbeiterTest {
    private BueroArbeiter bueroArbeiter;

    @BeforeEach
    public void setUp() {
        bueroArbeiter = new BueroArbeiter(1, "John Doe", 1000.0);
    }

    @Test
    public void testGetFestgehalt() {
        assertEquals(1000.0, bueroArbeiter.getFestgehalt());
    }

    @Test
    public void testSetFestgehalt() {
        bueroArbeiter.setFestgehalt(1200.0);
        assertEquals(1200.0, bueroArbeiter.getFestgehalt());
    }

    @Test
    public void testSetFestgehaltThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            bueroArbeiter.setFestgehalt(200.0);
        });
    }

    @Test
    public void testEinkommen() {
        assertEquals(1000.0, bueroArbeiter.einkommen());
    }

    @Test
    public void testToString() {
        assertEquals("John Doe hat Festgehalt: 1000.0", bueroArbeiter.toString());
    }

    @Test
    public void testToCSVString() {
        assertEquals("1;John Doe;1000.0;", bueroArbeiter.toCSVString());
    }
}
