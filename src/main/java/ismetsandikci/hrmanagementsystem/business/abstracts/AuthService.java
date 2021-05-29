package ismetsandikci.hrmanagementsystem.business.abstracts;

import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.entities.concretes.Candidate;
import ismetsandikci.hrmanagementsystem.entities.concretes.Employer;

public interface AuthService {
	Result registerForCandidate(Candidate candidate, String passwordRepeat);
	Result registerForEmployer(Employer employer, String passwordRepeat);
}
