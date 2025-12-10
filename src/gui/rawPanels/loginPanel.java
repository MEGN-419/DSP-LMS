package gui.rawPanels;

import gui.panelSuper;

import javax.swing.*;

public class loginPanel extends panelSuper {
    private JPanel mainPanel;
    private JPanel inputPanel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JPanel butonPanel;
    private JButton loginButton;

    public loginPanel() {
        super(272, 172, "login");
        super.setMainPanel(mainPanel);
    }

    public JButton getBackButton() {
        if (debug){
            System.out.println("getting back button(raw login)");
        }
        return backButton;
    }
    public JButton getLoginButton() {
        if (debug){
            System.out.println("getting login button(raw login)");
        }
        return loginButton;
    }
    public JPasswordField getPasswordField1() {
        if (debug){
            System.out.println("getting password field(raw login)");
        }
        return passwordField1;
    }
    public JTextField getTextField1() {
        if (debug){
            System.out.println("getting text field(raw login)");
        }
        return textField1;
    }
    public JPanel getMainPanel() {
        if (debug){
            System.out.println("getting main panel(raw login)");
        }
        return mainPanel;
    }
    private JButton backButton;
}
