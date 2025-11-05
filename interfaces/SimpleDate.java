package interfaces;

/*
    This class represents a simple date with day, month and year for testing purposes of Inheritance. 
    In a real-world scenario, you should use the java.time.LocalDate class.
 */
public class SimpleDate implements MyDateOperations {

    private int day;
    private int month;
    private int year;

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
        if (year < 2000 || year > 2024) {
            throw new IllegalArgumentException("Invalid year");
        }
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("Day: %d\nMonth: %d\nYear: %d", this.day, this.month, this.year);
    }
}