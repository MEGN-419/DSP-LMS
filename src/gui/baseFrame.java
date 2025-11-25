package gui;

import scripts.handler;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class baseFrame {
    //for any one whos wondering , this is the actual window of the app
    //copied from other other project i did , to save more time
    //todo IGNORE , a lot of work leave till last , integrate it to the guihandler and datahandler , set the debug conditions
    private JFrame frame;
    public baseFrame() {
        System.out.println(">>created a new basic base frame (baseFrame)");
        frame = new JFrame();
        frame.setTitle("baseFrame");
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
    public baseFrame(String title, int width, int height, boolean resizable, boolean closable, boolean visible) {
        System.out.println(">>created a new basic base frame with custom settings : "+" "+title+" "+width+" "+height+" "+resizable+" "+closable+" "+visible+"(baseFrame)");
        frame = new JFrame();
        frame.setTitle(title);
        frame.setSize(width,height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(resizable);
        frame.setVisible(visible);
    }
    public baseFrame(String title, int width, int height) {
        System.out.println(">>created a new basic base frame with custom settings : "+" "+title+" "+width+" "+height+"(baseFrame)");
        frame = new JFrame();
        frame.setTitle(title);
        frame.setSize(width,height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
    public JFrame getFrame() {
        if (handler.debug){
            System.out.println("getting base frame(baseFrame)");
        }
        return frame;
    }
    public void setSize(int width,int height){
        if (handler.debug){
            System.out.println("setting base frame size(baseFrame)");
        }
        frame.setSize(width,height);
    }
    public void swapPanel(JPanel panel){
        if (handler.debug){
            System.out.println("swapping panel in base frame(baseFrame)");
        }
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.revalidate();
        frame.repaint();
    }
    public void dispose(){
        System.out.println("disposing base frame(baseFrame)");
        frame.dispose();
    }
}
