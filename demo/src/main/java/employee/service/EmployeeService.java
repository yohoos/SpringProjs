package employee.service;

import employee.models.Employee;

import java.util.List;

/**
 * Created by yohoos on 5/5/17.
 */
public interface EmployeeService {
    Employee getEmployeeById(long id);
    List<Employee> getAllEmployees();
}
