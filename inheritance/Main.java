package inheritance;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        // Simple Date
        SimpleDate simpleDate1 = new SimpleDate(20200201);
        System.out.println("SimpleDate1: \n" + simpleDate1);

        // // Spanish Date
        SpanishDate spanishDate1 = new SpanishDate(1, 2, 2020);
        SpanishDate spanishDate2 = new SpanishDate("1", "2", "2020");
        SpanishDate spanishDate3 = new SpanishDate("24/09/2025");
        System.out.println("SpanishDate1: " + spanishDate1);
        System.out.println("SpanishDate2: " + spanishDate2);
        System.out.println("SpanishDate3: " + spanishDate3);

        if (simpleDate1 == spanishDate1) {
            System.out.println("SimpleDate1 and SpanishDate1 pointers are equal");
        } else {
            System.out.println("[WARN] SpanishDate1 and SpanishDate2 pointers are not equal");
        }
        if (simpleDate1.equals(spanishDate1)) {
            System.out.println("SimpleDate1 and SpanishDate1 are equal");
        } else {
            System.out.println("[WARN] SpanishDate1 and SpanishDate2 are not equal");
        }
        int amountOfDaysTo = spanishDate3.amountOfDaysTo(simpleDate1);
        System.out.println("Amount of days from SimpleDate1 to spanishDate3: " + amountOfDaysTo);
        int daysToExam = SimpleDate.fromDate(new Date()).amountOfDaysTo(SimpleDate.FINAL_EXAM);
        System.out.println("Amount of days to FINAL_EXAM: " + daysToExam);

        // American Date
        AmericanDate americanDate1 = new AmericanDate(1, 1, 2022);
        AmericanDate americanDate2 = new AmericanDate("2", "21", "2022");
        AmericanDate americanDate3 = new AmericanDate("3/1/2022");
        System.out.println("AmericanDate1: " + americanDate1);
        System.out.println("AmericanDate1: " + americanDate2);
        System.out.println("AmericanDate1: " + americanDate3);

        // // Timestamp
        // Timestamp timestamp1 = new Timestamp(1, 1, 2023, 16, 30, 50);
        // Timestamp timestamp2 = new Timestamp(1, 1, 2023, 16, 30, 50);
        // System.out.println("Timestamp1: " + timestamp1);
        // if (timestamp1.equals(timestamp2)){
        //     System.out.println("Timestamp1 and Timestamp2 are equal");
        // } else {
        //     System.out.println("[WARN] Timestamp1 and Timestamp2 are not equal");
        // }
    }
    
}
