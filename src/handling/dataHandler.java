package handling;

import obj.book;

import java.util.ArrayList;
import java.util.HashMap;

public class dataHandler {
    public static int bookCount;
    public static int clientCount;
    public static boolean debug;
    public class storage{
        node.BTS bookT = new node.BTS();
        HashMap<String , ArrayList<book>> genres = new HashMap<>();
        HashMap< Integer , ArrayList<book>> pubYear = new HashMap<>();






        //TODO create genre and pubYear maps , continue bts
        public class node{
            int data;
            node left , right;
            public static class BTS{
                node root;
            }
        }
    }
}
