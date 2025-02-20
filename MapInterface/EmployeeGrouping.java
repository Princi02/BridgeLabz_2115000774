package MapInterface;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeGrouping {
    static class Employee {
        String name;
        String department;

        public Employee(String name, String department) {
            this.name = name;
            this.department = department;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR"),
                new Employee("David", "Finance"),
                new Employee("Eve", "IT")
        );

        Map<String, List<Employee>> groupedByDepartment = employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.department));

        for (Map.Entry<String, List<Employee>> entry : groupedByDepartment.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
