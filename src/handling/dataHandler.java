package handling;

import obj.book;
import scrpts.WL;
import scrpts.ds.BTS;

import java.util.ArrayList;
import java.util.HashMap;

public class dataHandler {
    public static int bookCount;
    public static int clientCount;
    public static boolean debug;
    public boolean idChecker(storage csi , int id){
        //csi = current storage instance;
        for(int i = 0 ; i < csi.aba.size() ; i++){
            if (id == Integer.parseInt(csi.aba.get(i).getInfo("bookID"))) return true;
        }
        return false;
    }
    //todo create ques on instance creation for all books
    public class storage{
        //aba = all books available, use if really needed, otherwise, all books created should be added here.
        ArrayList<book> aba = new ArrayList<>();

        //btree with book ids
        BTS bookT = new BTS();
        //store genres and pubyear in hashmaps, could use liked list but array lists r easier for us tho
        HashMap<String , ArrayList<book>> genres = new HashMap<>();
        HashMap<Integer , ArrayList<book>> pubYear = new HashMap<>();
        //qii = queues in instance
        HashMap<book , WL> qii = new HashMap<>();
    }
}
