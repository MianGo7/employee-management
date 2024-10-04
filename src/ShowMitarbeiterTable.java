import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class ShowMitarbeiterTable extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;

    public ShowMitarbeiterTable() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        //JTable with mitarbeiter
        JTable mitarbeiterTable = new JTable();

        //get data from database
    }
}