package obj;
import handling.dataHandler;
public class book {
    int bookID;
    String title;
    String author;
    String genre;
    int pubYear;
    boolean stat;
    int price ;
    public book(int bookID, String title , String author , String genre , int pubYear , int price){
        this.bookID=bookID;
        this.title=title;
        this.author=author;
        this.genre=genre;
        this.pubYear=pubYear;
        stat = true;
        this.price=price;
        dataHandler.bookCount++;
        if(dataHandler.debug){
            System.out.println("created book with data :\nbookID : "+bookID+"\ntitle : "+title+"\n genre : "+genre+"\npublication year : "+pubYear);
        }
    }
    //input option to either get or update, no need for multi methods, case-sensitive tho the use of switch
    public void updateInfo(String option , String data){
        switch(option){
            case "bookID":
                bookID = Integer.parseInt(data);
            break;
            case"title":
                title = data;
            break;
            case"author":
                author = data;
            break;
            case "genre":
                genre = data;
            break;
            case"pubYear":
                pubYear = Integer.parseInt(data);
            break;
            case"price":
                price= Integer.parseInt(data);
            default:
                if(dataHandler.debug) System.out.println("wrong option entered");
            break;
        }
    }
    public String getInfo(String option){
        return switch (option) {
            case "bookID" -> String.valueOf(bookID);
            case "title" -> title;
            case "author" -> author;
            case "genre" -> genre;
            case "pubYear" -> String.valueOf(pubYear);
            case "price" -> String.valueOf(price);
            default -> {
                if (dataHandler.debug) System.out.println("wrong option entered");
                yield null;
            }
        };
    }
}
