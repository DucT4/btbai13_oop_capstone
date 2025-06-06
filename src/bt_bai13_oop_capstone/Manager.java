package bt_bai13_oop_capstone;

public class Manager extends Employee {
    private int subordinateCount;

    public Manager(String id, String name, String phone, int workingDays, int subordinateCount) {
        super(id, name, phone, workingDays, 200);
        this.subordinateCount = subordinateCount;
    }

    public Manager(String id, String name, String phone, int workingDays, double salaryOneDay) {
        super(id, name, phone, workingDays, salaryOneDay);
    }

    public int getSubordinateCount() {
        return subordinateCount;
    }

    public void setSubordinateCount(int subordinateCount) {
        this.subordinateCount = subordinateCount;
    }

    public void increamentSubordinateCount() {
        subordinateCount++;
    }

    public void decrementSubordinateCount() {
        if (subordinateCount > 0) subordinateCount--;
    }

    @Override
    public double calculateSalary() {
        return getWorkingDays() * getDailySalary() + 100 * subordinateCount;
    }
}