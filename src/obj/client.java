package obj;

import handling.dataHandler;

import java.util.ArrayList;

public class client {
    final int memberId;
    final String name;
    String email;
    final int memDate;
    //bbs = borrowed books
    ArrayList<book> bbs = new ArrayList<>();
    public client(int memberId , String name , String email , int memDate){
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.memDate = memDate;
        dataHandler.clientCount++;
    }
    public void updateCon(String email){
        this.email=email;
    }
    public void addBook(book book){
        bbs.add(book);
    }
    public ArrayList<book> veiwbbs(){
        return bbs;
    }
}
