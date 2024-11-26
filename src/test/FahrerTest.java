package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import models.Fahrer;

public class FahrerTest {
    private Fahrer fahrer;

    @BeforeEach
    public void setUp() {
        fahrer = new Fahrer(1, "John Doe", 20.0, "B");
    }

    @Test
    public void testGetFuehrerSchein() {
        assertEquals("B", fahrer.getFuehrerSchein());
    }

    @Test
    public void testSetFuehrerSchein() {
        fahrer.setFuehrerSchein("C");
        assertEquals("C", fahrer.getFuehrerSchein());
    }

    @Test
    public void testSetFuehrerScheinThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            fahrer.setFuehrerSchein("E");
        });
    }

    @Test
    public void testEinkommen() {
        assertEquals(0.0, fahrer.einkommen());
    }

    @Test
    public void testToString() {
        assertEquals("John Doe hat Fuehrerscheinklasse B", fahrer.toString());
    }

    @Test
    public void testToCSVString() {
        assertEquals("1;John Doe;20.0;B;", fahrer.toCSVString());
    }
}
