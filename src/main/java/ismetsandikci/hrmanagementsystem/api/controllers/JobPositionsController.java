package ismetsandikci.hrmanagementsystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ismetsandikci.hrmanagementsystem.business.abstracts.JobPositionService;
import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {

	private JobPositionService jobPositionService;
	
	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobPosition>> getAll() {
		return this.jobPositionService.getAll();
	}
	
	@GetMapping("/getByTitleName")
	public DataResult<JobPosition> getByTitleName(String titleName) {
		return this.jobPositionService.getByTitleName(titleName);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosition jobPosition) {
		
		return this.jobPositionService.add(jobPosition);
				
	}
}
