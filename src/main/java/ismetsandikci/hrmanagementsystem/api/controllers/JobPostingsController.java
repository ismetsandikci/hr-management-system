package ismetsandikci.hrmanagementsystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ismetsandikci.hrmanagementsystem.business.abstracts.JobPostingService;
import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.entities.concretes.JobPosting;
import ismetsandikci.hrmanagementsystem.entities.dtos.JobPostingListDto;

@RestController
@RequestMapping("/api/jobpostings")
public class JobPostingsController {

	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingsController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosting>> getAll() {
		return this.jobPostingService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<JobPosting> getById(@RequestParam int id) {
		return this.jobPostingService.getById(id);
	}
	
	@GetMapping("/getByIsActiveTrue")
	public DataResult<List<JobPostingListDto>> getByIsActiveTrue() {
		return this.jobPostingService.getByIsActiveTrue();
	}
	
	@GetMapping("/getAllByEmployerIdDto")
	public DataResult<List<JobPostingListDto>> getAllByEmployerIdDto(@RequestParam int employerId) {
		return this.jobPostingService.getAllByEmployerIdDto(employerId);
	}
	
	@GetMapping("/getByEmployer_IdAndIsActiveTrue")
	public DataResult<List<JobPostingListDto>> getByEmployer_IdAndIsActiveTrue(@RequestParam int employerId) {
		return this.jobPostingService.getByEmployer_IdAndIsActiveTrue(employerId);
	}
	
	@GetMapping("/getActiveSortedByCreatedDate")
	public DataResult<List<JobPostingListDto>> getActiveSortedByCreatedDate() {
		return this.jobPostingService.getActiveSortedByCreatedDate();
	}
	
	/*
	@PostMapping("/changeStatus")
	public boolean changeStatus(@RequestParam int employerId, @RequestParam int jobPostingId, @RequestParam boolean status) {
		return this.jobPostingService.changeStatus(employerId, jobPostingId, status );
	}
	*/
	
	@PostMapping("/add")
    public Result add(@RequestBody JobPosting jobPosting){
        return this.jobPostingService.add(jobPosting);
    }
}
