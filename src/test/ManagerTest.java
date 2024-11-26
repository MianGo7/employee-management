package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import models.Manager;

public class ManagerTest {
    private Manager manager;

    @BeforeEach
    public void setUp() {
        manager = new Manager(1, "John Doe", 50000, 0.1);
    }

    @Test
    public void testGetBonus() {
        assertEquals(0.1, manager.getBonus());
    }

    @Test
    public void testSetBonus() {
        manager.setBonus(0.2);
        assertEquals(0.2, manager.getBonus());
    }

    @Test
    public void testSetBonusThrowsException() {
        manager.setBonus(3.0);
        assertEquals(0.0, manager.getBonus());
    }

    @Test
    public void testBerechneBonus() {
        assertEquals(5000.0, manager.berechneBonus());
    }

    @Test
    public void testEinkommen() {
        assertEquals(55000.0, manager.einkommen());
    }

    @Test
    public void testToString() {
        assertEquals("John Doe hat Festgehalt: 50000.0 zuz\u00fcglich  Bonus 5000.0. Gesamteinkommen: 55000.0", manager.toString());
    }

    @Test
    public void testToCSVString() {
        assertEquals("1;John Doe;50000.0;0.1;", manager.toCSVString());
    }
}
