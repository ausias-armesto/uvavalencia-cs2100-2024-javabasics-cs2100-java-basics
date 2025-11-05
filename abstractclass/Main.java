package abstractclass;

public class Main {

    public static void main(String[] args) {

        // An object reference to an abstract class can point to an object of a concrete subclass
        // widening conversion 
        AbstractDate spanishDate = new SpanishDate(1, 2, 2020);
        System.out.println("SpanishDate: " + spanishDate);

        // widening conversion
        AbstractDate americanDate = new AmericanDate(1, 1, 2022);

        SpanishDate spanishDate2 = (SpanishDate) spanishDate;

        if (spanishDate.equals(americanDate)) {
            System.out.println("spanishDate and americanDate are equal");
        } else {
            System.out.println("[WARN] spanishDate and americanDate are not equal");
        }

        if (spanishDate == spanishDate2) {
            System.out.println("spanishDate and spanishDate2 are the same object");
        } else {
            System.out.println("[WARN] spanishDate and spanishDate2 are different objects");
        }
        if (spanishDate.equals(spanishDate2)) {
            System.out.println("spanishDate and spanishDate2 are equal");
        } else {
            System.out.println("[WARN] spanishDate and spanishDate2 are not equal");
        }
        int amountOfDaysTo = spanishDate.amountOfDaysTo(americanDate);
        System.out.println("Amount of days from SimpleDate to americanDate: " + amountOfDaysTo);

    }
}
