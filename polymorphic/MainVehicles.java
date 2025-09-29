package polymorphic;

public class MainVehicles {

    public static void main(String[] args) {

        Vehicle vehicle1 = new Vehicle();
        Vehicle car1 = new Car();

        vehicle1.start();
        car1.start();


        // It is the actual runtime type of the object being referenced, not the declared reference type, that
        // determines which method is invoked
        Vehicle vehicle2;
        vehicle2 = car1;
        vehicle2.start();
    }

}

     