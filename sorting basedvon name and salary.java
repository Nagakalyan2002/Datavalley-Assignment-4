import java.util.*;

class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private String designation;
    private double salary;

    public Employee(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee emp) {
        return this.name.compareTo(emp.getName());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return Double.compare(emp1.getSalary(), emp2.getSalary());
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee(101, "John", "Manager", 50000));
        employees.add(new Employee(102, "Alice", "Developer", 60000));
        employees.add(new Employee(103, "Bob", "Analyst", 45000));
        employees.add(new Employee(104, "Charlie", "Tester", 55000));
        Collections.sort(employees);
        System.out.println("Sorted by name:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
        Collections.sort(employees, new SalaryComparator());
        System.out.println("\nSorted by salary:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
