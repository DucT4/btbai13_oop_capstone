package bt_bai13_oop_capstone;
// class nhân viên
public class Staff extends Employee {
	private static final int DAILY_SALARY= 100;
    private Manager manager;
	public Staff(String id, String name, String phone, int workingDays, Manager manager) {
		super(id, name, phone, workingDays, DAILY_SALARY);
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
		return getWorkingDays()*DAILY_SALARY;
	}
    
      
}
