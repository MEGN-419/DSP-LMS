package gui.rawPanels;

import gui.panelSuper;

import javax.swing.*;

public class registrationPanel extends panelSuper {
    private JPanel mainPanel;
    private JPanel inputPanel;
    private JPanel typePanel;
    private JPanel buttonPanel;
    private JTextField nameField1;
    private JTextField idField2;
    private JTextField usernameField3;
    private JPasswordField passwordField1;
    private JRadioButton userRadioButton;
    private JButton registerButton;
    private JButton backButton;
    private JRadioButton adminRadioButton;

    public registrationPanel() {
        super(278, 292, "registration" );
        super.setMainPanel(mainPanel);
        System.out.println(">>creating a new raw registration panel");
    }
    public JButton getBackButton() {
        if (debug){
            System.out.println("getting back button(raw registration)");
        }
        return backButton;
    }
    public JButton getRegisterButton() {
        if (debug){
            System.out.println("getting register button(raw registration)");
        }
        return registerButton;
    }
    public JPasswordField getPasswordField1() {
        if (debug){
            System.out.println("getting password field(raw registration)");
        }
        return passwordField1;
    }
    public JTextField getTextField1() {
        if (debug){
            System.out.println("getting text field(raw registration)");
        }
        return nameField1;
    }
    public JTextField getTextField2() {
        if (debug){
            System.out.println("getting text field(raw registration)");
        }
        return idField2;
    }
    public JTextField getTextField3() {
        if (debug){
            System.out.println("getting text field(raw registration)");
        }
        return usernameField3;
    }
    public JPanel getMainPanel() {
        if (debug){
            System.out.println("getting main panel(raw registration)");
        }
        return mainPanel;
    }

}
