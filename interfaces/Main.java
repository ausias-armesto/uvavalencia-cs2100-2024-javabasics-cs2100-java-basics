package interfaces;

public class Main {

    public static void main(String[] args) {
        SimpleDate spanishDate1 = new SpanishDate(1, 2, 2020);
        SimpleDate spanishDate2 = new SpanishDate(10, 3, 2020);

        int amountOfDaysTo = spanishDate1.amountOfDaysTo(spanishDate2);
        System.out.println("Amount of days from spanishDate1 to spanishDate2 using instance method: " + amountOfDaysTo);

        MyDate date1 = spanishDate1; // Upcasting
        MyDate date2 = spanishDate2; // Upcasting

        int amountOfDaysTo2 = DateUtils.amountOfDaysTo(date1, date2);
        System.out.println("Amount of days from spanishDate1 to spanishDate2 using utility method: " + amountOfDaysTo2);

    }
    
}
