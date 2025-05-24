package bt_bai13_oop_capstone;
  // class trưởng phòng
public class Manager extends Employee {
	private static final int DAILY_SALARY = 200;
	private int subordinateCount;

	public Manager(String id, String name, String phone, int workingDays, int subordinateCount) {
		super(id, name, phone, workingDays, DAILY_SALARY);
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



	@Override
	public double calculateSalary() {
		// TODO Auto-generated method stub
		return getWorkingDays()*DAILY_SALARY +100*subordinateCount;
	}
    // tăng subordinateCount khi có nhân viên mới được thêm vào 
	public void increamentSubordinateCount () {
		subordinateCount++;
	}

	
	
}
