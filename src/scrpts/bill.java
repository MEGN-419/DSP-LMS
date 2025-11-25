package scrpts;

import java.util.ArrayList;

public class bill {
    int memID;
    //t = total
    double tFines;
    ArrayList<String> payHis;
    public bill(int ID){
        memID = ID;
        tFines=0.0;
    }
    public boolean getPayStat(){
        return tFines == 0;
    }
}
