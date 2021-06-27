package ismetsandikci.hrmanagementsystem.business.concretes;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ismetsandikci.hrmanagementsystem.business.abstracts.EmployerService;
import ismetsandikci.hrmanagementsystem.core.utilities.adapters.verification.mail.EmailValidator;
import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.ErrorResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessDataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessResult;
import ismetsandikci.hrmanagementsystem.dataAccess.abstracts.EmployerDao;
import ismetsandikci.hrmanagementsystem.entities.concretes.Employer;

@Service("EmployerManager")
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public DataResult<Employer> getByEmail(String email) {
		return new SuccessDataResult<Employer>(this.employerDao.findByEmail(email));
	}

	@Override
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult<Employer>(this.employerDao.getById(id));
	}

	@Override
	public Result add(Employer employer) {
		
		System.out.println("Sorgu 1");
		
		if(!validationEmployer(employer)) {
			return new ErrorResult("Missing data entry.");
		}
		
		System.out.println("Sorgu 2");
		
		if(!checkIfEmailExists(employer.getEmail())) {
			return new ErrorResult("Email already exist.");
		}
		

		System.out.println("Sorgu 3");
		
		if(!checkEmailFormat(employer.getEmail())) {
			return new ErrorResult("The e-mail information does not meet the required conditions.");
		}

		System.out.println("Sorgu 4");
		
		if(!checkIfEqualEmailAndDomain(employer.getEmail(), employer.getWebAddress())) {
			return new ErrorResult("Email and website do not have the same domain.");
		}

		System.out.println("Sorgu 5");
		
		employer.setCreatedDate(LocalDate.now());
		employer.setActive(true);
		
		this.employerDao.save(employer);
		
		return new SuccessResult("Employer added.");
	}
	
	private boolean validationEmployer(Employer employer) {
		if(employer.getEmail() == null && employer.getPassword() == null && 
				employer.getCompanyName() == null && employer.getWebAddress() == null) { //phone control will be added
			return false;
		}
		return true;
	}
	
	private boolean checkIfEmailExists(String email) {
		if(this.employerDao.findByEmail(email) != null) {	
			return false;
		}
		return true;
	}
	
	private boolean checkEmailFormat(String email) {
		if(!EmailValidator.isEmailValid(email)) {
			return false;
		}
		return true;
	}
	
	private boolean checkIfEqualEmailAndDomain(String email, String website) {

		String[] webAdressKeywords = {"www", "http://www", "https://www"};
		
		String[] emailDomain = email.split("@", 2);
		
		String domain = "";
		String[] websiteDomain = website.split("\\.", 2);
		if(Arrays.asList(webAdressKeywords).contains(websiteDomain[0])) {
			domain = websiteDomain[1];
		}
		else {
			domain = website;
		}

		if (!emailDomain[1].equals(domain)) {
			System.out.println("Domain hatası");
			return false;
		}
		return true;
	}

}
