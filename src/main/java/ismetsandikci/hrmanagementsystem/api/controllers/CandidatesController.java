package ismetsandikci.hrmanagementsystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ismetsandikci.hrmanagementsystem.business.abstracts.CandidateService;
import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.entities.concretes.Candidate;

@RestController
@RequestMapping("api/candidates")
@CrossOrigin
public class CandidatesController {

	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}

	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}
	
	@GetMapping("/getByNationalityId")
	public DataResult<Candidate> getByNationalityId(String nationalityId) {
		return this.candidateService.getByNationalityId(nationalityId);
	}
	
	@GetMapping("/getByEmail")
	public DataResult<Candidate> getByEmail(String emailAddress) {
		return this.candidateService.getByEmail(emailAddress);
	}
	
	@GetMapping("/getById")
	public DataResult<Candidate> getById(int id) {
		return this.candidateService.getById(id);
	}
}
