package handling;

import obj.book;
import obj.client;
import scrpts.ds.BTS;
import scrpts.generator; // Import the generator
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class dataHandler {
    public static int bookCount = 0;
    public static int clientCount = 0;
    public static boolean debug = true;

    public static class storage {
        public static ArrayList<book> allBooks = new ArrayList<>();
        public static BTS bookTree = new BTS();
        public static ArrayList<client> clients = new ArrayList<>();
    }

    public static void init() {
        try {
            // 1. Add Admin & User
            storage.clients.add(new client(0, "Admin", "admin@aiu.edu", "admin123", "admin"));
            storage.clients.add(new client(1, "Student", "student@aiu.edu", "1234", "user"));

            // 2. Generate 3 Random Books using your generator class
            System.out.println(">> Generating 3 random books...");
            generator gen = new generator();
            gen.generateBooks(3);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addBook(book b) {
        storage.allBooks.add(b);
        storage.bookTree.insert(b);
        bookCount++;
    }

    public static client login(String name, String pass) {
        for(client c : storage.clients) {
            if(c.name.equals(name) && c.password.equals(pass)) {
                return c;
            }
        }
        return null;
    }

    public static Date Dform(int intDate) throws ParseException {
        return new SimpleDateFormat("yy/MM/dd").parse(String.valueOf(intDate));
    }
}