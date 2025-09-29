package polymorphic;

public class MainVehicles {

    public static void main(String[] args) {

        Vehicle vehicle1 = new Vehicle();
        Vehicle car1 = new Car();
        Bike bike1 = new Bike();

        vehicle1.start();
        car1.start();


        // It is the actual runtime type of the object being referenced, not the declared reference type, that
        // determines which method is invoked
        Vehicle vehicle;
        vehicle = new Car();
        vehicle.start();


        // A subclass object can be used wherever a superclass object is expected
        // In the parameter
        vehicle.compare(car1);
        vehicle.compare(vehicle1);
        vehicle.compare(bike1);


    }

}

     