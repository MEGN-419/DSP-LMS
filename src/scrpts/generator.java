package scrpts;

import handling.dataHandler;
import obj.book;
import obj.client;

import java.text.ParseException;
import java.util.Random;

public class generator {
    //todo add borrowing report gen
    Random rand = new Random();
    dataHandler dataHandler ;
    public generator(dataHandler dataHandler){
        this.dataHandler=dataHandler;
    }
    //keep book and client counts as static, or make it a normal int to use multiple instance of data handlers without interference , maybe like for updating while main sys is active ?
    public book bookGen(dataHandler.storage csi){
        int ID= 0;
         for (int i = 0 ; i < handling.dataHandler.bookCount ; i++){
          ID = rand.nextInt(10000 , 99999);
          if(!(dataHandler.idChecker(csi , ID))){
              return new book(ID,infoClass.bookTitles[rand.nextInt(infoClass.bookTitles.length)],
                      infoClass.humanNames[rand.nextInt(infoClass.humanNames.length)],infoClass.bookGenres[rand.nextInt(infoClass.bookGenres.length)],
                      rand.nextInt(1970,2025), (rand.nextInt(15 , 60))*5);
          }
        }
         throw new RuntimeException("storage is full , no id slot is available , start a new storage instance");
    }
    public client clientGen() throws ParseException {
        return new client(1000+ handling.dataHandler.clientCount,
                infoClass.humanNames[rand.nextInt(infoClass.humanNames.length)],
                infoClass.humanNames[rand.nextInt(infoClass.humanNames.length)]+infoClass.humanNames[rand.nextInt(infoClass.humanNames.length)]+rand.nextInt(1,999)+"@gmail.com",
                (rand.nextInt(10,25)*10000)+(rand.nextInt(1,30)*100)+ rand.nextInt(1,30)
                );
    }
}
