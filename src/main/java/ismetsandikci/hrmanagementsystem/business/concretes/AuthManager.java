package ismetsandikci.hrmanagementsystem.business.concretes;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
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
import ismetsandikci.hrmanagementsystem.entities.dtos.CandidateForRegisterDto;
import ismetsandikci.hrmanagementsystem.entities.dtos.EmployerForRegisterDto;
import ismetsandikci.hrmanagementsystem.entities.dtos.LoginForUserDto;

@Service("AuthManager")
public class AuthManager implements AuthService {

    private CandidateService candidateService;
    private EmployerService employerService;
    private ValidationService validationService;
    private ModelMapper modelMapper;
    
    @Autowired
	public AuthManager(CandidateService candidateService, EmployerService employerService,
			ValidationService validationService, ModelMapper modelMapper) {
		super();
		this.candidateService = candidateService;
		this.employerService = employerService;
		this.validationService = validationService;
		
		this.modelMapper = modelMapper;
		this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	@Override
	public Result registerForCandidate(CandidateForRegisterDto candidateForRegisterDto) {
		if(!checkPasswordRepeat(candidateForRegisterDto.getPassword(),candidateForRegisterDto.getRePassword())) {
			return new ErrorResult("Passwords do not match.");
		}
		
		Candidate candidateRegister = modelMapper.map(candidateForRegisterDto, Candidate.class);

		var result = this.candidateService.add(candidateRegister);
		
		if(result.isSuccess()) {
			if(validationService(candidateForRegisterDto.getEmail())) {
				return new SuccessResult("Candidate Registered.");
			}
		}

		return new ErrorResult(result.getMessage());
	}

	@Override
	public Result registerForEmployer(EmployerForRegisterDto employerForRegisterDto) {
		if(!checkPasswordRepeat(employerForRegisterDto.getPassword(),employerForRegisterDto.getRePassword())) {
			return new ErrorResult("Passwords do not match.");
		}

		Employer employerRegister = modelMapper.map(employerForRegisterDto,Employer.class)  ;
		
		var result = this.employerService.add(employerRegister);
		
		if(result.isSuccess()) {
			if(validationService(employerForRegisterDto.getEmail())) {
				return new SuccessResult("Employer Registered.");
			}
		}
		
		return new ErrorResult(result.getMessage());
	}
	
	@Override
	public Result login(LoginForUserDto loginForUserDto) {
		// TODO Auto-generated method stub
		return null;
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
