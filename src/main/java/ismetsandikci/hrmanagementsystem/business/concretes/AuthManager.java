package ismetsandikci.hrmanagementsystem.business.concretes;

import org.springframework.stereotype.Service;

import ismetsandikci.hrmanagementsystem.business.abstracts.AuthService;
import ismetsandikci.hrmanagementsystem.business.abstracts.CandidateService;
import ismetsandikci.hrmanagementsystem.business.abstracts.EmployerService;
import ismetsandikci.hrmanagementsystem.core.utilities.adapters.verification.mail.ValidationService;
import ismetsandikci.hrmanagementsystem.core.utilities.results.ErrorResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessResult;
import ismetsandikci.hrmanagementsystem.entities.concretes.Candidate;
import ismetsandikci.hrmanagementsystem.entities.concretes.Employer;

@Service("AuthManager")
public class AuthManager implements AuthService {

    private CandidateService candidateService;
    private EmployerService employerService;
    private ValidationService validationService;
    
	public AuthManager(CandidateService candidateService, EmployerService employerService,
			ValidationService validationService) {
		super();
		this.candidateService = candidateService;
		this.employerService = employerService;
		this.validationService = validationService;
	}

	@Override
	public Result registerForCandidate(Candidate candidate, String passwordRepeat) {
		if(!checkPasswordRepeat(candidate.getPassword(),passwordRepeat)) {
			return new ErrorResult("Passwords do not match.");
		}
		
		var result = this.candidateService.add(candidate);
		
		if(result.isSuccess()) {
			if(validationService(candidate.getEmail())) {
				return new SuccessResult("Candidate Registered.");
			}
		}

		return new ErrorResult(result.getMessage());
	}

	@Override
	public Result registerForEmployer(Employer employer, String passwordRepeat) {
		if(!checkPasswordRepeat(employer.getPassword(),passwordRepeat)) {
			return new ErrorResult("Passwords do not match.");
		}

		var result = this.employerService.add(employer);
		
		if(result.isSuccess()) {
			if(validationService(employer.getEmail())) {
				return new SuccessResult("Employer Registered.");
			}
		}
		
		return new ErrorResult(result.getMessage());
	}
	
	private boolean checkPasswordRepeat(String password, String passwordRepeat) {
		if (!password.equals(passwordRepeat)) {
			return false;
		}
		return true;
	}
	
	private boolean validationService(String email) {
		String code = this.validationService.codeGenerator(); //kod ürettir
		if(!this.validationService.sendVerificationCode(email, code)) { //kod ile mail göndert
			return false;
		}
		return true;
	}

}
