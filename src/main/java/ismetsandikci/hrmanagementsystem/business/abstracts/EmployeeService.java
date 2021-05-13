package ismetsandikci.hrmanagementsystem.business.abstracts;

import java.util.List;

import ismetsandikci.hrmanagementsystem.entities.concretes.Employee;

public interface EmployeeService {

	List<Employee> getAll();
}
