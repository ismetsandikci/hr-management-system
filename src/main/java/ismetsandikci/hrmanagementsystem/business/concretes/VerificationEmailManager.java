package ismetsandikci.hrmanagementsystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ismetsandikci.hrmanagementsystem.business.abstracts.VerificationEmailService;
import ismetsandikci.hrmanagementsystem.dataAccess.abstracts.VerificationEmailDao;
import ismetsandikci.hrmanagementsystem.entities.concretes.VerificationEmail;

@Service
public class VerificationEmailManager implements VerificationEmailService {

	private VerificationEmailDao verificationEmailDao;
	
	@Autowired
	public VerificationEmailManager(VerificationEmailDao verificationEmailDao) {
		super();
		this.verificationEmailDao = verificationEmailDao;
	}

	@Override
	public List<VerificationEmail> getAll() {
		return this.verificationEmailDao.findAll();
	}

}
