package gui.rawPanels;

import gui.guiHandler;
import gui.panelSuper;
import handling.dataHandler;
import handling.reportGenerator;
import obj.book;
import scrpts.borrow;
import javax.swing.*;
import java.awt.*;

public class homePanel extends panelSuper {

    public homePanel() {
        super(800, 600, "Home Dashboard");

        // Check notifications on load
        checkUserNotifications();

        JPanel mainLayout = new JPanel(new BorderLayout());

        // --- TOP HEADER (User Info & Stats) ---
        JPanel header = new JPanel(new GridLayout(2, 1));
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));

        JPanel userInfo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        userInfo.add(new JLabel("User: " + guiHandler.currentUser.name + " (" + guiHandler.currentUser.type + ")"));
        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(e -> guiHandler.loadWelcome());
        userInfo.add(btnLogout);

        JPanel statsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        JLabel lblBooks = new JLabel("Total Books: " + dataHandler.bookCount);
        JLabel lblClients = new JLabel("Total Clients: " + dataHandler.storage.clients.size());
        lblBooks.setFont(new Font("Arial", Font.BOLD, 14));
        lblClients.setFont(new Font("Arial", Font.BOLD, 14));
        statsPanel.add(lblBooks);
        statsPanel.add(lblClients);

        header.add(userInfo);
        header.add(statsPanel);

        // --- CENTER CONTENT (Based on Type) ---
        // We use JComponent here because it is the parent of both JPanel and JScrollPane
        JComponent content;

        if (guiHandler.currentUser.type.equals("admin")) {
            content = buildAdminContent();
        } else {
            content = buildUserContent();
        }

        mainLayout.add(header, BorderLayout.NORTH);
        mainLayout.add(content, BorderLayout.CENTER);

        setMainPanel(mainLayout);
    }

    // --- ADMIN VIEW ---
    private JPanel buildAdminContent() {
        JPanel p = new JPanel(new FlowLayout());

        JButton btnAddBook = new JButton("Add New Book");
        JButton btnReports = new JButton("Generate Reports");
        JButton btnQueues = new JButton("View Waiting Queues");
        Dimension btnDimension = new Dimension(200, 50);

        btnAddBook.setPreferredSize(btnDimension);
        btnReports.setPreferredSize(btnDimension);
        btnQueues.setPreferredSize(btnDimension);

        btnAddBook.addActionListener(e -> {
            String title = JOptionPane.showInputDialog("Book Title:");
            String author = JOptionPane.showInputDialog("Author:");
            String genre = JOptionPane.showInputDialog("Genre:");
            if (title != null) {
                int id = 1000 + dataHandler.bookCount;
                book b = new book(id, title, author, genre, 2025, 50);
                dataHandler.addBook(b);
                JOptionPane.showMessageDialog(null, "Book Added!");
                guiHandler.loadHome(guiHandler.currentUser); // Refresh stats
            }
        });

        btnReports.addActionListener(e -> {
            String rep = reportGenerator.generateReport(dataHandler.storage.allBooks);
            JTextArea ta = new JTextArea(rep, 20, 40);
            JOptionPane.showMessageDialog(null, new JScrollPane(ta));
        });

        btnQueues.addActionListener(e -> guiHandler.loadQueueView());

        p.add(btnAddBook);
        p.add(btnReports);
        p.add(btnQueues);
        return p;
    }

    private JPanel buildUserContent() {
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        for (book b : dataHandler.storage.allBooks) {
            JPanel row = new JPanel(new BorderLayout());
            row.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY),
                    BorderFactory.createEmptyBorder(5, 5, 5, 5)));
            row.setMaximumSize(new Dimension(750, 50));

            String status = b.stat ? "[Available]" : "[Borrowed]";
            JLabel info = new JLabel(String.format("ID: %d | %s - %s %s", b.bookID, b.title, b.author, status));
            if (!b.stat) info.setForeground(Color.RED);

            JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton btnView = new JButton("View Details");
            JButton btnAction = new JButton(b.stat ? "Borrow" : "Join Queue");

            btnView.addActionListener(e -> guiHandler.loadBookDetails(b));

            btnAction.addActionListener(e -> {
                if (b.stat) {
                    String res = borrow.issueBook(guiHandler.currentUser, b);
                    JOptionPane.showMessageDialog(null, res);
                } else {
                    b.waitingList.addMemTQ(guiHandler.currentUser);
                    JOptionPane.showMessageDialog(null, "Added to waiting list for: " + b.title);
                }
                guiHandler.loadHome(guiHandler.currentUser); // Refresh
            });

            btnPanel.add(btnView);
            btnPanel.add(btnAction);

            row.add(info, BorderLayout.CENTER);
            row.add(btnPanel, BorderLayout.EAST);
            listPanel.add(row);
        }

        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.add(new JScrollPane(listPanel), BorderLayout.CENTER);
        return wrapper;
    }

    private void checkUserNotifications() {
        if (!guiHandler.currentUser.notifications.isEmpty()) {
            StringBuilder sb = new StringBuilder("You have new notifications:\n");
            for (String n : guiHandler.currentUser.notifications) {
                sb.append("- ").append(n).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
            guiHandler.currentUser.notifications.clear();
        }
    }
}