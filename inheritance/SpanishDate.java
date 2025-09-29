package inheritance;

public class SpanishDate extends SimpleDate{

    public SpanishDate() {
        super();
    }

    public SpanishDate(int day, int month, int year) {

        this.setDay(day);
        this.setMonth(month);
        this.setYear(year);
    }

    public SpanishDate(String day, String month, String year) {
        try {
            this.setDay(Integer.parseInt(day));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid day");
        }
        try {
            this.setMonth(Integer.parseInt(month));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid month");
        }
        try {
            this.setYear(Integer.parseInt(year));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid year");
        }
    }

    // dd/mm/yyyy
    public SpanishDate(String date) {
        String[] parts = date.split("/");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid date");
        }
        try {
            this.setDay(Integer.parseInt(parts[0]));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid day");
        }
        try {
            this.setMonth(Integer.parseInt(parts[1]));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid month");
        }
        try {
            this.setYear(Integer.parseInt(parts[2]));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid year");
        }
    }

    @Override
    public String toString() {
        return this.getDay() + "/" + this.getMonth() + "/" + this.getYear();
    }

    // Overloading the add method
    public void add(int days) {
        int newDay = this.getDay() + days;
        int newMonth = this.getMonth();
        int newYear = this.getYear();
        while (newDay > 30) {
            newDay -= 30;
            newMonth++;
            if (newMonth > 12) {
                newMonth = 1;
                newYear++;
            }
        }
        this.setDay(newDay);
        this.setMonth(newMonth);
        this.setYear(newYear);
    }

    public void add(String days) {
        try {
            this.add(Integer.parseInt(days));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid days");
        }
    }

}