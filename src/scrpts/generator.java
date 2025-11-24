package scrpts;

import handling.dataHandler;
import obj.book;
import obj.client;

import java.util.Random;

public class generator {
    Random rand = new Random();
    dataHandler dataHandler ;
    public generator(dataHandler dataHandler){
        this.dataHandler=dataHandler;
    }
    public book bookGen(){
        return new book(1000+ dataHandler.bookCount,infoClass.bookTitles[rand.nextInt(infoClass.bookTitles.length)],
                infoClass.humanNames[rand.nextInt(infoClass.humanNames.length)],infoClass.bookGenres[rand.nextInt(infoClass.bookGenres.length)],
                rand.nextInt(1970,2025));
    }
    public client clientGen(){
        return new client(1000+ dataHandler.clientCount,
                infoClass.humanNames[rand.nextInt(infoClass.humanNames.length)],
                infoClass.humanNames[rand.nextInt(infoClass.humanNames.length)]+infoClass.humanNames[rand.nextInt(infoClass.humanNames.length)]+rand.nextInt(1,999)+"@gmail.com",
                (rand.nextInt(10,25)*10000)+(rand.nextInt(1,30)*100)+ rand.nextInt(1,30)
                );
    }
}
