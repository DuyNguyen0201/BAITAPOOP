import java.time.Year;

class Person {
    protected String name;
    protected int birthYear;
    protected String address;
    protected String phone;

    public Person(String name, int birthYear, String address, String phone) {
        this.name = name;
        this.birthYear = birthYear;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return Year.now().getValue() - birthYear;
    }

    public void showInfo() {
        System.out.println("Họ tên: " + name);
        System.out.println("Năm sinh: " + birthYear + " (Tuổi: " + getAge() + ")");
        System.out.println("Địa chỉ: " + address);
        System.out.println("Số điện thoại: " + phone);
    }
}

class Employee extends Person {
    protected String id;
    protected String department;
    protected double baseSalary;
    protected int startYear;

    public Employee(String name, int birthYear, String address, String phone,
                    String id, String department, double baseSalary, int startYear) {
        super(name, birthYear, address, phone);
        this.id = id;
        this.department = department;
        this.baseSalary = baseSalary;
        this.startYear = startYear;
    }

    public String getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public int getStartYear() {
        return startYear;
    }

    public String getRole() {
        return "Employee";
    }

    public double calculateSalary() {
        int workingYears = Year.now().getValue() - startYear;
        return baseSalary + 200000.0 * Math.max(0, workingYears);
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Vai trò: " + getRole());
        System.out.println("Mã nhân viên: " + id);
        System.out.println("Phòng ban: " + department);
        System.out.println("Năm bắt đầu làm việc: " + startYear);
        System.out.println("Lương cơ bản: " + String.format("%.0f", baseSalary));
        System.out.println("Tổng lương: " + String.format("%.0f", calculateSalary()));
    }
}

class Developer extends Employee {
    private String language;
    private double overtimeHours;
    private double overtimeRate;

    public Developer(String name, int birthYear, String address, String phone,
                     String id, String department, double baseSalary, int startYear,
                     String language, double overtimeHours, double overtimeRate) {
        super(name, birthYear, address, phone, id, department, baseSalary, startYear);
        this.language = language;
        this.overtimeHours = overtimeHours;
        this.overtimeRate = overtimeRate;
    }

    public String getLanguage() {
        return language;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public double getOvertimeRate() {
        return overtimeRate;
    }

    @Override
    public String getRole() {
        return "Developer";
    }

    @Override
    public double calculateSalary() {
        return super.calculateSalary() + overtimeHours * overtimeRate;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Ngôn ngữ lập trình: " + language);
        System.out.println("Số giờ làm thêm: " + overtimeHours);
        System.out.println("Đơn giá làm thêm: " + String.format("%.0f", overtimeRate));
    }
}

class Manager extends Employee {
    private int teamSize;
    private double bonusPerMember;

    public Manager(String name, int birthYear, String address, String phone,
                   String id, String department, double baseSalary, int startYear,
                   int teamSize, double bonusPerMember) {
        super(name, birthYear, address, phone, id, department, baseSalary, startYear);
        this.teamSize = teamSize;
        this.bonusPerMember = bonusPerMember;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public double getBonusPerMember() {
        return bonusPerMember;
    }

    @Override
    public String getRole() {
        return "Manager";
    }

    @Override
    public double calculateSalary() {
        return super.calculateSalary() + teamSize * bonusPerMember;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Số lượng thành viên quản lý: " + teamSize);
        System.out.println("Thưởng mỗi thành viên: " + String.format("%.0f", bonusPerMember));
    }
}

public class MainBai4 {
    public static void main(String[] args) {
        Person[] people = new Person[] {
            new Employee("Nguyen Van A", 1990, "Ha Noi", "0901234567", "NV01", "Hanh chinh", 10000000, 2020),
            new Developer("Tran Thi B", 1995, "Da Nang", "0912345678", "DEV01", "Ky thuat", 15000000, 2021, "Java", 20, 150000),
            new Developer("Le Van C", 1998, "Ha Noi", "0923456789", "DEV02", "Ky thuat", 14000000, 2023, "Python", 15, 120000),
            new Manager("Pham Van D", 1985, "TP.HCM", "0987654321", "MNG01", "Quan ly", 25000000, 2015, 10, 500000)
        };

        for (Person p : people) {
            p.showInfo();
            System.out.println("----------------------------------------");
        }

        double totalSalary = 0;
        for (Person p : people) {
            if (p instanceof Employee) {
                totalSalary += ((Employee) p).calculateSalary();
            }
        }
        System.out.println("Tổng lương của tất cả nhân viên: " + String.format("%.0f", totalSalary));

        int devCount = 0;
        int managerCount = 0;
        for (Person p : people) {
            if (p instanceof Developer) {
                devCount++;
            } else if (p instanceof Manager) {
                managerCount++;
            }
        }
        System.out.println("Số lượng Developer: " + devCount);
        System.out.println("Số lượng Manager: " + managerCount);
    }
}
