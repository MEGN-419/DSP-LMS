package gui.rawPanels;

import gui.panelSuper;

import javax.swing.*;

public class homePanel extends panelSuper {
    @Override
    public JPanel getMainPanel() {
        return mainPanel;
    }
    private JPanel mainPanel;
    private JLabel nameLabel;
    private JLabel idLabel;
    private JLabel usernameLabel;

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public JLabel getUsernameLabel() {
        return usernameLabel;
    }

    public JLabel getIdLabel() {
        return idLabel;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    private JLabel passwordLabel;

    public JButton getLoginOutButton() {
        return loginOutButton;
    }

    private JButton loginOutButton;
    private JPanel infoPanel;
    private JPanel buttonPanel;

    public homePanel() {
        super(600, 400, "home");
        super.setMainPanel(mainPanel);
        System.out.println(">>creating a new home panel");
    }
}
