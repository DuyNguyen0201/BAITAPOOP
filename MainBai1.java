abstract class Employee {
    protected String name;
    protected int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateSalary();
}

class OfficeEmployee extends Employee {
    private static final double DAILY_WAGE = 100.0;
    private int workingDays;

    public OfficeEmployee(String name, int age, int workingDays) {
        super(name, age);
        this.workingDays = workingDays;
    }

    @Override
    public double calculateSalary() {
        return workingDays * DAILY_WAGE;
    }
}

class TechnicalEmployee extends Employee {
    private int workingHours;
    private double hourlyRate;

    public TechnicalEmployee(String name, int age, int workingHours, double hourlyRate) {
        super(name, age);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return workingHours * hourlyRate;
    }
}

public class MainBai1 {
    public static void main(String[] args) {
        Employee[] employees = new Employee[] {
                new OfficeEmployee("Nguyen Van A", 25, 22),
                new TechnicalEmployee("Tran Van B", 28, 160, 15.5)
        };

        for (Employee emp : employees) {
            System.out.println("Nhan vien: " + emp.getName() + " - Luong: " + emp.calculateSalary());
        }
    }
}