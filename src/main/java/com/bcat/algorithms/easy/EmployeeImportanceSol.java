package com.bcat.algorithms.easy;

import java.util.*;

/**
 * Solution for leetcode 690 - Employee Importance.
 */
public class EmployeeImportanceSol {
    static class Employee {
        private int id;
        private int importance;
        private List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null) {
            return 0;
        }
        Map<Integer, Employee> id2EmployeeMap = new HashMap<>(employees.size());
        for (Employee employee : employees) {
            id2EmployeeMap.put(employee.id, employee);
        }
        int importance = 0;
        if (id2EmployeeMap.containsKey(id)) {
            return calcImportance(id2EmployeeMap.get(id), id2EmployeeMap);
        }
        return importance;
    }

    public int calcImportance(Employee employee, Map<Integer, Employee> employeeMap) {
        if (employee == null) {
            return 0;
        }
        int result = employee.importance;
        if (employee.subordinates != null) {
            for (int subordinate : employee.subordinates) {
                result += calcImportance(employeeMap.get(subordinate), employeeMap);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        EmployeeImportanceSol sol = new EmployeeImportanceSol();
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, 5, Arrays.asList(2, 3)));
        employees.add(new Employee(2, 3, null));
        employees.add(new Employee(3, 3, null));

        System.out.println(sol.getImportance(employees, 1));

        employees.clear();
        employees.add(new Employee(1, 5, Arrays.asList(2, 3)));
        employees.add(new Employee(2, 3, Collections.singletonList(4)));
        employees.add(new Employee(3, 4, null));
        employees.add(new Employee(4, 1, null));
        System.out.println(sol.getImportance(employees, 1));
    }
}
