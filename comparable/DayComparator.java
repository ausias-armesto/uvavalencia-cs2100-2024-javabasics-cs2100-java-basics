package comparable;

public class DayComparator implements java.util.Comparator<SimpleDate> {

    @Override
    public int compare(SimpleDate date1, SimpleDate date2) {
        return date1.getDay() - date2.getDay();
    }
    
}
