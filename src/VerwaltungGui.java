import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

public class VerwaltungGui extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;

    // List to store all the Abteilung instances
    private List<Abteilung> abteilungen;
    private ShowMitarbeiterTable showMitarbeiterTable;

    public VerwaltungGui() {
        this.abteilungen = new ArrayList<>();  // Initialize the list of departments
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
        JPanel buttonPanel = getjPanel();

        // Add the button panel to the top panel, below the title panel
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the top panel to the main frame
        add(topPanel, BorderLayout.NORTH);

        // Content panel
        JPanel contentPanel = new JPanel(new BorderLayout());
        add(contentPanel, BorderLayout.CENTER);

        // Add table panel to the content panel
        showMitarbeiterTable = new ShowMitarbeiterTable(abteilungen);
        contentPanel.add(showMitarbeiterTable, BorderLayout.CENTER);

        // Add bottom panel
        add(new TitlePanel("© 2024 Mitarbeiterverwaltung", 12), BorderLayout.SOUTH);
    }

    private JPanel getjPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));


        // Button to add Mitarbeiter
        Button addMitarbeiterButton = new Button("Mitarbeiter hinzufügen", e -> new AddMitarbeiterDialog(this, abteilungen, showMitarbeiterTable));

        // Button to add Abteilung
        Button addAbteilungButton = new Button("Abteilung hinzufügen", e -> new AddAbteilungDialog(this, abteilungen));

        // Add the buttons to the button panel
        buttonPanel.add(addMitarbeiterButton);
        buttonPanel.add(addAbteilungButton);
        return buttonPanel;
    }

    public static void createAndShowGUI() {
        SwingUtilities.invokeLater(() -> {
            VerwaltungGui frame = new VerwaltungGui();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
