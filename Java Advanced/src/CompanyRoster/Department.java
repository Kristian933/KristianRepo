package CompanyRoster;

import CompanyRoster.Employee;

import java.util.ArrayList;

public class Department {

    private String name;
    private double salaries;
    private static int people;

    private ArrayList<Employee> employees;

    public Department(String name) {
        people++;
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public double getAverageSalary() {

        for (Employee employee : employees) {
            this.salaries += employee.getSalary();
        }
        return salaries / (people * 1.0);
    }

    //Getters

    public String getName() {
        return name;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}
