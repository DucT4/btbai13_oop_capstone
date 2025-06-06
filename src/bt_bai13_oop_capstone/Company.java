package bt_bai13_oop_capstone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Company {
    private String name;
    private String taxCode;
    private double monthRevenue;
    private List<Employee> employees;

    public Company() {
        this.employees = new ArrayList<>();
    }

    public Company(String name, String taxCode, double monthRevenue) {
        this.name = name;
        this.taxCode = taxCode;
        this.monthRevenue = monthRevenue;
        this.employees = new ArrayList<>();
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

    public double getMonthRevenue() {
        return monthRevenue;
    }

    public void setMonthRevenue(double monthRevenue) {
        this.monthRevenue = monthRevenue;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee e) {
        employees.add(e);
        if (e instanceof Staff) {
            Staff s = (Staff) e;
            if (s.getManager() != null) {
                s.getManager().increamentSubordinateCount();
            }
        }
    }

    public boolean removeEmployee(String id) {
        Employee toRemove = null;
        for (Employee e : employees) {
            if (e.getId().equals(id)) {
                toRemove = e;
                break;
            }
        }
        if (toRemove != null) {
            if (toRemove instanceof Manager) {
                // Ngắt liên kết nhân viên dưới quyền
                for (Employee e : employees) {
                    if (e instanceof Staff) {
                        Staff s = (Staff) e;
                        if (s.getManager() == toRemove) {
                            s.setManager(null);
                        }
                    }
                }
            } else if (toRemove instanceof Staff) {
                Staff s = (Staff) toRemove;
                if (s.getManager() != null) {
                    s.getManager().decrementSubordinateCount();
                }
            }
            employees.remove(toRemove);
            return true;
        }
        return false;
    }

    public boolean assignStaffToManager(String staffId, String managerId) {
        Employee staff = null, manager = null;
        for (Employee e : employees) {
            if (e.getId().equals(staffId) && e instanceof Staff) staff = e;
            if (e.getId().equals(managerId) && e instanceof Manager) manager = e;
        }
        if (staff != null && manager != null) {
            Staff s = (Staff) staff;
            if (s.getManager() != null) {
                s.getManager().decrementSubordinateCount();
            }
            s.setManager((Manager) manager);
            ((Manager) manager).increamentSubordinateCount();
            return true;
        }
        return false;
    }

    public double getTotalSalary() {
        double total = 0;
        for (Employee e : employees) {
            total += e.calculateSalary();
        }
        return total;
    }

    public double getProfit() {
        return monthRevenue - getTotalSalary();
    }

    public Employee getHighestPaidStaff() {
        Employee maxStaff = null;
        double maxSalary = 0;
        for (Employee e : employees) {
            if (e instanceof Staff && !(e instanceof Manager)) {
                if (e.calculateSalary() > maxSalary) {
                    maxSalary = e.calculateSalary();
                    maxStaff = e;
                }
            }
        }
        return maxStaff;
    }

    public Manager getMostSubordinateManager() {
        Manager maxManager = null;
        int maxCount = -1;
        for (Employee e : employees) {
            if (e instanceof Manager) {
                Manager m = (Manager) e;
                if (m.getSubordinateCount() > maxCount) {
                    maxCount = m.getSubordinateCount();
                    maxManager = m;
                }
            }
        }
        return maxManager;
    }

    public Director getMostShareholderDirector() {
        Director maxDirector = null;
        double maxShare = -1;
        for (Employee e : employees) {
            if (e instanceof Director) {
                Director d = (Director) e;
                if (d.getSharePercentage() > maxShare) {
                    maxShare = d.getSharePercentage();
                    maxDirector = d;
                }
            }
        }
        return maxDirector;
    }

    public void sortEmployeesByName() {
        Collections.sort(employees, Comparator.comparing(Employee::getName));
    }

    public void sortEmployeesBySalaryDesc() {
        employees.sort((e1, e2) -> Double.compare(e2.calculateSalary(), e1.calculateSalary()));
    }

    public void displayAllEmployees() {
        System.out.println("=== Thông Tin Công Ty ===");
        System.out.println("Tên: " + name);
        System.out.println("Mã số thuế: " + taxCode);
        System.out.println("Doanh thu tháng: " + monthRevenue);
        System.out.println("=== Danh Sách Nhân Sự ===");
        for (Employee e : employees) {
            e.displayInfo();
            System.out.println("------------------------");
        }
    }

    public void displayDirectorIncome() {
        double profit = getProfit();
        System.out.println("Lợi nhuận công ty: " + profit);
        for (Employee e : employees) {
            if (e instanceof Director) {
                Director d = (Director) e;
                double income = d.calculateIncome(profit);
                System.out.println("Giám đốc " + d.getName() + " - Lương: " + d.calculateSalary() +
                        " - Cổ phần: " + d.getSharePercentage() + "%" +
                        " - Thu nhập: " + income);
            }
        }
    }
}
