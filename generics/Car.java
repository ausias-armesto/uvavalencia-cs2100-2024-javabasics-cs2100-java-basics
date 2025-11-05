package generics;

public class Car implements MyComparable<Car>{
    
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int compareTo(Car other) {
        return this.name.compareTo(other.getName());
    }
}
