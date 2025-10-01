package generics;

// Task: PaySalaryTask
class PaySalaryTask extends Task {
    private String employeeId;

    public PaySalaryTask(String employeeId) {
        super("PAY_SALARY");
        this.employeeId = employeeId;
    }

    @Override
    public void execute() {
        System.out.println("Pay Salary for " + employeeId + " if there is enogh balance and it's end of the month");
        System.out.println("Executing task: " + getName() + " - Processing salary payment.");
    }
}
