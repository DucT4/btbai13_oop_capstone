package bt_bai13_oop_capstone;

import java.util.ArrayList;
import java.util.List;

public class Company {
	private String name;
	private String taxCode;
	private double monthReveneu;
	private List<Employee> employees;


	public Company(String name, String taxCode, double monthReveneu) {
		this.name = name;
		this.taxCode = taxCode;
		this.monthReveneu = monthReveneu;
		this.employees = new ArrayList<Employee>();
	}

	public Company() {

	}

// hàm add nhân viên dưới quyền cho trường phòng
	public void addEmployee(Employee employee) {
		employees.add(employee);
		if(employee instanceof Staff && ((Staff) employee).getManager()!=null) {
			((Staff) employee).getManager().increamentSubordinateCount();
		}
	}

// hàm tính doanh thu 
	public double getTotalSalary() {
		double total = 0;
		for (Employee employee : employees) {
			total += employee.calculateSalary();
		}
		return total;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public double getMonthReveneu() {
		return monthReveneu;
	}

	public void setMonthReveneu(double monthReveneu) {
		this.monthReveneu = monthReveneu;
	}

	public List<Employee> getEmployee() {
		return getEmployee();
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	

}
