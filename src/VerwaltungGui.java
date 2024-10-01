import javax.swing.*;
import java.awt.*;

public class VerwaltungGui {
    public static void gui() {
        //create main frame
        JFrame frame = new JFrame("Mitarbeiterverwaltung");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1366, 768);
        frame.setLayout(new BorderLayout(10, 10));
        frame.setVisible(true);

        //create title panel
        TitlePanel titlePanel = new TitlePanel("Mitarbeiterverwaltung", 24);
        frame.add(titlePanel, BorderLayout.NORTH);

        //create add and save mitarbeiter
        JButton addMitarbeiterButton = new JButton("Mitarbeiter hinzufügen");
        addMitarbeiterButton.addActionListener(e -> {
            AddMitarbeiterDialog dialog = new AddMitarbeiterDialog();
            dialog.show();
        });
        frame.add(addMitarbeiterButton, BorderLayout.CENTER);


        //create bottom panel
        TitlePanel bottomPanel = new TitlePanel("© 2021 Mitarbeiterverwaltung", 12);
        frame.add(bottomPanel, BorderLayout.SOUTH);
    }
}

