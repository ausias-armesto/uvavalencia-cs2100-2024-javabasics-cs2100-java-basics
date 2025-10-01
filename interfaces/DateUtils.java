package interfaces;

/*
    This class represents a interface date with day, month and year for testing purposes of Interfaces. 
 */
public class DateUtils {

    public static int amountOfDaysTo(MyDate firstDate, MyDate otherDate) {
        int days = 0;
        if (firstDate.compareTo(otherDate) > 0) {
            for (int i = otherDate.getYear(); i < firstDate.getYear(); i++) {
                days += 365;
            }
            for (int i = 1; i < firstDate.getMonth(); i++) {
                days += 30;
            }
            days += firstDate.getDay();
            for (int i = 1; i < otherDate.getMonth(); i++) {
                days -= 30;
            }
            days -= otherDate.getDay();
        } else {
            for (int i = firstDate.getYear(); i < otherDate.getYear(); i++) {
                days += 365;
            }
            for (int i = 1; i < otherDate.getMonth(); i++) {
                days += 30;
            }
            days += otherDate.getDay();
            for (int i = 1; i < firstDate.getMonth(); i++) {
                days -= 30;
            }
            days -= firstDate.getDay();
        }
        return days;
    }

    public static int daysFromStartOfYear(MyDate date) {
        int days = 0;
        for (int i = 1; i < date.getMonth(); i++) {
            days += 30;
        }
        days += date.getDay();
        return days;
    }

    public static int daysToEndOfYear(MyDate date) {
        int days = 0;
        for (int i = date.getMonth() + 1; i <= 12; i++) {
            days += 30;
        }
        days += (30 - date.getDay());
        return days;
    }
}