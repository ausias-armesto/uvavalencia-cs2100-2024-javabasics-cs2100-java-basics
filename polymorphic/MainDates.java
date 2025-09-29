package polymorphic;

public class MainDates {

    public static void main(String[] args) {

        SimpleDate simpleDate1 = new SimpleDate(20200201);
        SpanishDate spanishDate1 = new SpanishDate(21, 2, 2020);
        AmericanDate americanDate1 = new AmericanDate(1, 31, 2022);

        spanishDate1.amountOfDaysTo(simpleDate1);
        ((SimpleDate) spanishDate1).amountOfDaysTo(simpleDate1);

        // The method invoked through a polymorphic reference can change from one invocation to the next
        SimpleDate simpleDate;
        simpleDate = simpleDate1;
        System.out.println("SimpleDate 1: " + simpleDate.toString());
        simpleDate = spanishDate1;
        System.out.println("SimpleDate 2: " + simpleDate.toString());
        simpleDate = americanDate1;
        System.out.println("SimpleDate 3: " + simpleDate.toString());
    }
    
}
