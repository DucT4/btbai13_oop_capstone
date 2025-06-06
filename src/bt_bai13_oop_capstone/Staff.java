package bt_bai13_oop_capstone;

public class Staff extends Employee {
    private Manager manager;

    public Staff(String id, String name, String phone, int workingDays, Manager manager) {
        super(id, name, phone, workingDays, 100);
        this.manager = manager;
    }

    public Staff(String id, String name, String phone, int workingDays, double dailySalary) {
        super(id, name, phone, workingDays, dailySalary);
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public double calculateSalary() {
        return getWorkingDays() * getDailySalary();
    }
}