package inheritance;

import java.util.Calendar;
import java.util.Date;

/*
    This class represents a simple date with day, month and year for testing purposes of Inheritance. 
    In a real-world scenario, you should use the java.time.LocalDate class.
 */
public class SimpleDate {

    public static final SimpleDate FINAL_EXAM = new SimpleDate(20251218);

    private int day;
    private int month;
    private int year;

    public SimpleDate() {}

    /*
    @param day The day of the date. Format YYYYMMDD
     */
    public SimpleDate(int fullDate) {
        String fullDateString = Integer.toString(fullDate);
        if (fullDateString.length() != 8) {
            throw new IllegalArgumentException("Invalid date");
        }
        this.year = Integer.parseInt(fullDateString.substring(0, 4));
        this.month = Integer.parseInt(fullDateString.substring(4, 6));
        this.day = Integer.parseInt(fullDateString.substring(6, 8));
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Invalid day");
        }
        this.day = day;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month");
        }
        this.month = month;
    }

    public void setYear(int year) {
        if (year < 2000 || year > 2025) {
            throw new IllegalArgumentException("Invalid year");
        }
        this.year = year;
    }

    /*
    @todo Does not implement leap years
    @todo Does not implement months with different amount of days
    */
    public int amountOfDaysTo(SimpleDate otherDate) { 
        int days = 0;
        if (this.compareTo(otherDate) > 0) {
            for (int i = otherDate.getYear(); i < this.year; i++) {
                days += 365;
            }
            for (int i = 1; i < this.month; i++) {
                days += 30;
            }
            days += this.day;
            for (int i = 1; i < otherDate.getMonth(); i++) {
                days -= 30;
            }
            days -= otherDate.getDay();
        } else {
            for (int i = this.year; i < otherDate.getYear(); i++) {
                days += 365;
            }
            for (int i = 1; i < otherDate.getMonth(); i++) {
                days += 30;
            }
            days += otherDate.getDay();
            for (int i = 1; i < this.month; i++) {
                days -= 30;
            }
            days -= this.day;
        }
        return days;
    }

    public int compareTo(SimpleDate otherDate) {
        if (this.year != otherDate.getYear()) {
            return this.year - otherDate.getYear();
        } else if (this.month != otherDate.getMonth()) {
            return this.month - otherDate.getMonth();
        } else {
            return this.day - otherDate.getDay();
        }
    }

    public static SimpleDate fromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String dayString = day < 10 ? String.format("0%d", day) : String.valueOf(day);
        int month = calendar.get(Calendar.MONTH) + 1; // Calendar.MONTH is zero-based
        String monthString = month < 10 ? String.format("0%d", month) : String.valueOf(month);
        int year = calendar.get(Calendar.YEAR);
        int fullDate = Integer.parseInt(String.format("%d%s%s",year,monthString,dayString));
        return new SimpleDate(fullDate);
    }

    @Override
    public boolean equals(Object otherDateObject) {
        if (otherDateObject != null && otherDateObject instanceof SimpleDate) {
            SimpleDate otherDate = (SimpleDate) otherDateObject;
            return this.day == otherDate.getDay() && this.month == otherDate.getMonth() && this.year == otherDate.getYear();
        } else{
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("Day: %d\nMonth: %d\nYear: %d", this.day, this.month, this.year);
    }

}