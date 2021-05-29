package ismetsandikci.hrmanagementsystem.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ismetsandikci.hrmanagementsystem.business.abstracts.CandidateService;
import ismetsandikci.hrmanagementsystem.core.utilities.adapters.verification.mail.EmailValidator;
import ismetsandikci.hrmanagementsystem.core.utilities.adapters.verification.mernis.UserValidationService;
import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.ErrorResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessDataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessResult;
import ismetsandikci.hrmanagementsystem.dataAccess.abstracts.CandidateDao;
import ismetsandikci.hrmanagementsystem.entities.concretes.Candidate;

@Service("CandidateManager")
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserValidationService userValidationService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserValidationService userValidationService) {
		super();
		this.candidateDao = candidateDao;
		this.userValidationService = userValidationService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
	}

	@Override
	public DataResult<Candidate> getByNationalityId(String nationalityId) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findByNationalityId(nationalityId));
	}

	@Override
	public DataResult<Candidate> getByEmail(String emailAddress) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findByEmail(emailAddress));
	}

	@Override
	public Result add(Candidate candidate) {
		if(!validationCondidate(candidate)) {
			return new ErrorResult("Missing data entry.");
		}
		
		if(!checkIfNationalityId(candidate.getNationalityId())) {
			return new ErrorResult("Nationality already exist.");
		}
		
		if(!checkIfRealPerson(candidate)) {
			return new ErrorResult("Person could not be verified.");
		}
		
		if(!checkIfEmailExists(candidate.getEmail())) {
			return new ErrorResult("Email already exist.");
		}
		
		if(!checkEmailFormat(candidate.getEmail())) {
			return new ErrorResult("The e-mail information does not meet the required conditions.");
		}
		
		candidate.setCreatedDate(LocalDate.now());
		candidate.setActive(true);
		
		this.candidateDao.save(candidate);
		return new SuccessResult("Candidate added.");
	}
	
	private boolean validationCondidate(Candidate candidate) {
		if(candidate.getEmail() == null && candidate.getPassword() == null && 
				candidate.getFirstName() == null && candidate.getLastName() == null && 
				candidate.getNationalityId() == null && candidate.getBirthDate() == null) {
			return false;
		}
		return true;
	}
	
	private boolean checkIfNationalityId(String nationalityId) {
		if(this.candidateDao.findByNationalityId(nationalityId) != null) {
			return false;
		}
		return true;
	}
	
	private boolean checkIfRealPerson(Candidate candidate) {
		if(!this.userValidationService.CheckIfRealPerson(
				Long.parseLong(candidate.getNationalityId()), 
				candidate.getFirstName().toUpperCase(), 
				candidate.getLastName().toUpperCase(), 
				candidate.getBirthDate())) {
			return false;
		}
		return true;
	}
	
	private boolean checkIfEmailExists(String emailAddress) {
		if(this.candidateDao.findByEmail(emailAddress) != null) {
			return false;
		}
		return true;
	}
	
	private boolean checkEmailFormat(String emailAddress) {
		if(!EmailValidator.isEmailValid(emailAddress)) {
			return false;
		}
		return true;
	}
}
