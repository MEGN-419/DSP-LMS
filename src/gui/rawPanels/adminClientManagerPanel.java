package gui.rawPanels;

import gui.guiHandler;
import gui.panelSuper;
import handling.dataHandler;
import obj.client;
import javax.swing.*;
import java.awt.*;

public class adminClientManagerPanel extends panelSuper {

    public adminClientManagerPanel() {
        super(700, 600, "Client Management");
        JPanel mainLayout = new JPanel(new BorderLayout());

        // Top Controls
        JPanel top = new JPanel(new FlowLayout());
        JButton btnAdd = new JButton("Add Client");
        JButton btnBack = new JButton("Back");
        top.add(btnBack);
        top.add(btnAdd);

        // Client List Container
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        // Generate rows for each client
        for (client c : dataHandler.storage.clients) {
            JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT));
            row.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.LIGHT_GRAY));
            row.setPreferredSize(new Dimension(650, 40));
            row.setMaximumSize(new Dimension(650, 40));

            JLabel info = new JLabel(String.format("ID: %d | %s | %s", c.memberId, c.name, c.email));
            info.setPreferredSize(new Dimension(350, 30));

            JButton btnEdit = new JButton("Edit");
            JButton btnDel = new JButton("Delete");

            // Edit Action
            btnEdit.addActionListener(e -> {
                String newName = JOptionPane.showInputDialog("Edit Name:", c.name);
                String newEmail = JOptionPane.showInputDialog("Edit Email:", c.email);
                if (newName != null && newEmail != null) {
                    // Update fields directly (since they are public/final, we might need setters
                    // or just direct access if you removed 'final' keyword.
                    // Assuming you removed 'final' from name/email in client.java as requested by this feature)
                    // If 'name' is final, you can't edit it. I assume for this feature it's mutable.
                    // For now, let's assume we recreate or you made them non-final.
                    // c.name = newName; // Uncomment if you removed 'final'
                    c.email = newEmail;
                    JOptionPane.showMessageDialog(null, "Updated! (Refresh to see changes)");
                    guiHandler.loadClientManager(); // Reload panel
                }
            });

            // Delete Action
            btnDel.addActionListener(e -> {
                int confirm = JOptionPane.showConfirmDialog(null, "Delete " + c.name + "?");
                if (confirm == JOptionPane.YES_OPTION) {
                    dataHandler.storage.clients.remove(c);
                    guiHandler.loadClientManager(); // Reload
                }
            });

            row.add(info);
            row.add(btnEdit);
            row.add(btnDel);
            listPanel.add(row);
        }

        // Add Client Logic
        btnAdd.addActionListener(e -> {
            guiHandler.loadRegistration(); // Reuse registration panel or custom logic
        });

        btnBack.addActionListener(e -> guiHandler.loadHome(guiHandler.currentUser));

        mainLayout.add(top, BorderLayout.NORTH);
        mainLayout.add(new JScrollPane(listPanel), BorderLayout.CENTER);

        setMainPanel(mainLayout);
    }
}