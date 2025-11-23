package scrpts;

import obj.book;
import obj.client;

public class borrow {
    int borrowID;
    book bb;
    client bc;
    int borrowD;
    int borrowR;
    boolean stat;
    public borrow(int borrowID ,book book , client client , int borrowD , int borrowR){
        this.borrowID=borrowID;
        bb = book;
        bc = client;
        this.borrowD=borrowD;
        this.borrowR=borrowR;
        stat = false;
    }
    public void statR(){
        stat = true;
    }
    public void renew(int newRD){
        borrowR = newRD;
    }
}
