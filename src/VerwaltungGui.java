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
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(41, 128, 185));
        JLabel titleLabel = new JLabel("Mitarbeiterverwaltung");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);

        //create bottom panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(41, 128, 185));
        JLabel bottomLabel = new JLabel("© Mitarbeiterverwaltung 2024");
        bottomLabel.setFont(new Font("Arial", Font.BOLD, 12));
        bottomLabel.setForeground(Color.WHITE);
        bottomPanel.add(bottomLabel);

        //add panels to frame
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(bottomPanel, BorderLayout.SOUTH);
    }
}
