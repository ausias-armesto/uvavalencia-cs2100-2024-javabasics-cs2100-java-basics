package abstractclass;

public class SpanishDate extends AbstractDate {

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


}