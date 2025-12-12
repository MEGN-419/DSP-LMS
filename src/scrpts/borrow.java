package scrpts;

import handling.dataHandler;
import obj.book;
import obj.client;

public class borrow {
    public static String issueBook(client c, book b) {
        if (b.stat) {
            b.stat = false;
            c.addBook(b);
            return "Success: You borrowed " + b.title;
        }
        return "Error: Book unavailable.";
    }

    // Static method to handle returns and notifications
    public static void processReturn(client c, book b) {
        c.bbs.remove(b);
        b.stat = true; // Book is available again

        // Check Queue
        if (!b.waitingList.isEmpty()) {
            client nextClient = b.waitingList.pollMemFQ();
            if (nextClient != null) {
                String msg = "Good news! The book '" + b.title + "' is now available.";
                nextClient.notifications.add(msg);
                System.out.println(">> Notification sent to " + nextClient.name);
            }
        }
    }
}