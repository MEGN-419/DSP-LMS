package handling;

import java.util.HashMap;

public class dataHandler {
    public static int bookCount;
    public static int clientCount;
    public static boolean debug;
    public class storage{
        node.BTS bookT = new node.BTS();
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
