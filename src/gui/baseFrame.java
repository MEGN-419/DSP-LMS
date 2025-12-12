package gui;

import handling.dataHandler;
import javax.swing.*;

public class baseFrame {
    private JFrame frame;

    public baseFrame(String title, int width, int height) {
        if(dataHandler.debug) System.out.println(">> Creating baseFrame: " + title);
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public void swapPanel(panelSuper panel) {
        if(dataHandler.debug) System.out.println(">> Swapping to: " + panel.getType());
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel.getMainPanel());
        frame.setTitle(panel.getType());
        frame.setSize(panel.getWidth(), panel.getHeight());
        frame.revalidate();
        frame.repaint();
    }

    public void setVisible(boolean b) { frame.setVisible(b); }
}