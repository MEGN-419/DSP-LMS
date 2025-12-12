package obj;

import handling.dataHandler;
import scrpts.bill;
import java.util.ArrayList;

public class client {
    public bill cbill;
    public final int memberId;
    public  String name;
    public String email;
    public String password;
    public String type;
    public ArrayList<book> bbs = new ArrayList<>();
    public ArrayList<String> notifications = new ArrayList<>(); // NEW: Notification system

    public client(int memberId, String name, String email, String password, String type) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
        this.cbill = new bill(memberId);
    }

    public void addBook(book book){
        bbs.add(book);
        cbill.addFine(book.price);
    }
}