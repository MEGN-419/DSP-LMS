package handling;

import gui.guiHandler;
import scrpts.generator;
import obj.book;
import java.util.Scanner;

public class boot {
    public static void main(String[] args) {
        System.out.println(">> System Booting...");

        dataHandler.quickStart();

        Scanner sc = new Scanner(System.in);
        generator gen = new generator();
        boolean running = true;

        while (running) {
            System.out.println("\n=================================");
            System.out.println("   LIBRARY MANAGEMENT CONSOLE    ");
            System.out.println("=================================");
            System.out.println("1) Generate Random Books");
            System.out.println("2) Generate Random Clients");
            System.out.println("3) Launch GUI Mode");
            System.out.println("4) View System Stats");
            System.out.println("5) Search Books (Console)");
            System.out.println("6) Exit");
            System.out.print("Select Option: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("How many books? ");
                        int bCount = sc.nextInt();
                        gen.generateBooks(bCount);
                        break;
                    case 2:
                        System.out.print("How many clients? ");
                        int cCount = sc.nextInt();
                        gen.generateClients(cCount);
                        break;
                    case 3:
                        System.out.println(">> Launching GUI...");
                        guiHandler.start();
                        break;
                    case 4:
                        System.out.println("--- Stats ---");
                        System.out.println("Total Books: " + dataHandler.bookCount);
                        System.out.println("Total Clients: " + dataHandler.storage.clients.size());
                        break;
                    case 5:
                        // CONSOLE SEARCH LOGIC
                        System.out.print("Enter partial ID, Title, or Author: ");
                        String q = sc.nextLine().toLowerCase();
                        boolean found = false;
                        System.out.println("--- Search Results ---");
                        for(book b : dataHandler.storage.allBooks) {
                            String idStr = String.valueOf(b.bookID);
                            if (idStr.contains(q) || b.title.toLowerCase().contains(q) || b.author.toLowerCase().contains(q)) {
                                System.out.println(b.toString());
                                found = true;
                            }
                        }
                        if(!found) System.out.println("No matches found.");
                        break;
                    case 6:
                        System.out.println("Exiting System.");
                        running = false;
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid input. " + e.getMessage());
                sc.nextLine();
            }
        }
    }
    /*
    data structures project on a library management system, done by :

Omar Abdalrheem Ali
24100424

Abdelrahman Mohamed Mostafa
24100419

Ebrahim Mohammed
24102707

Zeiad Ahmed
24102614

Mohamed Sherif
24100436

Marwan ehab galal nafie
24100449
     */
}