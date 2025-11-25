package handling;

import obj.book;

import java.util.ArrayList;
import java.util.HashMap;

public class dataHandler {
    public static int bookCount;
    public static int clientCount;
    public static boolean debug;
    public class storage{
        //btree with book ids
        node.BTS bookT = new node.BTS();
        //store genres and pubyear in hashmaps, could use liked list but array lists r easier for us tho
        HashMap<String , ArrayList<book>> genres = new HashMap<>();
        HashMap< Integer , ArrayList<book>> pubYear = new HashMap<>();
        public class node{
            int data;
            node left , right;
            public static class BTS{
                node root;
                //todo complete bts
            }
        }
    }
}
