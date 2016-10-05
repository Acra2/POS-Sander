package Repositories;

import app.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sander on 22-9-2016.
 */
public class DummyEmployeeRepo implements IEmployeeRepo {
    static HashMap<String, Employee> employees = new HashMap<String, Employee>();

    private static DummyEmployeeRepo repo;

    public static DummyEmployeeRepo getInstance() {
        if (repo == null) {
            repo = new DummyEmployeeRepo();
            employees.put("123", new Employee("123", "Employee 1"));
            employees.put("456", new Employee("456", "Employee 2"));
        }
        return repo;
    }

    public List<Employee> getEmployees() {
        return new ArrayList<Employee>(employees.values());
    }

    ;

    public Employee getEmployee(String code) {
        return employees.get(code);
    }

    ;

    public void addEmployee(Employee employee) {
        employees.put(employee.getCode(), employee);
    }

    public void deleteEmployee(String code) {
        employees.remove(code);
    }
}
