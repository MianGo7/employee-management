import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Button extends JButton {

    public Button(String text) {
        super(text);
        init();
    }

    public Button(String text, ActionListener actionListener) {
        super(text);
        addActionListener(actionListener);
        init();
    }

    private void init() {
        setPreferredSize(new Dimension(200, 30));
        setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
    }

    public void setButtonFont(Font font) {
        setFont(font);
    }

    public void setButtonSize(Dimension dimension) {
        setPreferredSize(dimension);
    }

    public void setButtonColor(Color color) {
        setBackground(color);
    }
}