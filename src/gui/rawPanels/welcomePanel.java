package gui.rawPanels;

import gui.guiHandler;
import gui.panelSuper;
import javax.swing.*;
import java.awt.*;

public class welcomePanel extends panelSuper {
    public welcomePanel() {
        super(400, 300, "Welcome to AIU Library");

        JPanel p = new JPanel(new GridLayout(3, 1, 10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        JLabel title = new JLabel("Library Management System", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));

        JButton btnLogin = new JButton("Login");
        JButton btnRegister = new JButton("Register");

        btnLogin.addActionListener(e -> guiHandler.loadLogin());
        btnRegister.addActionListener(e -> guiHandler.loadRegistration());

        p.add(title);
        p.add(btnLogin);
        p.add(btnRegister);

        setMainPanel(p);
    }
}