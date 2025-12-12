package gui.rawPanels;

import gui.guiHandler;
import gui.panelSuper;
import handling.dataHandler;
import obj.book;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class userPanel extends panelSuper {
    private JPanel listPanel;

    public userPanel() {
        super(600, 500, "User Dashboard");

        checkNotifications();

        JPanel mainLayout = new JPanel(new BorderLayout());

        // --- TOP AREA ---
        JPanel topContainer = new JPanel();
        topContainer.setLayout(new BoxLayout(topContainer, BoxLayout.Y_AXIS));

        // Row 1: Controls
        JPanel userBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnLogout = new JButton("Logout");
        JButton btnProfile = new JButton("My Profile");

        btnLogout.addActionListener(e -> guiHandler.loadWelcome());
        btnProfile.addActionListener(e -> guiHandler.loadClientProfile());

        userBar.add(btnLogout);
        userBar.add(btnProfile);
        userBar.add(new JLabel("  Welcome " + guiHandler.currentUser.name));

        // Row 2: Search Bar
        JPanel searchBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField searchField = new JTextField(10);
        JButton btnSearchID = new JButton("Search ID");
        JButton btnReset = new JButton("Show All");
        JButton btnAdvSearch = new JButton("Search Title/Author"); // NEW BUTTON

        btnSearchID.addActionListener(e -> performIDSearch(searchField.getText()));
        btnReset.addActionListener(e -> refreshList(dataHandler.storage.allBooks));

        // Open the new Search Panel
        btnAdvSearch.addActionListener(e -> guiHandler.loadSearchPanel());

        searchBar.add(new JLabel(" ID:"));
        searchBar.add(searchField);
        searchBar.add(btnSearchID);
        searchBar.add(btnReset);
        searchBar.add(Box.createHorizontalStrut(20)); // Spacer
        searchBar.add(btnAdvSearch); // Add button here

        topContainer.add(userBar);
        topContainer.add(searchBar);

        // --- LIST AREA ---
        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        refreshList(dataHandler.storage.allBooks);

        JScrollPane scrollPane = new JScrollPane(listPanel);

        mainLayout.add(topContainer, BorderLayout.NORTH);
        mainLayout.add(scrollPane, BorderLayout.CENTER);

        setMainPanel(mainLayout);
    }

    private void performIDSearch(String query) {
        if (query.isEmpty()) {
            refreshList(dataHandler.storage.allBooks);
            return;
        }
        try {
            int id = Integer.parseInt(query.trim());
            book found = dataHandler.storage.bookTree.search(id);
            ArrayList<book> result = new ArrayList<>();
            if (found != null) result.add(found);
            refreshList(result);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a numeric ID.");
        }
    }

    private void refreshList(ArrayList<book> booksToShow) {
        listPanel.removeAll();
        if (booksToShow.isEmpty()) {
            listPanel.add(new JLabel("No books found."));
        } else {
            for (book b : booksToShow) {
                JPanel row = new JPanel(new BorderLayout());
                row.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
                row.setMaximumSize(new Dimension(580, 40));
                row.setPreferredSize(new Dimension(580, 40));

                String status = b.stat ? "[Available]" : "[Borrowed]";
                JLabel info = new JLabel(String.format(" [ID: %d] %s", b.bookID, b.title));
                if (!b.stat) info.setForeground(Color.RED);

                JButton btnView = new JButton("View");
                btnView.addActionListener(e -> guiHandler.loadBookDetails(b));

                row.add(info, BorderLayout.CENTER);
                row.add(btnView, BorderLayout.EAST);
                listPanel.add(row);
            }
        }
        listPanel.revalidate();
        listPanel.repaint();
    }

    private void checkNotifications() {
        if (!guiHandler.currentUser.notifications.isEmpty()) {
            StringBuilder msg = new StringBuilder("New Notifications:\n");
            for (String s : guiHandler.currentUser.notifications) {
                msg.append("- ").append(s).append("\n");
            }
            JOptionPane.showMessageDialog(null, msg.toString());
            guiHandler.currentUser.notifications.clear();
        }
    }
}