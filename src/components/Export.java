package components;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import models.Abteilung;
import models.Mitarbeiter;

public class Export {
  private final List<Abteilung> abteilungen;

  public Export(List<Abteilung> abteilungen) {
    this.abteilungen = abteilungen;
    exportToCSV();
  }

  private void exportToCSV() {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Specify a file to save");
    fileChooser.setFileFilter(new FileNameExtensionFilter("CSV files (*.csv)", "csv"));

    int userSelection = fileChooser.showSaveDialog(null);

    if (userSelection == JFileChooser.APPROVE_OPTION) {
      String filePath = fileChooser.getSelectedFile().getAbsolutePath();
      if (!filePath.toLowerCase().endsWith(".csv")) {
        filePath += ".csv";
      }

      try (FileWriter writer = new FileWriter(filePath)) {
        // Write CSV header
        writer.append(String.join(",", "ID", "Name", "Abteilung", "Typ", "Einkommen"));
        writer.append("\n");

        // Write data for each Mitarbeiter
        for (Abteilung abteilung : abteilungen) {
          for (Mitarbeiter mitarbeiter : abteilung.getMitarbeiter()) {
            writer.append(String.join(",",
                String.valueOf(mitarbeiter.getID()),
                mitarbeiter.getName(),
                abteilung.getName(),
                mitarbeiter.getType().toString(),
                String.valueOf(mitarbeiter.einkommen())
            ));
            writer.append("\n");
          }
        }

        writer.flush();
        JOptionPane.showMessageDialog(null, "Export erfolgreich abgeschlossen.", "Export", JOptionPane.INFORMATION_MESSAGE);
      } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Fehler beim Exportieren: " + e.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
      }
    }
  }
}