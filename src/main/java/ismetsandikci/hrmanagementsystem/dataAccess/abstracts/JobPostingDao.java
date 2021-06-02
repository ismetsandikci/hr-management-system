package ismetsandikci.hrmanagementsystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ismetsandikci.hrmanagementsystem.entities.concretes.JobPosting;
import ismetsandikci.hrmanagementsystem.entities.dtos.JobPostingListDto;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{
	
	JobPosting getById(int id);
	
	@Query("Select new ismetsandikci.hrmanagementsystem.entities.dtos.JobPostingListDto(j.id, e.companyName, p.titleName, j.openPositionsCount, j.createdDate, j.applicationDeadline) From JobPosting j Inner Join j.employer e Inner Join j.jobPosition p Inner Join j.city c where j.isActive=true")
	List<JobPostingListDto> getByIsActiveTrue();
	
	List<JobPosting> getAllByEmployerId(int employerId);
	
	@Query("Select new ismetsandikci.hrmanagementsystem.entities.dtos.JobPostingListDto(j.id, e.companyName, p.titleName, j.openPositionsCount, j.createdDate, j.applicationDeadline) From JobPosting j Inner Join j.employer e Inner Join j.jobPosition p Inner Join j.city c where j.employer.id=:employerId")
	List<JobPostingListDto> getAllByEmployerIdDto(int employerId);
	
	@Query("Select new ismetsandikci.hrmanagementsystem.entities.dtos.JobPostingListDto(j.id, e.companyName, p.titleName, j.openPositionsCount, j.createdDate, j.applicationDeadline) From JobPosting j Inner Join j.employer e Inner Join j.jobPosition p Inner Join j.city c where j.employer.id=:employerId and j.isActive=true")
	List<JobPostingListDto> getByEmployer_IdAndIsActiveTrue(int employerId);
	
	@Query("Select new ismetsandikci.hrmanagementsystem.entities.dtos.JobPostingListDto(j.id, e.companyName, p.titleName, j.openPositionsCount, j.createdDate, j.applicationDeadline) From JobPosting j Inner Join j.employer e Inner Join j.jobPosition p Inner Join j.city c where j.isActive=true Order BY j.createdDate DESC")
	List<JobPostingListDto> getActiveSortedByCreatedDate();
	
	
	//@Query("Update JobPosting Set isActive=:status Where employer.id=:employerId and id=:jobPostingId ")
	//boolean changeStatus(int employerId,int jobPostingId, boolean status);
}
