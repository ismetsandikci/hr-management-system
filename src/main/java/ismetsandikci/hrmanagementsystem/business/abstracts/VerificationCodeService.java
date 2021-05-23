package ismetsandikci.hrmanagementsystem.business.abstracts;

import java.util.List;

import ismetsandikci.hrmanagementsystem.entities.concretes.VerificationCode;

public interface VerificationCodeService {

	List<VerificationCode> getAll();
}
