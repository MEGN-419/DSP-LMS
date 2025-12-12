package gui;

import javax.swing.*;

public abstract class panelSuper {
    private JPanel mainPanel;
    private int width;
    private int height;
    private String type;
    public static boolean debug = false;

    public panelSuper(int width, int height, String type) {
        this.width = width;
        this.height = height;
        this.type = type;
        this.mainPanel = new JPanel(); // Init mainPanel
    }

    public JPanel getMainPanel() { return mainPanel; }
    public void setMainPanel(JPanel mainPanel) { this.mainPanel = mainPanel; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public String getType() { return type; }
}