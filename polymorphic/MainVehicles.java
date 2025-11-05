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
        // Widening conversion: Assigning a child object to a parent reference
        vehicle = new Car();
        vehicle.start();



        // Narrow conversion: Assigning a parent object to a child reference
        Vehicle vehicle2 = new Vehicle();
        // vehicle2.convertCar()
        if (vehicle2 instanceof Car) {
            Car car = (Car) vehicle2; // Safe cast
        } else {
            System.out.println("vehicle2 is not a Car");
        }


        // A subclass object can be used wherever a superclass object is expected
        // In the parameter
        vehicle.compare(car1);
        vehicle.compare(vehicle1);
        vehicle.compare(bike1);


    }

}

     