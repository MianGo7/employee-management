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

        JButton addMitarbeiterButton = new JButton("Mitarbeiter hinzufügen");
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