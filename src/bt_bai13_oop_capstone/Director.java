package bt_bai13_oop_capstone;

public class Director extends Employee {
    private static final int DAILY_SALARY = 300;
    private int sharePercentage; // cổ phần

    public Director(String id, String name, String phone, int workingDays, int sharePercentage) {
        super(id, name, phone, workingDays, DAILY_SALARY);
        this.sharePercentage = Math.min(sharePercentage, 100);
    }

    public Director(String id, String name, String phone, int workingDays, double salaryOneDay) {
        super(id, name, phone, workingDays, salaryOneDay);
    }

    public int getSharePercentage() {
        return sharePercentage;
    }

    public void setSharePercentage(int sharePercentage) {
        this.sharePercentage = Math.min(sharePercentage, 100);
    }

    @Override
    public double calculateSalary() {
        return getWorkingDays() * DAILY_SALARY;
    }

    public double calculateIncome(double profit) {
        return calculateSalary() + (sharePercentage / 100.0) * profit;
    }
}