package ismetsandikci.hrmanagementsystem.business.abstracts;

import java.util.List;

import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.entities.concretes.EmploymentType;

public interface EmploymentTypeService {

    DataResult<List<EmploymentType>> getAll();
	
    DataResult<EmploymentType> getById(int id);
	
    Result add(EmploymentType employmentType);

    Result update(EmploymentType employmentType);

    Result delete(EmploymentType employmentType);
	
}
