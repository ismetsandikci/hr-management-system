package ismetsandikci.hrmanagementsystem.business.abstracts;

import java.util.List;

import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.entities.concretes.Employee;

public interface EmployeeService {

	DataResult<List<Employee>> getAll();
	
	DataResult<Employee> getByEmail(String email);
}
