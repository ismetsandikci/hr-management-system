package ismetsandikci.hrmanagementsystem.business.abstracts;

import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.entities.dtos.CandidateForRegisterDto;
import ismetsandikci.hrmanagementsystem.entities.dtos.EmployerForRegisterDto;
import ismetsandikci.hrmanagementsystem.entities.dtos.LoginForUserDto;

public interface AuthService {
	Result registerForCandidate(CandidateForRegisterDto candidateForRegisterDto);
	Result registerForEmployer(EmployerForRegisterDto employerForRegisterDto);
	Result login(LoginForUserDto loginForUserDto);
}
