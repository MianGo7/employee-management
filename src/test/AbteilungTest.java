package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import models.Abteilung;
import models.Manager;
import models.Mitarbeiter;
import models.SchichtArbeiter;

public class AbteilungTest {
    private Abteilung abteilung;
    private Manager manager;
    private SchichtArbeiter mitarbeiter;

    @BeforeEach
    public void setUp() {
        manager = new Manager(1, "John Doe", 50000, 5000);
        abteilung = new Abteilung("IT", manager);
        mitarbeiter = new SchichtArbeiter(2, "Jane Smith", 20.0);
    }

    @Test
    public void testAddMitarbeiter() {
        abteilung.add(mitarbeiter);
        assertTrue(abteilung.getMitarbeiter().contains(mitarbeiter));
    }

    @Test
    public void testRemoveMitarbeiter() {
        abteilung.add(mitarbeiter);
        abteilung.remove(mitarbeiter);
        assertFalse(abteilung.getMitarbeiter().contains(mitarbeiter));
    }

    @Test
    public void testChangeLeiter() {
        Manager newManager = new Manager(3, "Alice Johnson", 60000, 6000);
        Manager oldManager = abteilung.changeLeiter(newManager);
        assertEquals(manager, oldManager);
        assertEquals(newManager, abteilung.getLeiter());
    }

    @Test
    public void testGehaltsListe() {
        abteilung.add(mitarbeiter);
        String gehaltsListe = abteilung.gehaltsListe();
        assertTrue(gehaltsListe.contains("John Doe: 55000.0"));
        assertTrue(gehaltsListe.contains("Jane Smith: 0.0"));
        assertTrue(gehaltsListe.contains("Lohnkosten der Abteilung: 55000.0"));
    }

    @Test
    public void testGetName() {
        assertEquals("IT", abteilung.getName());
    }

    @Test
    public void testSetName() {
        abteilung.setName("HR");
        assertEquals("HR", abteilung.getName());
    }

    @Test
    public void testToString() {
        assertEquals("IT", abteilung.toString());
    }
}