package gui;

import javax.swing.*;

public abstract class panelSuper {
    //same stuff as base frame
    //and for anyone still wondering, this is the contents (graphics) that is shown on the base frame
    private JPanel mainPanel;
    private int width;
    private int height;
    private String type;
    public static boolean debug = false;
    public panelSuper(int width, int height, String type) {
        this.width = width;
        this.height = height;
        this.type = type;
    }
    public int getWidth() {
        if (debug){
            System.out.println("getting width of panel(PanelSuper)");
        }
        return width;
    }
    public int getHeight() {
        if (debug){
            System.out.println("getting height of panel(PanelSuper)");
        }
        return height;
    }
    public JPanel getMainPanel() {
        if (debug){
            System.out.println("getting main panel(PanelSuper)");
        }
        return mainPanel;
    }
    public void setMainPanel(JPanel mainPanel) {
        if(debug){
            System.out.println("setting main panel(PanelSuper)");
        }
        this.mainPanel = mainPanel;
    }
    public void setWidth(int width) {
        if (debug){
            System.out.println("setting width of panel(PanelSuper)");
        }
        this.width = width;
    }
    public void setHeight(int height) {
        if (debug){
            System.out.println("setting height of panel(PanelSuper)");
        }
        this.height = height;
    }
    public String getType() {
        if (debug){
            System.out.println("getting type of panel(PanelSuper)");
        }
        return type;
    }
    public static void debug(boolean state) {
        if (debug){
            System.out.println("setting debug mode to " + state + " (PanelSuper)");
        }
        debug = state;
        if (state){
            System.out.println("debug mode enabled(PanelSuper)");
        }
        else{
            System.out.println("debug mode disabled(PanelSuper)");
        }
    }
}
