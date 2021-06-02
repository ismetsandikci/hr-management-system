package ismetsandikci.hrmanagementsystem.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ismetsandikci.hrmanagementsystem.business.abstracts.JobPositionService;
import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.ErrorResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessDataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessResult;
import ismetsandikci.hrmanagementsystem.dataAccess.abstracts.JobPositionDao;
import ismetsandikci.hrmanagementsystem.entities.concretes.JobPosition;

@Service("JobPositionManager")
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "İş Pozisyonları Listelendi");
	}

	@Override
	public DataResult<JobPosition> getByTitleName(String titleName) {
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.findByTitleName(titleName), "İş Pozisyonu Listelendi");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		
		if(!isTitleExist(jobPosition.getTitleName())) {
			return new ErrorResult("Job title Exist.");
		}
		
		jobPosition.setCreatedDate(LocalDate.now());
		jobPosition.setIsActive(true);
		
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("JobTitle Added.");
	}
	
	private boolean isTitleExist(String titleName) {
		if(this.jobPositionDao.findByTitleName(titleName) != null) {
			return false;
		}
		return true;
		
	}
}
