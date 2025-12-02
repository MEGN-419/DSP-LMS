package scrpts;

import handling.dataHandler;
import obj.book;
import obj.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class borrow {
    //todo store borrow recs in data handler , same as storing books , different vals
    //bb = borrowed book
    //bc = borrowing client
    //d = date
    //r = return
    int borrowID;
    book bb;
    client bc;
    int borrowD;
    int borrowR;
    boolean stat;
    public borrow(int borrowID ,book book , client client , int borrowD , int borrowR) throws ParseException {
        this.borrowID=borrowID;
        bb = book;
        bc = client;
        this.borrowD=borrowD;
        this.borrowR=borrowR;
        stat = false;
        if(dataHandler.debug){
            System.out.println("created a borrow request with info : \n request ID : "+borrowID+"date borrowed : "+dataHandler.Dform(borrowD)+"\nreturn date : "+dataHandler.Dform(borrowR)+
                    "\nbook details : \nbook name"+book.getInfo("title")+"\nbook ID : "+book.getInfo("bookID")+
                    "\nclient info : \nclient name : "+client.getInfo("name")+"\nclient ID : "+client.getInfo("id"));
        }
    }
    public void statR(){
        stat = true;
    }
    public void renew(int newRD){
        borrowR = newRD;
    }
}
