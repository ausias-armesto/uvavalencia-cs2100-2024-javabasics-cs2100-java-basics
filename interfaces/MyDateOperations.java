package interfaces;

/*
    This class represents a interface date with day, month and year for testing purposes of Interfaces. 
 */
public interface MyDateOperations extends MyDate {

    public default int amountOfDaysTo(MyDateOperations otherDate) {
        int days = 0;
        if (this.compareTo(otherDate) > 0) {
            for (int i = otherDate.getYear(); i < this.getYear(); i++) {
                days += 365;
            }
            for (int i = 1; i < this.getMonth(); i++) {
                days += 30;
            }
            days += this.getDay();
            for (int i = 1; i < otherDate.getMonth(); i++) {
                days -= 30;
            }
            days -= otherDate.getDay();
        } else {
            for (int i = this.getYear(); i < otherDate.getYear(); i++) {
                days += 365;
            }
            for (int i = 1; i < otherDate.getMonth(); i++) {
                days += 30;
            }
            days += otherDate.getDay();
            for (int i = 1; i < this.getMonth(); i++) {
                days -= 30;
            }
            days -= this.getDay();
        }
        return days;
    }

    public default int daysFromStartOfYear() {
        int days = 0;
        for (int i = 1; i < this.getMonth(); i++) {
            days += 30;
        }
        days += this.getDay();
        return days;
    }

    public default int daysToEndOfYear() {
        int days = 0;
        for (int i = this.getMonth() + 1; i <= 12; i++) {
            days += 30;
        }
        days += (30 - this.getDay());
        return days;
    }

    public String toString();
}