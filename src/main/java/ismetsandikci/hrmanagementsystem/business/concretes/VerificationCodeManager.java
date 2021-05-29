package ismetsandikci.hrmanagementsystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ismetsandikci.hrmanagementsystem.business.abstracts.VerificationCodeService;
import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.dataAccess.abstracts.VerificationCodeDao;
import ismetsandikci.hrmanagementsystem.entities.concretes.VerificationCode;

@Service("VerificationCodeManager")
public class VerificationCodeManager implements VerificationCodeService {

	private VerificationCodeDao verificationCodeDao;
	
	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao =verificationCodeDao;
	}

	@Override
	public DataResult<List<VerificationCode>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
