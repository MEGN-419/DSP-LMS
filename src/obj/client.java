package obj;

import handling.dataHandler;
import scrpts.bill;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class client {
    //ill just add a whole bill object here just to save time...
    bill cbill ;
    final int memberId;
    final String name;
    String email;
    final int memDate;
    //bbs = borrowed books
    ArrayList<book> bbs = new ArrayList<>();
    public client(int memberId , String name , String email , int memDate) throws ParseException {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.memDate = memDate;
        dataHandler.clientCount++;
        cbill = new bill(memberId);
        if(dataHandler.debug){
            System.out.println("created a client with data : \nClient ID : "+dataHandler.Dform(memDate));
        }
    }
    public void updateCon(String email){
        this.email=email;
    }
    public void addBook(book book){
        bbs.add(book);
        cbill.addFine(book.price);
    }
    public ArrayList<book> veiwbbs(){
        return bbs;
    }
    //seems pointless but trust me It's for gui, f gui...
    public bill getCbill(){
        return cbill;
    }
    public String getInfo(String info){
        return switch (info){
            case"name"-> name;
            case"Id"->String.valueOf(memberId);
            case"email"->email;
            default -> {
                if (dataHandler.debug) System.out.println("wrong option");
                yield null;

            }
        };
    }
}
