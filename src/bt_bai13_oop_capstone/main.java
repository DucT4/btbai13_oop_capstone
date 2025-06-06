package bt_bai13_oop_capstone;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Company company = new Company();

        while (true) {
            System.out.println("\n=== Quản Lý Nhân Sự ===");
            System.out.println("1. Nhập thông tin công ty");
            System.out.println("2. Thêm nhân viên");
            System.out.println("3. Xóa nhân viên");
            System.out.println("4. Phân bổ nhân viên vào trưởng phòng");
            System.out.println("5. Xuất toàn bộ thông tin");
            System.out.println("6. Tính tổng lương");
            System.out.println("7. Tìm nhân viên lương cao nhất");
            System.out.println("8. Tìm trưởng phòng có nhiều nhân viên nhất");
            System.out.println("9. Sắp xếp nhân viên theo tên");
            System.out.println("10. Sắp xếp nhân viên theo lương giảm dần");
            System.out.println("11. Tìm giám đốc có cổ phần nhiều nhất");
            System.out.println("12. Xuất thu nhập giám đốc");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên công ty: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập mã số thuế: ");
                    String taxCode = sc.nextLine();
                    System.out.print("Nhập doanh thu tháng: ");
                    double revenue = sc.nextDouble();
                    company.setName(name);
                    company.setTaxCode(taxCode);
                    company.setMonthRevenue(revenue);
                    break;
                case 2:
                    addEmployee(sc, company);
                    break;
                case 3:
                    System.out.print("Nhập mã nhân viên cần xóa: ");
                    String idDel = sc.nextLine();
                    if (company.removeEmployee(idDel))
                        System.out.println("Xóa thành công!");
                    else
                        System.out.println("Không tìm thấy nhân viên!");
                    break;
                case 4:
                    System.out.print("Nhập mã nhân viên: ");
                    String staffId = sc.nextLine();
                    System.out.print("Nhập mã trưởng phòng: ");
                    String managerId = sc.nextLine();
                    if (company.assignStaffToManager(staffId, managerId))
                        System.out.println("Phân bổ thành công!");
                    else
                        System.out.println("Thao tác thất bại!");
                    break;
                case 5:
                    company.displayAllEmployees();
                    break;
                case 6:
                    System.out.println("Tổng lương toàn công ty: " + company.getTotalSalary());
                    break;
                case 7:
                    Employee topStaff = company.getHighestPaidStaff();
                    if (topStaff != null) {
                        System.out.println("Nhân viên lương cao nhất:");
                        topStaff.displayInfo();
                    } else {
                        System.out.println("Không có nhân viên!");
                    }
                    break;
                case 8:
                    Manager m = company.getMostSubordinateManager();
                    if (m != null) {
                        System.out.println("Trưởng phòng có nhiều nhân viên nhất:");
                        m.displayInfo();
                    } else {
                        System.out.println("Không có trưởng phòng!");
                    }
                    break;
                case 9:
                    company.sortEmployeesByName();
                    System.out.println("Đã sắp xếp theo tên!");
                    break;
                case 10:
                    company.sortEmployeesBySalaryDesc();
                    System.out.println("Đã sắp xếp theo lương giảm dần!");
                    break;
                case 11:
                    Director d = company.getMostShareholderDirector();
                    if (d != null) {
                        System.out.println("Giám đốc có cổ phần nhiều nhất:");
                        d.displayInfo();
                    } else {
                        System.out.println("Không có giám đốc!");
                    }
                    break;
                case 12:
                    company.displayDirectorIncome();
                    break;
                case 0:
                    System.out.println("Chương trình kết thúc!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void addEmployee(Scanner sc, Company company) {
        System.out.println("Chọn loại nhân viên:");
        System.out.println("1. Nhân viên");
        System.out.println("2. Trưởng phòng");
        System.out.println("3. Giám đốc");
        System.out.print("Lựa chọn: ");
        int type = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhập mã: ");
        String id = sc.nextLine();
        System.out.print("Họ tên: ");
        String name = sc.nextLine();
        System.out.print("Số điện thoại: ");
        String phone = sc.nextLine();
        System.out.print("Số ngày làm việc: ");
        int days = sc.nextInt();

        switch (type) {
            case 1:
                System.out.print("Nhập mã trưởng phòng (hoặc để trống nếu không có): ");
                String mgrId = sc.nextLine();
                Manager mgr = null;
                if (!mgrId.isEmpty()) {
                    for (Employee e : company.getEmployees()) {
                        if (e.getId().equals(mgrId) && e instanceof Manager) {
                            mgr = (Manager) e;
                            break;
                        }
                    }
                }
                Staff staff = new Staff(id, name, phone, days, mgr);
                company.addEmployee(staff);
                break;
            case 2:
                System.out.print("Nhập số nhân viên dưới quyền: ");
                int subCount = sc.nextInt();
                sc.nextLine();
                Manager manager = new Manager(id, name, phone, days, subCount);
                company.addEmployee(manager);
                break;
            case 3:
                System.out.print("Nhập cổ phần (%): ");
                int sharePercent = sc.nextInt();
                sc.nextLine();
                Director director = new Director(id, name, phone, days, sharePercent);
                company.addEmployee(director);
                break;
        }
        System.out.println("Thêm nhân viên thành công!");
    }
}
