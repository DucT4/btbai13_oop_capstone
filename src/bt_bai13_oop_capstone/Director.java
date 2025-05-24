package bt_bai13_oop_capstone;
// class giám đốc
public class Director extends Employee {
	private static final int DAILY_SALARY = 300;
	private int sharePercentage;
     


	public Director(String id, String name, String phone, int workingDays,int sharePercentage) {
		super(id, name, phone, workingDays, DAILY_SALARY);
		this.sharePercentage = sharePercentage;
	}

	public Director(String id, String name, String phone, int workingDays, double salaryOneDay) {
		super(id, name, phone, workingDays, salaryOneDay);
	}

	public int getSharePercentage() {
		return sharePercentage;
	}

	public void setSharePercentage(int sharePercentage) {
		this.sharePercentage = sharePercentage;
	}



	@Override
	public double calculateSalary() {
		// TODO Auto-generated method stub
		return DAILY_SALARY*getWorkingDays();
	}

	
}
