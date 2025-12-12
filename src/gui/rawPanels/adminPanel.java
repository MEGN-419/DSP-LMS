package gui.rawPanels;

import gui.guiHandler;
import gui.panelSuper;
import handling.dataHandler;
import handling.reportGenerator;
import obj.book;
import javax.swing.*;
import java.awt.*;

public class adminPanel extends panelSuper {
    public adminPanel() {
        super(600, 500, "Admin Dashboard");

        // Use a FlowLayout for a simple button list, centered
        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));

        // 1. Declare all buttons
        JButton btnAdd = new JButton("Add Book");
        JButton btnReport = new JButton("View Reports");
        JButton btnQueues = new JButton("View Waiting Lists");
        JButton btnClients = new JButton("Manage Clients");
        JButton btnLogout = new JButton("Logout");

        // 2. Set Button Actions

        // Add Book Action
        btnAdd.addActionListener(e -> {
            String title = JOptionPane.showInputDialog("Book Title:");
            String author = JOptionPane.showInputDialog("Author:");
            String genre = JOptionPane.showInputDialog("Genre:");
            if (title != null && author != null) {
                int id = 1000 + dataHandler.bookCount;
                dataHandler.addBook(new book(id, title, author, "Gen", 2025, 20));
                JOptionPane.showMessageDialog(null, "Book Added!");
            }
        });

        // View Reports Action
        btnReport.addActionListener(e -> {
            String rep = reportGenerator.generateReport(dataHandler.storage.allBooks);
            JTextArea ta = new JTextArea(rep, 20, 40);
            JOptionPane.showMessageDialog(null, new JScrollPane(ta));
        });

        // View Queues Action
        btnQueues.addActionListener(e -> {
            guiHandler.loadQueueView();
        });

        // Manage Clients Action
        btnClients.addActionListener(e -> {
            guiHandler.loadClientManager();
        });

        // Logout Action
        btnLogout.addActionListener(e -> guiHandler.loadLogin());

        // 3. Add buttons to panel (Order matters)
        p.add(new JLabel("Admin Controls:"));
        p.add(btnAdd);      // Fixed variable name here
        p.add(btnReport);
        p.add(btnQueues);
        p.add(btnClients);
        p.add(btnLogout);

        setMainPanel(p);
    }
}