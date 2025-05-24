package bt_bai13_oop_capstone;

public abstract class Employee {
    private  String id;
    private String name;
    private String phone;
    private int workingDays;
    private double dailySalary;
	public Employee(String id, String name, String phone, int workingDays, double dailySalary) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.workingDays = workingDays;
		this.dailySalary = dailySalary;
	}
	public Employee() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getWorkingDays() {
		return workingDays;
	}
	public void setWorkingDays(int workingDays) {
		this.workingDays = workingDays;
	}
	public double getDailySalary() {
		return dailySalary;
	}
	public void setdDailySalary(double dailySalary) {
		this.dailySalary = dailySalary;
	}
   
    // calculate salary function
	public abstract  double calculateSalary();
}
