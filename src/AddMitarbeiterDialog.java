import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class AddMitarbeiterDialog extends JDialog {
    @Serial
    private static final long serialVersionUID = 1L;

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

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPanel.add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPanel.add(nameField, gbc);

        add(contentPanel, BorderLayout.CENTER);
        add(new TitlePanel("© Mitarbeiterverwaltung 2024", 12), BorderLayout.SOUTH);

        setLocationRelativeTo(getParent());
        setVisible(true);
    }
}