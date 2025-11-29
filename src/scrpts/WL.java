package scrpts;

import obj.book;
import obj.client;

import java.util.Queue;

public class WL {
    Queue<client> memQ ;
    //biq = book in queue;
    book biq;
    public WL(book book){
        biq=book;
    }
    public void addMemTQ(client client){
        memQ.add(client);
    }
    public client pollMemFQ(){
        return memQ.poll();
    }
    //todo add meth to add clent to queue , and inform when book is in turn for said client
}
