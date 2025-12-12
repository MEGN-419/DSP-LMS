package gui.rawPanels;

import gui.guiHandler;
import gui.panelSuper;
import handling.dataHandler;
import obj.book;
import javax.swing.*;
import java.awt.*;

public class queueViewPanel extends panelSuper {
    public queueViewPanel() {
        super(600, 500, "Queue Viewer");

        JPanel p = new JPanel(new BorderLayout());

        // Header
        JPanel top = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnBack = new JButton("Back to Dashboard");
        btnBack.addActionListener(e -> guiHandler.loadHome(guiHandler.currentUser));
        top.add(new JLabel("<html><h2>Books with Active Waiting Lists</h2></html>"));
        top.add(btnBack);

        // Content
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        boolean empty = true;
        for (book b : dataHandler.storage.allBooks) {
            // Only show books that have people waiting
            if (!b.waitingList.isEmpty()) {
                empty = false;
                JPanel row = new JPanel(new BorderLayout());
                row.setBorder(BorderFactory.createTitledBorder(b.title + " (ID: " + b.bookID + ")"));

                // FIX: This calls the method we added to WL.java to get the names
                JTextArea qInfo = new JTextArea(b.waitingList.getQueueDetails());
                qInfo.setEditable(false);
                qInfo.setOpaque(false); // Make it blend in
                qInfo.setFont(new Font("Monospaced", Font.PLAIN, 12));
                qInfo.setMargin(new Insets(5, 10, 5, 10));

                row.add(qInfo, BorderLayout.CENTER);
                content.add(row);
                content.add(Box.createVerticalStrut(10));
            }
        }

        if (empty) {
            JLabel emptyLbl = new JLabel("No active queues at the moment.");
            emptyLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
            content.add(Box.createVerticalStrut(20));
            content.add(emptyLbl);
        }

        p.add(top, BorderLayout.NORTH);
        p.add(new JScrollPane(content), BorderLayout.CENTER);

        setMainPanel(p);
    }
}