package Repositories;

import app.Employee;

import java.util.List;

/**
 * Created by Sander on 22-9-2016.
 */
public interface IEmployeeRepo {
    public List<Employee> getEmployees();

    public Employee getEmployee(String code);

    public void addEmployee(Employee employee);

    public void deleteEmployee(String code);
}
