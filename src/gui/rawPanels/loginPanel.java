package gui.rawPanels;

import gui.guiHandler;
import gui.panelSuper;
import handling.dataHandler;
import obj.client;
import javax.swing.*;
import java.awt.*;

public class loginPanel extends panelSuper {
    public loginPanel() {
        super(400, 300, "Login");

        // Main container
        JPanel p = new JPanel(new GridLayout(4, 2, 10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        // Components
        JTextField userF = new JTextField();
        JPasswordField passF = new JPasswordField();
        JButton btnLogin = new JButton("Login");
        JButton btnBack = new JButton("Back"); // The missing button

        // Add to panel
        p.add(new JLabel("Username:"));
        p.add(userF);

        p.add(new JLabel("Password:"));
        p.add(passF);

        p.add(new JLabel("")); // Spacer
        p.add(new JLabel("")); // Spacer

        p.add(btnBack);
        p.add(btnLogin);

        // Logic
        btnLogin.addActionListener(e -> {
            String u = userF.getText();
            String pass = new String(passF.getPassword());
            client c = dataHandler.login(u, pass);
            if(c != null) {
                guiHandler.loadHome(c);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Credentials");
            }
        });

        // Back Button Logic
        btnBack.addActionListener(e -> {
            guiHandler.loadWelcome();
        });

        setMainPanel(p);
    }
}