package Vista;

import java.awt.*;
import javax.swing.*;

public class RoundedTextField extends JTextField {

    public RoundedTextField(String placeholder) {
        super(placeholder);
        setFont(new Font("Segoe UI", Font.PLAIN, 14));
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (g instanceof Graphics2D) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15); // Bordes redondeados
        }
        super.paintComponent(g);
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
    }
}
