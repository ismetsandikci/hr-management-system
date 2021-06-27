package ismetsandikci.hrmanagementsystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ismetsandikci.hrmanagementsystem.business.abstracts.EmploymentTypeService;
import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessDataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessResult;
import ismetsandikci.hrmanagementsystem.dataAccess.abstracts.EmploymentTypeDao;
import ismetsandikci.hrmanagementsystem.entities.concretes.EmploymentType;

@Service("EmploymentTypeManager")
public class EmploymentTypeManager implements EmploymentTypeService {
	
	private EmploymentTypeDao employmentTypeDao;

    @Autowired
    public EmploymentTypeManager(EmploymentTypeDao employmentTypeDao) {
        this.employmentTypeDao = employmentTypeDao;
    }
    
	@Override
	public DataResult<List<EmploymentType>> getAll() {
		return new SuccessDataResult<>(this.employmentTypeDao.findAll());
	}

	@Override
	public DataResult<EmploymentType> getById(int id) {
		return new SuccessDataResult<EmploymentType>(this.employmentTypeDao.getById(id));
	}

	@Override
	public Result add(EmploymentType employmentType) {
		this.employmentTypeDao.save(employmentType);
        return new SuccessResult("Employment Type added.");
	}

	@Override
	public Result update(EmploymentType employmentType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(EmploymentType employmentType) {
		// TODO Auto-generated method stub
		return null;
	}

}
