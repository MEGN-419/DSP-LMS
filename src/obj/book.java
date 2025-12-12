package obj;

import handling.dataHandler;
import scrpts.WL;

public class book {
    public int bookID;
    public String title;
    public String author;
    public String genre;
    public int pubYear;
    public boolean stat; // true = available
    public int price;
    public WL waitingList; // NEW: Each book has its own queue

    public book(int bookID, String title, String author, String genre, int pubYear, int price){
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pubYear = pubYear;
        this.stat = true;
        this.price = price;
        this.waitingList = new WL(); // Initialize queue

        if(dataHandler.debug){
            System.out.println("Created book: " + title);
        }
    }

    @Override
    public String toString() {
        return "[" + bookID + "] " + title + " (" + pubYear + ") - " + (stat ? "Available" : "Borrowed");
    }
}