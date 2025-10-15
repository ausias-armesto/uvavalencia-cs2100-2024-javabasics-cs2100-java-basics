package comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Simple Date
        SimpleDate simpleDate = new SimpleDate(03, 01,2020);

        
        List<SimpleDate> list = new ArrayList<SimpleDate>();
        list.add(new SimpleDate(01, 02, 2020));
        list.add(simpleDate);
        list.add(new SimpleDate(02, 12, 2020));

        List<SimpleDate> list2 = new ArrayList<SimpleDate>();
        Collections.addAll(list2, simpleDate, SimpleDate.FINAL_EXAM);
        
        System.out.println("Unsorted list: " + list);
        System.out.println("Index of simpleDate in unsorted list: " + Collections.binarySearch(list,simpleDate));
        Collections.sort(list);
        System.out.println("Sorted list: " + list);
        System.out.println("Index of simpleDate in sorted list: " + Collections.binarySearch(list,simpleDate ));
        System.out.println("Index of SimpleDate.FINAL_EXAM in list: " + Collections.binarySearch(list,SimpleDate.FINAL_EXAM ));

        Collections.sort(list, new DayComparator());
        System.out.println("Sorted list by day: " + list);
    }
    
}
