package scrpts;

import obj.book;
import java.util.ArrayList;

public class bill {
    public int memID;
    // t = total
    public int tFines;
    public ArrayList<rec> payHis;

    public bill(int ID){
        memID = ID;
        tFines = 0;
        payHis = new ArrayList<>();
    }

    public boolean getPayStat(){
        return tFines == 0;
    }

    public void addFine(int val){
        tFines += val;
    }

    public class rec{
        public int date;
        public int total;
        public ArrayList<book> books;
        public String des;
    }
}