package ismetsandikci.hrmanagementsystem.business.abstracts;

import java.util.List;

import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.entities.concretes.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	
	DataResult<Employer> getByEmail(String email);
	
	DataResult<Employer> getById(int id);
	
	Result add(Employer employer);
}
