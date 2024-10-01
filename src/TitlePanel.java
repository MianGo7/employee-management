import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class TitlePanel extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;

    public TitlePanel(String title, int fontSize) {
        setBackground(new Color(41, 128, 185));
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, fontSize));
        titleLabel.setForeground(Color.WHITE);
        add(titleLabel);
    }
}