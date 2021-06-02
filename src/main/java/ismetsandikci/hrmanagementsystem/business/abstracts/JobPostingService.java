package ismetsandikci.hrmanagementsystem.business.abstracts;

import java.util.List;

import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.entities.concretes.JobPosting;
import ismetsandikci.hrmanagementsystem.entities.dtos.JobPostingListDto;

public interface JobPostingService {

	DataResult<List<JobPosting>> getAll();
	
	DataResult<List<JobPostingListDto>> getAllDto();
	
	DataResult<JobPosting> getById(int id);
	
	DataResult<List<JobPostingListDto>> getByIsActiveTrue();
	
	DataResult<List<JobPosting>> getAllByEmployerId(int employerId);
	
	DataResult<List<JobPostingListDto>> getAllByEmployerIdDto(int employerId);
		
	DataResult<List<JobPostingListDto>> getByEmployer_IdAndIsActiveTrue(int employerId);

	DataResult<List<JobPostingListDto>> getActiveSortedByCreatedDate();

	//boolean changeStatus(int employerId,int jobPostingId, boolean status); //iş ilanı aktif/pasif
	
	Result add(JobPosting jobPosting);
	
	Result update(JobPosting jobPosting);
}
