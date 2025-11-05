package generics;

import java.util.List;

public class Main {

        public static void displayCars(List<? extends Car> cars) {
            for (Car car : cars) {
                System.out.println(car.getName());
            }
        }

        public static void main(String[] args) {


        Car toyota = new Car("Toyota");
        Car bmw = new Car("BMW");
        toyota.compareTo(bmw);

        Ford ford = new Ford("Ford");
        Seat seat = new Seat("Seat");   
        List<Car> cars = List.of(toyota, bmw, ford, seat);
        displayCars(cars);
        List<Seat> seats = List.of(new Seat("Seat Ibiza"), new Seat("Seat Altea"));
        displayCars(seats);


        // Creating TaskManager to handle tasks
        TaskManager<Task> taskManager = new TaskManager<>();

        // // Creating specific tasks
        PayInvoiceTask invoiceTask = new PayInvoiceTask(1234L, 1000.0);
        PaySalaryTask johnSalaryTask = new PaySalaryTask("john");
        PaySalaryTask michelleSalaryTask = new PaySalaryTask("michelle");
        PaySalaryTask anastasiiaSalaryTask = new PaySalaryTask("anastasiia");

        // // Adding tasks to the task manager's queue
        taskManager.addTask(anastasiiaSalaryTask);
        taskManager.addTask(invoiceTask);
        taskManager.addTask(johnSalaryTask);
        taskManager.addTask(michelleSalaryTask);

        // // Processing the tasks in FIFO order
        taskManager.processTasks();
    }
}
