import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class VerwaltungGui extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;

    public VerwaltungGui() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Mitarbeiterverwaltung");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1366, 768);
        setLayout(new BorderLayout(10, 10));

        add(new TitlePanel("Mitarbeiterverwaltung", 24), BorderLayout.NORTH);

        //content panel
        JPanel contentPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        //add Mitarbeiter button
        JButton addMitarbeiterButton = new JButton("Mitarbeiter hinzufügen");
        addMitarbeiterButton.setPreferredSize(new Dimension(200, 50));
        addMitarbeiterButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        addMitarbeiterButton.addActionListener(e -> new AddMitarbeiterDialog(this));
        add(addMitarbeiterButton, BorderLayout.CENTER);

        add(new TitlePanel("© 2024 Mitarbeiterverwaltung", 12), BorderLayout.SOUTH);
    }

    public static void createAndShowGUI() {
        SwingUtilities.invokeLater(() -> {
            VerwaltungGui frame = new VerwaltungGui();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}