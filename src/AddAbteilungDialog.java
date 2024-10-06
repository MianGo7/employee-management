import java.awt.*;
import javax.swing.*;
import java.io.Serial;
import java.util.List;

public class AddAbteilungDialog extends JDialog {
  @Serial
  private static final long serialVersionUID = 1L;
  private JTextField nameField;
  private JTextField managerIdField;
  private JTextField managerNameField;
  private JTextField managerFestgehaltField;
  private JTextField managerBonusField;
  private List<Abteilung> abteilungen;

  public AddAbteilungDialog(JFrame parent, List<Abteilung> abteilungen) {
    super(parent, "Abteilung hinuzufügen", true);
    this.abteilungen = abteilungen;
    initComponents();
  }

  private void initComponents() {
    setSize(800, 650);
    setLayout(new BorderLayout());

    add(new TitlePanel("Abteilung hinzufügen", 20), BorderLayout.NORTH);

    JPanel contentPanel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.fill = GridBagConstraints.HORIZONTAL;

    JLabel nameLabel = new JLabel("Name:");
    nameField = new JTextField(30);
    JLabel managerIdLabel = new JLabel("Manager ID:");
    managerIdField = new JTextField(30);
    JLabel managerNameLabel = new JLabel("Manager Name:");
    managerNameField = new JTextField(30);
    JLabel managerFestgehaltLabel = new JLabel("Manager Festgehalt:");
    managerFestgehaltField = new JTextField(30);
    JLabel managerBonusLabel = new JLabel("Manager Bonus:");
    managerBonusField = new JTextField(30);
    JButton saveButton = new JButton("Hinzufügen");

    gbc.gridx = 0;
    gbc.gridy = 0;
    contentPanel.add(nameLabel, gbc);

    gbc.gridx = 1;
    gbc.gridy = 0;
    contentPanel.add(nameField, gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
    contentPanel.add(managerIdLabel, gbc);

    gbc.gridx = 1;
    gbc.gridy = 1;
    contentPanel.add(managerIdField, gbc);

    gbc.gridx = 0;
    gbc.gridy = 2;
    contentPanel.add(managerNameLabel, gbc);

    gbc.gridx = 1;
    gbc.gridy = 2;
    contentPanel.add(managerNameField, gbc);

    gbc.gridx = 0;
    gbc.gridy = 3;
    contentPanel.add(managerFestgehaltLabel, gbc);

    gbc.gridx = 1;
    gbc.gridy = 3;
    contentPanel.add(managerFestgehaltField, gbc);

    gbc.gridx = 0;
    gbc.gridy = 4;
    contentPanel.add(managerBonusLabel, gbc);

    gbc.gridx = 1;
    gbc.gridy = 4;
    contentPanel.add(managerBonusField, gbc);

    gbc.gridx = 1;
    gbc.gridy = 5;
    contentPanel.add(saveButton, gbc);

    saveButton.addActionListener(e -> validateAndSave());

    add(contentPanel, BorderLayout.CENTER);
    add(new TitlePanel("© 2024 Mitarbeiterverwaltung", 12), BorderLayout.SOUTH);

    setLocationRelativeTo(getParent());
    setVisible(true);
  }

  private void validateAndSave() {
    String name = nameField.getText();
    String managerId = managerIdField.getText();
    String managerName = managerNameField.getText();
    String managerFestgehalt = managerFestgehaltField.getText();
    String managerBonus = managerBonusField.getText();

    if (name.isEmpty() || !name.matches("[A-Za-z ]+")) {
      JOptionPane.showMessageDialog(this, "Name darf nur Buchstaben enthalten und nicht leer sein.");
      return;
    }

    if (managerId.isEmpty() || !managerId.matches("\\d+")) {
      JOptionPane.showMessageDialog(this, "Manager ID muss eine Zahl sein und nicht leer sein.");
      return;
    }

    if (managerName.isEmpty() || !managerName.matches("[A-Za-z ]+")) {
      JOptionPane.showMessageDialog(this, "Manager Name darf nur Buchstaben enthalten und nicht leer sein.");
      return;
    }

    if (managerFestgehalt.isEmpty() || !managerFestgehalt.matches("\\d+")) {
      JOptionPane.showMessageDialog(this, "Manager Festgehalt muss eine Zahl sein und nicht leer sein.");
      return;
    }

    if (managerBonus.isEmpty() || !managerBonus.matches("\\d+")) {
      JOptionPane.showMessageDialog(this, "Manager Bonus muss eine Zahl sein und nicht leer sein.");
      return;
    }

    try {
      Abteilung abteilung = new Abteilung(name, new Manager(Integer.parseInt(managerId), managerName,
          Integer.parseInt(managerFestgehalt), Integer.parseInt(managerBonus)));
      abteilungen.add(abteilung);
      JOptionPane.showMessageDialog(this, "Abteilung hinzugefügt.");
      dispose();
    } catch (IllegalArgumentException e) {
      JOptionPane.showMessageDialog(this, e.getMessage());
    }
  }
}
