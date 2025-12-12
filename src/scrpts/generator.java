package scrpts;

import handling.dataHandler;
import obj.book;
import obj.client;
import java.util.Random;

public class generator {
    private Random rand = new Random();

    // Generate a specific number of random books
    public void generateBooks(int count) {
        System.out.println(">> Generating " + count + " random books...");
        for (int i = 0; i < count; i++) {
            int id = rand.nextInt(10000, 99999);

            // Ensure unique ID
            while (checkBookIdExists(id)) {
                id = rand.nextInt(10000, 99999);
            }

            String title = infoClass.bookTitles[rand.nextInt(infoClass.bookTitles.length)];
            String author = infoClass.humanNames[rand.nextInt(infoClass.humanNames.length)];
            String genre = infoClass.bookGenres[rand.nextInt(infoClass.bookGenres.length)];
            int year = rand.nextInt(1970, 2025);
            int price = rand.nextInt(15, 60) * 5;

            book newBook = new book(id, title, author, genre, year, price);
            dataHandler.addBook(newBook);
        }
        System.out.println(">> " + count + " books added to Library.");
    }

    // Generate a specific number of random clients
    public void generateClients(int count) {
        System.out.println(">> Generating " + count + " random clients...");
        for (int i = 0; i < count; i++) {
            int id = 2000 + dataHandler.clientCount + i; // Simple ID generation
            String firstName = infoClass.humanNames[rand.nextInt(infoClass.humanNames.length)];
            String lastName = infoClass.humanNames[rand.nextInt(infoClass.humanNames.length)];
            String name = firstName + " " + lastName;
            String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@gmail.com";
            String password = "pass" + rand.nextInt(1000);

            // Randomly assign admin or user, mostly user
            String type = (rand.nextInt(10) > 8) ? "admin" : "user";

            client newClient = new client(id, name, email, password, type);
            dataHandler.storage.clients.add(newClient);
        }
        System.out.println(">> " + count + " clients registered.");
    }

    // Helper to check if ID exists in the static list
    private boolean checkBookIdExists(int id) {
        for (book b : dataHandler.storage.allBooks) {
            if (b.bookID == id) return true;
        }
        return false;
    }
}