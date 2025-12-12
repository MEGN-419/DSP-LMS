package gui.rawPanels;

import gui.guiHandler;
import gui.panelSuper;
import javax.swing.*;
import java.awt.*;

public class clientProfilePanel extends panelSuper {

    public clientProfilePanel() {
        super(500, 400, "My Profile");

        JPanel p = new JPanel(new GridLayout(6, 2, 10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // Read-only fields
        p.add(new JLabel("Member ID:"));
        JTextField idF = new JTextField(String.valueOf(guiHandler.currentUser.memberId));
        idF.setEditable(false);
        p.add(idF);

        p.add(new JLabel("Name:"));
        JTextField nameF = new JTextField(guiHandler.currentUser.name);
        nameF.setEditable(false);
        p.add(nameF);

        // Editable field
        p.add(new JLabel("Contact Info (Email):"));
        JTextField emailF = new JTextField(guiHandler.currentUser.email);
        p.add(emailF);

        // Payment Info
        p.add(new JLabel("Total Fines Due:"));
        // Accessing the bill object total
        JTextField fineF = new JTextField(guiHandler.currentUser.cbill.tFines + " EGP");
        fineF.setEditable(false);
        fineF.setForeground(Color.RED);
        p.add(fineF);

        JButton btnSave = new JButton("Save Changes");
        JButton btnBack = new JButton("Back");

        btnSave.addActionListener(e -> {
            guiHandler.currentUser.email = emailF.getText();
            JOptionPane.showMessageDialog(null, "Contact Info Updated Successfully!");
        });

        btnBack.addActionListener(e -> guiHandler.loadHome(guiHandler.currentUser));

        p.add(btnBack);
        p.add(btnSave);

        setMainPanel(p);
    }
}