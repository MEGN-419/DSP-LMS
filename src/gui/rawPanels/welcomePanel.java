package gui.rawPanels;

import gui.panelSuper;

import javax.swing.*;

public class welcomePanel extends panelSuper {
    private JPanel mainPanel;
    private JButton loginButton;
    private JButton registerButton;
    private JPanel labelPanel;

    public JButton getRegisterButton() {
        if (debug){
            System.out.println("getting register button(raw welcome)");
        }
        return registerButton;
    }

    public JButton getLoginButton() {
        if (debug){
            System.out.println("getting login button(raw welcome)");
        }
        return loginButton;
    }

    @Override
    public JPanel getMainPanel() {
        if (debug){
            System.out.println("getting main panel(raw welcome)");
        }
        return mainPanel;
    }

    private JPanel butonPanel;
    public welcomePanel() {
        super(222, 147, "welcome");
        super.setMainPanel(mainPanel);
        System.out.println(">>creating a new raw welcome panel");
    }
}
