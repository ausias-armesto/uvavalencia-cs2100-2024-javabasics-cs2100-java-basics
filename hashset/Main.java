package hashset;




public class Main {

    public static void main(String[] args) {
        // Your HashSet code would go here
        java.util.Set<Person> persons = new java.util.HashSet<>();
        Person gasol = new Person("Pau", "Gasol");
        persons.add(new Person("Rafael", "Nadal"));
        persons.add(gasol);
        persons.add(new Person("Carlos", "Sainz"));
        persons.add(new Person("Rafael", "Nadal")); // Duplicate, will not be added
        persons.add(new Person("Carlos", "Sainz"));
        persons.add(null); // HashSet allows null

        // The contains method uses equals() and hashCode() to check for presence
        // The contains method costs O(1) on average
        System.out.println("Set contains 3: " + persons.contains(gasol));
        System.out.println("Set contains 7: " + persons.contains(new Person("Rafael", "Nadal")));

        System.out.println("Elements in the set:");
        for (Person person : persons) {
            System.out.println(person);
        }

    }   
    
}
