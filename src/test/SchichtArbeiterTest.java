package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import models.SchichtArbeiter;

public class SchichtArbeiterTest {
    private SchichtArbeiter schichtArbeiter;

    @BeforeEach
    public void setUp() {
        schichtArbeiter = new SchichtArbeiter(1, "John Doe", 10.0);
    }

    @Test
    public void testGetStundenSatz() {
        assertEquals(10.0, schichtArbeiter.getStundenSatz());
    }

    @Test
    public void testSetStundenSatz() {
        schichtArbeiter.setStundenSatz(12.0);
        assertEquals(12.0, schichtArbeiter.getStundenSatz());
    }

    @Test
    public void testSetStundenSatzThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            schichtArbeiter.setStundenSatz(8.0);
        });
    }

    @Test
    public void testGetAnzahlStunden() {
        assertEquals(0, schichtArbeiter.getAnzahlStunden());
    }

    @Test
    public void testSetAnzahlStunden() {
        schichtArbeiter.setAnzahlStunden(40);
        assertEquals(40, schichtArbeiter.getAnzahlStunden());
    }

    @Test
    public void testArbeite() {
        schichtArbeiter.arbeite(5);
        assertEquals(5, schichtArbeiter.getAnzahlStunden());
    }

    @Test
    public void testEinkommen() {
        schichtArbeiter.setAnzahlStunden(40);
        assertEquals(400.0, schichtArbeiter.einkommen());
    }

    @Test
    public void testToString() {
        assertEquals("\nID: 3001 Name: John Doe Einkommen: 0.0 bei 0 gearbeiteten Stunden.", schichtArbeiter.toString());
    }

    @Test
    public void testToCSVString() {
        assertEquals("SCHICHT;3001;John Doe;10.0;0;", schichtArbeiter.toCSVString());
    }
}