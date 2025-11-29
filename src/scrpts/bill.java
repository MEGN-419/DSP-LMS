package scrpts;

import obj.book;

import java.util.ArrayList;

public class bill {
    int memID;
    //t = total
    int tFines;
    ArrayList<rec> payHis;
    public bill(int ID){
        memID = ID;
        tFines=0;
    }
    public boolean getPayStat(){
        return tFines == 0;
    }
    public void addFine(int val){
        tFines+=val;
    }

    public class rec{
        int date ;
        int total;
        ArrayList<book> books;
        String des;
    }
}
