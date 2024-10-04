import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import javax.swing.table.DefaultTableModel;

public class ShowMitarbeiterTable extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;

    public ShowMitarbeiterTable() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        JTable mitarbeiterTable = new JTable();

        String[] columns = {"ID", "Name", "Age", "Department"};
        Object[][] data = {
                {1, "Alice", 25, "Engineering"},
                {2, "Bob", 30, "Human Resources"},
                {3, "Charlie", 22, "Sales"},
                {4, "David", 35, "Marketing"}
        };

        mitarbeiterTable.setModel(new DefaultTableModel(data, columns));

        JScrollPane scrollPane = new JScrollPane(mitarbeiterTable);
        add(scrollPane, BorderLayout.CENTER);
    }
}