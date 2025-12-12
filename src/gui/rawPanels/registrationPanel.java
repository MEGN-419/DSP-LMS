package gui.rawPanels;

import gui.guiHandler;
import gui.panelSuper;
import handling.dataHandler;
import obj.client;
import javax.swing.*;
import java.awt.*;

public class registrationPanel extends panelSuper {
    public registrationPanel() {
        super(400, 400, "Registration");

        JPanel p = new JPanel(new GridLayout(6, 2, 10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField nameF = new JTextField();
        JTextField emailF = new JTextField();
        JPasswordField passF = new JPasswordField();

        // ID is auto-generated in this logic
        JLabel idLabel = new JLabel("ID will be: " + (2000 + dataHandler.clientCount));

        JButton btnReg = new JButton("Register");
        JButton btnBack = new JButton("Back");

        p.add(new JLabel("Full Name:")); p.add(nameF);
        p.add(new JLabel("Email:")); p.add(emailF);
        p.add(new JLabel("Password:")); p.add(passF);
        p.add(new JLabel("Your ID:")); p.add(idLabel);
        p.add(new JLabel("")); p.add(new JLabel("")); // Spacer
        p.add(btnBack); p.add(btnReg);

        btnReg.addActionListener(e -> {
            String name = nameF.getText();
            String email = emailF.getText();
            String pass = new String(passF.getPassword());

            if (!name.isEmpty() && !pass.isEmpty()) {
                int newId = 2000 + dataHandler.clientCount;
                // Defaulting new registrations to "user" type
                client newC = new client(newId, name, email, pass, "user");
                dataHandler.storage.clients.add(newC);
                dataHandler.clientCount++;

                JOptionPane.showMessageDialog(null, "Registration Successful!\nPlease Login.");
                guiHandler.loadLogin();
            } else {
                JOptionPane.showMessageDialog(null, "Please fill all fields.");
            }
        });

        btnBack.addActionListener(e -> guiHandler.loadWelcome());

        setMainPanel(p);
    }
}