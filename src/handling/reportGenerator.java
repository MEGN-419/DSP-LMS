package handling;

import obj.book;
import java.util.ArrayList;

public class reportGenerator {

    // Merge Sort Implementation
    public static void mergeSort(ArrayList<book> list) {
        if (list.size() <= 1) return;

        int mid = list.size() / 2;
        ArrayList<book> left = new ArrayList<>();
        ArrayList<book> right = new ArrayList<>();

        for(int i=0; i<mid; i++) left.add(list.get(i));
        for(int i=mid; i<list.size(); i++) right.add(list.get(i));

        mergeSort(left);
        mergeSort(right);
        merge(list, left, right);
    }

    private static void merge(ArrayList<book> result, ArrayList<book> left, ArrayList<book> right) {
        int i=0, j=0, k=0;
        while(i < left.size() && j < right.size()) {
            // Sort by Publication Year (descending)
            if(left.get(i).pubYear > right.get(j).pubYear) {
                result.set(k++, left.get(i++));
            } else {
                result.set(k++, right.get(j++));
            }
        }
        while(i < left.size()) result.set(k++, left.get(i++));
        while(j < right.size()) result.set(k++, right.get(j++));
    }

    public static String generateReport(ArrayList<book> books) {
        mergeSort(books); // Sort first
        StringBuilder sb = new StringBuilder();
        sb.append("--- LIBRARY REPORT (Sorted by Year) ---\n");
        for (book b : books) {
            sb.append(b.toString()).append("\n");
        }
        return sb.toString();
    }
}