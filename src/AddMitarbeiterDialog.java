import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.util.HashMap;
import java.util.Map;

public class AddMitarbeiterDialog extends JDialog {

  @Serial
  private static final long serialVersionUID = 1L;
  private JTextField nameField;
  private JTextField idField;
  private JComboBox<MitarbeiterTyp> typeComboBox;
  private JButton saveButton;
  private JPanel dynamicFieldsPanel;
  private Map<String, JTextField> dynamicFields;

  public AddMitarbeiterDialog(JFrame parent) {
    super(parent, "Mitarbeiter hinzufügen", true);
    initComponents();
  }

  private void initComponents() {
    setSize(800, 650);
    setLayout(new BorderLayout());

    add(new TitlePanel("Mitarbeiter hinzufügen", 20), BorderLayout.NORTH);

    JPanel contentPanel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.fill = GridBagConstraints.HORIZONTAL;

    JLabel typeLabel = new JLabel("Typ:");
    typeComboBox = new JComboBox<>(MitarbeiterTyp.values());
    typeComboBox.setSelectedItem(null);
    JLabel nameLabel = new JLabel("Name:");
    nameField = new JTextField(30);
    JLabel idLabel = new JLabel("ID:");
    idField = new JTextField(30);
    saveButton = new JButton("Hinzufügen");

    nameField.setEnabled(false);
    idField.setEnabled(false);
    saveButton.setEnabled(false);

    gbc.gridx = 0;
    gbc.gridy = 0;
    contentPanel.add(typeLabel, gbc);

    gbc.gridx = 1;
    gbc.gridy = 0;
    contentPanel.add(typeComboBox, gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
    contentPanel.add(nameLabel, gbc);

    gbc.gridx = 1;
    gbc.gridy = 1;
    contentPanel.add(nameField, gbc);

    gbc.gridx = 0;
    gbc.gridy = 2;
    contentPanel.add(idLabel, gbc);

    gbc.gridx = 1;
    gbc.gridy = 2;
    contentPanel.add(idField, gbc);

    dynamicFieldsPanel = new JPanel(new GridBagLayout());
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.gridwidth = 2;
    contentPanel.add(dynamicFieldsPanel, gbc);

    gbc.gridx = 1;
    gbc.gridy = 4;
    gbc.gridwidth = 2;
    contentPanel.add(saveButton, gbc);

    dynamicFields = new HashMap<>();

    typeComboBox.addActionListener(e -> updateDynamicFields());

    saveButton.addActionListener(e -> validateAndSave());

    add(contentPanel, BorderLayout.CENTER);
    add(new TitlePanel("© Mitarbeiterverwaltung 2024", 12), BorderLayout.SOUTH);

    setLocationRelativeTo(getParent());
    setVisible(true);
  }

  private void updateDynamicFields() {
    dynamicFieldsPanel.removeAll();
    dynamicFields.clear();

    MitarbeiterTyp type = (MitarbeiterTyp) typeComboBox.getSelectedItem();
    if (type != null) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.anchor = GridBagConstraints.WEST;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.insets = new Insets(5, 5, 5, 5);

      switch (type) {
        case BUERO -> addDynamicField("Festgehalt", gbc);
        case MANAGER -> {
          addDynamicField("Festgehalt", gbc);
          addDynamicField("Bonus", gbc);
        }
        case SCHICHT -> addDynamicField("Stundensatz", gbc);
        case FAHRER -> {
          addDynamicField("Führerschein Klasse (B, C, D)", gbc);
          addDynamicField("Stundensatz", gbc);
        }
      }
    }

    boolean enabled = type != null;
    nameField.setEnabled(enabled);
    idField.setEnabled(enabled);
    saveButton.setEnabled(enabled);

    dynamicFieldsPanel.revalidate();
    dynamicFieldsPanel.repaint();
  }

  private void addDynamicField(String labelText, GridBagConstraints gbc) {
    JLabel label = new JLabel(labelText + ":");
    JTextField field = new JTextField(30);
    dynamicFieldsPanel.add(label, gbc);
    gbc.gridx = 1;
    dynamicFieldsPanel.add(field, gbc);
    gbc.gridx = 0;
    gbc.gridy++;
    dynamicFields.put(labelText, field);
  }

  private void validateAndSave() {
    String name = nameField.getText();
    String id = idField.getText();
    MitarbeiterTyp type = (MitarbeiterTyp) typeComboBox.getSelectedItem();

    if (name.isEmpty() || !name.matches("[A-Za-z ]+")) {
      JOptionPane.showMessageDialog(this,
          "Name darf nur Buchstaben enthalten und nicht leer sein.");
      return;
    }

    if (id.isEmpty() || !id.matches("\\d+")) {
      JOptionPane.showMessageDialog(this, "ID muss eine Zahl sein und nicht leer sein.");
      return;
    }

    if (type == null) {
      JOptionPane.showMessageDialog(this, "Bitte wählen Sie einen Typ aus.");
      return;
    }

    try {
      switch (type) {
        case BUERO -> {
          String festgehalt = dynamicFields.get("Festgehalt").getText();
          if (festgehalt.isEmpty() || !festgehalt.matches("\\d+")) {
            JOptionPane.showMessageDialog(this,
                "Festgehalt muss eine Zahl sein und nicht leer sein.");
            return;
          }
          new BueroArbeiter(Integer.parseInt(id), name, Integer.parseInt(festgehalt));
        }
        case MANAGER -> {
          String festgehalt = dynamicFields.get("Festgehalt").getText();
          String bonus = dynamicFields.get("Bonus").getText();
          if (festgehalt.isEmpty() || !festgehalt.matches("\\d+")) {
            JOptionPane.showMessageDialog(this,
                "Festgehalt muss eine Zahl sein und nicht leer sein.");
            return;
          }
          if (bonus.isEmpty() || !bonus.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Bonus muss eine Zahl sein und nicht leer sein.");
            return;
          }
          new Manager(Integer.parseInt(id), name, Integer.parseInt(festgehalt),
              Integer.parseInt(bonus));
        }
        case SCHICHT -> {
          String stundensatz = dynamicFields.get("Stundensatz").getText();
          if (stundensatz.isEmpty() || !stundensatz.matches("\\d+")) {
            JOptionPane.showMessageDialog(this,
                "Stundensatz muss eine Zahl sein und nicht leer sein.");
            return;
          }
          new SchichtArbeiter(Integer.parseInt(id), name, Integer.parseInt(stundensatz));
        }
        case FAHRER -> {
          String klasse = dynamicFields.get("Führerschein Klasse (B, C, D)").getText();
          String stundensatz = dynamicFields.get("Stundensatz").getText();
          if (klasse.isEmpty() || !klasse.matches("[BCD]")) {
            JOptionPane.showMessageDialog(this,
                "Führerschein Klasse muss B, C oder D sein und nicht leer sein.");
            return;
          }
          new Fahrer(Integer.parseInt(id), name, Integer.parseInt(stundensatz), klasse);
        }
        default -> throw new IllegalArgumentException("Ungültiger Mitarbeiter-Typ.");
      }
      JOptionPane.showMessageDialog(this, "Mitarbeiter erfolgreich hinzugefügt!");
      dispose(); // Close the dialog after successful addition
    } catch (IllegalArgumentException e) {
      JOptionPane.showMessageDialog(this, e.getMessage());
    }
  }
}