package gui.rawPanels;

import gui.guiHandler;
import gui.panelSuper;
import obj.book;
import scrpts.borrow;
import javax.swing.*;
import java.awt.*;

public class bookDetailsPanel extends panelSuper {

    public bookDetailsPanel(book b) {
        super(500, 400, "Book Details");

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Info Labels
        addLabel(p, "Book ID:", String.valueOf(b.bookID));
        addLabel(p, "Title:", b.title);
        addLabel(p, "Author:", b.author);
        addLabel(p, "Genre:", b.genre);
        addLabel(p, "Year:", String.valueOf(b.pubYear));
        addLabel(p, "Price:", b.price + " EGP");

        // Status & Action Panel
        JPanel actionPanel = new JPanel();
        JLabel statLabel = new JLabel();
        statLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JButton actionBtn = new JButton();

        // --- LOGIC CHECK ---
        if (guiHandler.currentUser.bbs.contains(b)) {
            // CASE 1: YOU HAVE THE BOOK -> RETURN IT
            statLabel.setText("You have this book");
            statLabel.setForeground(Color.BLUE.darker());

            actionBtn.setText("Return Book");
            actionBtn.addActionListener(e -> {
                borrow.processReturn(guiHandler.currentUser, b);
                JOptionPane.showMessageDialog(null, "Returned successfully!");
                guiHandler.loadHome(guiHandler.currentUser);
            });

        } else if (b.stat) {
            // CASE 2: AVAILABLE -> BORROW IT
            statLabel.setText("Available");
            statLabel.setForeground(Color.GREEN.darker());

            actionBtn.setText("Borrow Now");
            actionBtn.addActionListener(e -> {
                String result = borrow.issueBook(guiHandler.currentUser, b);
                JOptionPane.showMessageDialog(null, result);
                guiHandler.loadHome(guiHandler.currentUser);
            });

        } else {
            // CASE 3: UNAVAILABLE

            // FIX: Check if already in queue
            if (b.waitingList.contains(guiHandler.currentUser)) {
                statLabel.setText("Borrowed (You are in queue)");
                statLabel.setForeground(Color.ORANGE.darker());

                actionBtn.setText("Already in Queue");
                actionBtn.setEnabled(false); // Disable button
            } else {
                statLabel.setText("Borrowed");
                statLabel.setForeground(Color.RED);

                actionBtn.setText("Join Waiting List");
                actionBtn.addActionListener(e -> {
                    b.waitingList.addMemTQ(guiHandler.currentUser);
                    JOptionPane.showMessageDialog(null, "Added to queue! You will be notified when available.");
                    guiHandler.loadHome(guiHandler.currentUser);
                });
            }
        }

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(e -> guiHandler.loadHome(guiHandler.currentUser));

        actionPanel.add(statLabel);
        actionPanel.add(Box.createHorizontalStrut(20));
        actionPanel.add(actionBtn);

        p.add(Box.createVerticalStrut(20));
        p.add(actionPanel);
        p.add(Box.createVerticalStrut(30));
        p.add(btnBack);

        setMainPanel(p);
    }

    private void addLabel(JPanel p, String title, String value) {
        JLabel l = new JLabel(title + " " + value);
        l.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(l);
        p.add(Box.createVerticalStrut(5));
    }
}