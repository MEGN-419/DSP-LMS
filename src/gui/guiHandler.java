package gui;

import gui.rawPanels.*;
import handling.dataHandler;
import obj.book;
import obj.client;

public class guiHandler {
    public static baseFrame frame;
    public static client currentUser;

    public static void start() {
        // Start application window
        frame = new baseFrame("DSP-LMS", 800, 600);
        loadWelcome();
    }

    public static void loadWelcome() {
        frame.swapPanel(new welcomePanel());
    }

    public static void loadLogin() {
        frame.swapPanel(new loginPanel());
    }

    public static void loadRegistration() {
        frame.swapPanel(new registrationPanel());
    }

    public static void loadHome(client c) {
        currentUser = c;
        if(c.type.equals("admin")) {
            frame.swapPanel(new adminPanel());
        } else {
            frame.swapPanel(new userPanel());
        }
    }

    public static void loadBookDetails(book b) {
        frame.swapPanel(new bookDetailsPanel(b));
    }

    public static void loadQueueView() {
        frame.swapPanel(new queueViewPanel());
    }

    public static void loadClientProfile() {
        frame.swapPanel(new clientProfilePanel());
    }

    // --- THIS WAS MISSING ---
    public static void loadClientManager() {
        frame.swapPanel(new adminClientManagerPanel());
    }

    public static void loadSearchPanel() {
        frame.swapPanel(new searchPanel());
    }
}