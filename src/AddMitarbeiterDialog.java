import javax.swing.*;
import java.awt.*;

public class AddMitarbeiterDialog {
    //show new input fields for adding a new mitarbeiter
    public void show() {
        JFrame dialog = new JFrame("Mitarbeiter hinzufügen");
        dialog.setSize(800, 650);
        dialog.setLayout(new BorderLayout());
        dialog.setVisible(true);

        //create title panel
        TitlePanel titlePanel = new TitlePanel("Mitarbeiter hinzufügen", 20);
        dialog.add(titlePanel, BorderLayout.NORTH);

        //name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 10, 100, 30);
        dialog.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(120, 10, 200, 30);
        dialog.add(nameField);

        //bottom panel
        TitlePanel bottomPanel = new TitlePanel("© Mitarbeiterverwaltung 2024", 12);
        dialog.add(bottomPanel, BorderLayout.SOUTH);
    }
}
