package ismetsandikci.hrmanagementsystem.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ismetsandikci.hrmanagementsystem.business.abstracts.JobPostingService;
import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessDataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessResult;
import ismetsandikci.hrmanagementsystem.dataAccess.abstracts.JobPostingDao;
import ismetsandikci.hrmanagementsystem.entities.concretes.JobPosting;
import ismetsandikci.hrmanagementsystem.entities.dtos.JobPostingListDto;

@Service("JobPostingManager")
public class JobPostingManager implements JobPostingService{

	private JobPostingDao jobPostingDao;

	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(), "Tüm iş ilanları detay listelendi.");
	}

	@Override
	public DataResult<List<JobPostingListDto>> getAllDto() {
		return new SuccessDataResult<List<JobPostingListDto>>(this.jobPostingDao.getAllDto(), "Tüm iş ilanları listelendi.");
	}
	
	@Override
	public DataResult<JobPosting> getById(int id) {
		return new SuccessDataResult<JobPosting>(this.jobPostingDao.getById(id), "İş ilanı listelendi.");
	}

	@Override
	public DataResult<List<JobPostingListDto>> getByIsActiveTrue() {
		return new SuccessDataResult<List<JobPostingListDto>>(this.jobPostingDao.getByIsActiveTrue(), "Aktif iş ilanları listelendi.");
	}

	@Override
	public DataResult<List<JobPosting>> getAllByEmployerId(int employerId) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getAllByEmployerId(employerId));
	}
	
	@Override
	public DataResult<List<JobPostingListDto>> getAllByEmployerIdDto(int employerId) {
		return new SuccessDataResult<List<JobPostingListDto>>(this.jobPostingDao.getAllByEmployerIdDto(employerId), "Firmaya ait tüm iş ilanları listelendi.");
	}

	@Override
	public DataResult<List<JobPostingListDto>> getByEmployer_IdAndIsActiveTrue(int employerId) {
		return new SuccessDataResult<List<JobPostingListDto>>(this.jobPostingDao.getByEmployer_IdAndIsActiveTrue(employerId), "Firmaya ait aktif iş ilanları listelendi.");
	}

	@Override
	public DataResult<List<JobPostingListDto>> getActiveSortedByCreatedDate() {
		//Sort sort = Sort.by(Sort.Direction.DESC,"createdDate");
		//return new SuccessDataResult<List<JobPostingListDto>>(this.jobPostingDao.findAll(sort),"Oluşturma tarihine göre sıralandı.");
		return new SuccessDataResult<List<JobPostingListDto>>(this.jobPostingDao.getActiveSortedByCreatedDate());
	}

	/*
	@Override
	public boolean changeStatus(int employerId, int jobPostingId, boolean status) {
		//return new SuccessDataResult<JobPosting>(this.jobPostingDao.changeStatus.save(employerId, jobPostingId, status), "İş ilanı durumu güncellendi.");
		
		return  new Result(this.jobPostingDao.changeStatus(employerId, jobPostingId, status)).isSuccess();
	}
	*/
	
	@Override
	public Result add(JobPosting jobPosting) {
		jobPosting.setCreatedDate(LocalDate.now());
		jobPosting.setActive(true);
		
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("JobPosting Added.");
	}

	@Override
	public Result update(JobPosting jobPosting) {
		// TODO Auto-generated method stub
		return null;
	}



	


}
