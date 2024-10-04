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

        // Create a panel for the title
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(new TitlePanel("Mitarbeiterverwaltung", 24), BorderLayout.NORTH);

        // Create a panel for the button with FlowLayout aligned to the right
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton addMitarbeiterButton = new JButton("Mitarbeiter hinzufügen");
        addMitarbeiterButton.setPreferredSize(new Dimension(200, 30));
        addMitarbeiterButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        addMitarbeiterButton.addActionListener(e -> new AddMitarbeiterDialog(this));

        // Add the button to the button panel
        buttonPanel.add(addMitarbeiterButton);

        // Add the button panel to the top panel, below the title panel
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the top panel to the main frame
        add(topPanel, BorderLayout.NORTH);

        // Content panel
        JPanel contentPanel = new JPanel(new BorderLayout());
        add(contentPanel, BorderLayout.CENTER);

        // Add table panel to the content panel
        contentPanel.add(new ShowMitarbeiterTable(), BorderLayout.CENTER);

        // Add bottom panel
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
