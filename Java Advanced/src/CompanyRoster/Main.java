package CompanyRoster;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Department> departments = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            String email;
            if (tokens.length - 1 >= 4) {
                email = tokens[4];
            } else {
                email = "n/a";
            }
            int age;
            if (tokens.length - 1 == 5) {
                age = Integer.parseInt(tokens[5]);
            } else {
                age = -1;
            }

            departments.putIfAbsent(department, new Department(department));

            Employee employee = null;

            employee = new Employee(name, salary, position, department, email, age);
            departments.get(department).addEmployee(employee);

        }

        double highestPayingSalary = 0;
        String departmentName = "";
        for (Department department : departments.values()) {
            if (department.getAverageSalary() > highestPayingSalary) {
                highestPayingSalary = department.getAverageSalary();
                departmentName = department.getName();
            }
        }

        ArrayList<Employee> employees = new ArrayList<>(departments.get(departmentName).getEmployees());

        //Printing
        System.out.println("Highest Average Salary: " + departmentName);
        employees.stream()
                .sorted((f, s) -> Double.compare(s.getSalary(), f.getSalary()))
                .forEach(employee -> {
                    System.out.printf("%s %.2f %s %d%n"
                            , employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge());
                });
    }
}
