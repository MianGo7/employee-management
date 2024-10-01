import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel {
    public TitlePanel(String title, int fontSize) {
        this.setBackground(new Color(41, 128, 185));
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, fontSize));
        titleLabel.setForeground(Color.WHITE);
        this.add(titleLabel);
    }
}