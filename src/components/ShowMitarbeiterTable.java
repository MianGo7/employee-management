package components;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import javax.swing.table.DefaultTableModel;
import models.Abteilung;
import models.Mitarbeiter;

public class ShowMitarbeiterTable extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;
    private DefaultTableModel tableModel;

  public ShowMitarbeiterTable(List<Abteilung> abteilungen) {
        initComponents(abteilungen);
    }

    private void initComponents(List<Abteilung> abteilungen) {
        setLayout(new BorderLayout());

        String[] columns = {"ID", "Name", "Abteilung", "Typ"};
        tableModel = new DefaultTableModel(columns, 0);

        updateTableModel(abteilungen);

        JTable mitarbeiterTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(mitarbeiterTable);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void updateTableModel(List<Abteilung> abteilungen) {
        tableModel.setRowCount(0); // Clear the table

        for (Abteilung abteilung : abteilungen) {
            for (Mitarbeiter mitarbeiter : abteilung.getMitarbeiter()) {
                Object[] data = {mitarbeiter.getID(), mitarbeiter.getName(), abteilung.getName(), mitarbeiter.getType()};
                tableModel.addRow(data);
            }
        }
    }
}