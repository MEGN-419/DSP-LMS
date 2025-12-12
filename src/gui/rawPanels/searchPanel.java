package gui.rawPanels;

import gui.guiHandler;
import gui.panelSuper;
import handling.dataHandler;
import obj.book;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class searchPanel extends panelSuper {
    private JPanel listPanel;

    public searchPanel() {
        super(600, 500, "Advanced Search");

        JPanel mainLayout = new JPanel(new BorderLayout());

        // --- SEARCH HEADER ---
        JPanel top = new JPanel(new FlowLayout());

        JTextField searchF = new JTextField(15);
        String[] options = {"Title", "Author"};
        JComboBox<String> typeBox = new JComboBox<>(options);
        JButton btnSearch = new JButton("Search");
        JButton btnBack = new JButton("Back to Dashboard");

        btnBack.addActionListener(e -> guiHandler.loadHome(guiHandler.currentUser));

        btnSearch.addActionListener(e -> {
            String query = searchF.getText().toLowerCase().trim();
            String type = (String) typeBox.getSelectedItem();
            performSearch(query, type);
        });

        top.add(new JLabel("Search by:"));
        top.add(typeBox);
        top.add(searchF);
        top.add(btnSearch);
        top.add(btnBack);

        // --- RESULTS LIST ---
        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        // Initial empty state
        listPanel.add(new JLabel("Enter a term to search books by Title or Author."));

        mainLayout.add(top, BorderLayout.NORTH);
        mainLayout.add(new JScrollPane(listPanel), BorderLayout.CENTER);

        setMainPanel(mainLayout);
    }

    private void performSearch(String query, String type) {
        listPanel.removeAll();
        ArrayList<book> results = new ArrayList<>();

        // Linear Search for partial string matching
        for (book b : dataHandler.storage.allBooks) {
            if (type.equals("Title")) {
                if (b.title.toLowerCase().contains(query)) results.add(b);
            } else {
                if (b.author.toLowerCase().contains(query)) results.add(b);
            }
        }

        if (results.isEmpty()) {
            listPanel.add(new JLabel("No books found matching '" + query + "'"));
        } else {
            for (book b : results) {
                JPanel row = new JPanel(new BorderLayout());
                row.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
                row.setMaximumSize(new Dimension(580, 40));
                row.setPreferredSize(new Dimension(580, 40));

                String status = b.stat ? "[Available]" : "[Borrowed]";
                JLabel info = new JLabel(String.format(" %s by %s %s", b.title, b.author, status));
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
}