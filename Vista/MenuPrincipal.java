package Vista;

import java.awt.*;
import javax.swing.*;

public class MenuPrincipal extends JFrame {
    private CardLayout cardLayout;
    public MenuPanel menuPanel;
    public SalarioNetoPanel salarioNetoPanel;
    public VacacionesPanel vacacionesPanel;
    public AguinaldoPanel aguinaldoPanel; // Nuevo panel de aguinaldo

    public MenuPrincipal() {
        setTitle("Sistema de Cálculo Laboral");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        setLayout(cardLayout);

        
        menuPanel = new MenuPanel();
        salarioNetoPanel = new SalarioNetoPanel();
        vacacionesPanel = new VacacionesPanel();
        aguinaldoPanel = new AguinaldoPanel(); // Instancia de AguinaldoPanel

        add(menuPanel, "menu");
        add(salarioNetoPanel, "salarioNeto");
        add(vacacionesPanel, "vacaciones");
        add(aguinaldoPanel, "aguinaldo"); // Añadir el panel de aguinaldo al CardLayout
    }
}
