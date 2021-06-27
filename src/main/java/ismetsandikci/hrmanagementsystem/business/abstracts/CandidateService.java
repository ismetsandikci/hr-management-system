package ismetsandikci.hrmanagementsystem.business.abstracts;

import java.util.List;

import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.entities.concretes.Candidate;

public interface CandidateService {
	
	DataResult<List<Candidate>> getAll();
	
	DataResult<Candidate> getByNationalityId(String nationalityId);
	
	DataResult<Candidate> getByEmail(String emailAddress);
	
	DataResult<Candidate> getById(int id);
	
	Result add(Candidate candidate);
} 
