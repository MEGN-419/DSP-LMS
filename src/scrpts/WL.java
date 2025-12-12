package scrpts;

import obj.client;
import java.util.LinkedList;
import java.util.Queue;

public class WL {
    // Using LinkedList as Queue implementation
    Queue<client> memQ = new LinkedList<>();

    public void addMemTQ(client client){
        // Prevent duplicates
        if (!memQ.contains(client)) {
            memQ.add(client);
            System.out.println("Added " + client.name + " to waiting list.");
        }
    }

    public client pollMemFQ(){
        return memQ.poll();
    }

    public boolean isEmpty() {
        return memQ.isEmpty();
    }

    public String getQueueDetails() {
        if (memQ.isEmpty()) return " (Empty)";
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (client c : memQ) {
            sb.append(String.format("   %d. %s (ID: %d)\n", i++, c.name, c.memberId));
        }
        return sb.toString();
    }

    // NEW METHOD: Checks if a specific client is already in this queue
    public boolean contains(client c) {
        return memQ.contains(c);
    }
}